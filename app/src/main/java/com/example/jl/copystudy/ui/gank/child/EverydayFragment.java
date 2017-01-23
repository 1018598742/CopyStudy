package com.example.jl.copystudy.ui.gank.child;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.example.jl.copystudy.R;
import com.example.jl.copystudy.adapter.EmptyAdapter;
import com.example.jl.copystudy.adapter.EverydayAdapter;
import com.example.jl.copystudy.app.Constants;
import com.example.jl.copystudy.base.BaseFragment;
import com.example.jl.copystudy.bean.AndroidBean;
import com.example.jl.copystudy.bean.FrontpageBean;
import com.example.jl.copystudy.databinding.FooterItemEverydayBinding;
import com.example.jl.copystudy.databinding.FragmentEverydayBinding;
import com.example.jl.copystudy.databinding.HeaderItemEverydayBinding;
import com.example.jl.copystudy.http.cache.ACache;
import com.example.jl.copystudy.http.rx.RxBus;
import com.example.jl.copystudy.http.rx.RxBusBaseMessage;
import com.example.jl.copystudy.http.rx.RxCodeConstants;
import com.example.jl.copystudy.model.EverydayModel;
import com.example.jl.copystudy.utils.CommonUtils;
import com.example.jl.copystudy.utils.GlideImageLoader;
import com.example.jl.copystudy.utils.PerfectClickListener;
import com.example.jl.copystudy.utils.SPUtils;
import com.example.jl.copystudy.utils.TimeUtils;
import com.example.jl.copystudy.view.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by Administrator on 2017/1/19.
 */

public class EverydayFragment extends BaseFragment<FragmentEverydayBinding> {
    @Override
    public int setContent() {
        return R.layout.fragment_everyday;
    }


    private RotateAnimation animation;
    private ACache maCache;//轻量级的缓存文件
    private EverydayModel mEverydayModel;
    private ArrayList<String> mBannerImages;
    private HeaderItemEverydayBinding mHeaderBinding;
    private boolean mIsPrepared;
    private View mHeaderView;
    private View mFooterView;
    private FooterItemEverydayBinding mFooterBinding;
    private boolean isOldDayRequest = false;
    private boolean mIsFirst = true;
    private ArrayList<List<AndroidBean>> mLists;
    private EverydayAdapter mEverydayAdapter;
    //是否正在刷新避免重复刷新
    private boolean mIsLoading = false;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showContentView();
        bindingView.llLoading.setVisibility(View.VISIBLE);

        // 旋转变化动画
        animation = new RotateAnimation(0f// float fromDegrees 旋转的开始角度
                , 360f //float toDegrees 旋转的结束角度
                , Animation.RELATIVE_TO_SELF //int pivotXType X轴的伸缩模式
                , 0.5f // float pivotXValue X坐标的伸缩值
                , animation.RELATIVE_TO_SELF // int pivotYType Y轴的伸缩模式
                , 0.5f // float pivotYValue Y坐标的伸缩值
        );
        animation.setDuration(3000);//设置动画持续时间
        animation.setInterpolator(new LinearInterpolator());//不停顿
        animation.setRepeatCount(10);//设置一个动画效果重复执行的次数
        bindingView.ivLoading.setAnimation(animation);
        animation.startNow();

        maCache = ACache.get(getContext());
        mEverydayModel = new EverydayModel();
        mBannerImages = (ArrayList<String>) maCache.getAsObject(Constants.BANNER_PIC);


        mHeaderBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext())
                , R.layout.header_item_everyday
                , null
                , false);
        //设置本地数据点击事件等
        initLocalSetting();
        initRecyclerView();

        mIsPrepared = true;
        /*
        因为启动时先走loadData(),再走onActivityCreated(),
        所以要额外调用loadData(),不然最初不会加载内容
         */
        loadData();


    }

    private void initRecyclerView() {
        bindingView.xrvEveryday.setPullRefreshEnabled(false);
        bindingView.xrvEveryday.setLoadingMoreEnabled(false);
        if (mHeaderView == null) {
            mHeaderView = mHeaderBinding.getRoot();
            bindingView.xrvEveryday.addHeaderView(mHeaderView);
        }
        if (mFooterView == null) {
            mFooterBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(getContext())
                    , R.layout.footer_item_everyday
                    , null, false);
            mFooterView = mFooterBinding.getRoot();
            bindingView.xrvEveryday.addFootView(mFooterView, true);
            bindingView.xrvEveryday.noMoreLoading();
        }
        //以下均为recyclerview中的方法
        bindingView.xrvEveryday.setLayoutManager(new LinearLayoutManager(getContext()));
        //需加，不然滑动不流畅
        bindingView.xrvEveryday.setNestedScrollingEnabled(false);
        bindingView.xrvEveryday.setHasFixedSize(false);
        bindingView.xrvEveryday.setItemAnimator(new DefaultItemAnimator());
    }

    private ArrayList<String> getTodayTime() {
        String data = TimeUtils.getData();
        String[] split = data.split("-");
        String year = split[0];
        String month = split[1];
        String day = split[2];
        ArrayList<String> lists = new ArrayList<>();
        lists.add(year);
        lists.add(month);
        lists.add(day);
        return lists;
    }

    private void initLocalSetting() {
        mEverydayModel.setData(getTodayTime().get(0), getTodayTime().get(1), getTodayTime().get(2));
        mHeaderBinding.includeEveryday.tvDailyText.setText(getTodayTime().get(2).indexOf("0")
                == 0 ? getTodayTime().get(2).replace("0", "") : getTodayTime().get(2));
        mHeaderBinding.includeEveryday.ibXiandu.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                WebViewActivity.loadUrl(v.getContext(), "https://gank.io/xiandu", "加载中...");
            }
        });
        mHeaderBinding.includeEveryday.ibMovieHot.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                RxBus.getDefault().post(RxCodeConstants.JUMP_TYPE_TO_ONE, new RxBusBaseMessage());
            }
        });
    }

    @Override
    protected void loadData() {
        //显示时轮播图滚动
        if (mHeaderBinding != null && mHeaderBinding.banner != null) {
            mHeaderBinding.banner.startAutoPlay();
            mHeaderBinding.banner.setDelayTime(5000);
        }
        if (!mIsVisible || !mIsPrepared) {
            return;
        }
        String oneData = SPUtils.getString("every_data", "2016-11-26");
        if (!oneData.equals(TimeUtils.getData())) {//是第二天
            if (TimeUtils.isRightTime()) {//大于12:30请求加载
                showRotaLoading(true);
                loadBannerPicture();
//                showContentView();
                showContentData();
            } else {//第二天12:30之前 去缓存，没有请求前一天
                ArrayList<String> lastTime = TimeUtils.getLastTime(getTodayTime().get(0)
                        , getTodayTime().get(1)
                        , getTodayTime().get(2));
                mEverydayModel.setData(lastTime.get(0), lastTime.get(1), lastTime.get(2));
                isOldDayRequest = true;
                getACacheData();
            }

        } else {//当天，取缓存，没有，请求当天
            isOldDayRequest = false;
            getACacheData();
        }

    }

    /**
     * 取缓存
     */
    private void getACacheData() {
        if (!mIsFirst) {
            return;
        }
        //轮播图的缓存
        if (mBannerImages != null && mBannerImages.size() > 0) {
            mHeaderBinding.banner.setImages(mBannerImages)
                    .setImageLoader(new GlideImageLoader())
                    .start();
        } else {
            loadBannerPicture();
        }
        //内容的缓存
        mLists = (ArrayList<List<AndroidBean>>) maCache.getAsObject(Constants.EVERYDAY_CONTENT);
        if (mLists != null && mLists.size() > 0) {
            setAdapter(mLists);
        } else {
            showRotaLoading(true);
            showContentData();
        }

    }

    /**
     * 展示recyclerview内容
     *
     * @param mLists
     */
    private void setAdapter(ArrayList<List<AndroidBean>> mLists) {
        showRotaLoading(false);
        if (mEverydayAdapter == null) {
            mEverydayAdapter = new EverydayAdapter();
        } else {
            mEverydayAdapter.clear();
        }
        mEverydayAdapter.addAll(mLists);
        bindingView.xrvEveryday.setAdapter(mEverydayAdapter);
        mEverydayAdapter.notifyDataSetChanged();

        maCache.remove(Constants.EVERYDAY_CONTENT);
        //缓存三天，这样就能取到缓存了，下面时间单位秒
        maCache.put(Constants.EVERYDAY_CONTENT, mLists, 259200);
        if (isOldDayRequest) {
            ArrayList<String> lastTime = TimeUtils.getLastTime(getTodayTime().get(0), getTodayTime().get(1), getTodayTime().get(2));
            SPUtils.putString("every_data", lastTime.get(0) + "-" + lastTime.get(1) + "-" + lastTime.get(2));
        } else {
            //保存请求的日期
            SPUtils.putString("every_data", TimeUtils.getData());
        }
        mIsFirst = false;
        mIsLoading = false;
    }

    /**
     * 加载正文内容
     */
    private void showContentData() {
        mEverydayModel.showRecyclerViewData(new EverydayModel.HomeImpl() {
            @Override
            public void loadSuccess(Object object) {
                if (mLists != null) {
                    mLists.clear();
                }
                mLists = (ArrayList<List<AndroidBean>>) object;
                if (mLists.size() > 0 && mLists.get(0).size() > 0) {
                    setAdapter(mLists);
                } else {
                    if (mEverydayAdapter != null) {
                        mEverydayAdapter = null;
                    }
                    setEmptyAdapter();
                }

            }

            @Override
            public void loadFailed() {
                showError();
            }

            @Override
            public void addSubscription(Subscription subscription) {
                EverydayFragment.this.addSubscription(subscription);
            }
        });
    }

    private void setEmptyAdapter() {
        showRotaLoading(false);

        EmptyAdapter emptyAdapter = new EmptyAdapter();
        ArrayList<String> list = new ArrayList<>();
        list.add(CommonUtils.getString(R.string.string_everyday_empty));
        emptyAdapter.addAll(list);
        bindingView.xrvEveryday.setAdapter(emptyAdapter);

        //保存请求的日期
        SPUtils.putString("everyday_data", TimeUtils.getData());

        mIsFirst = false;
        mIsLoading = false;
    }

    private void showRotaLoading(boolean isLoading) {
        if (isLoading) {
            bindingView.llLoading.setVisibility(View.VISIBLE);
            bindingView.xrvEveryday.setVisibility(View.GONE);
            animation.startNow();
        } else {
            bindingView.llLoading.setVisibility(View.GONE);
            bindingView.xrvEveryday.setVisibility(View.VISIBLE);
            animation.cancel();
        }
    }

    /**
     * 轮播图
     */
    private void loadBannerPicture() {
        mEverydayModel.showBanncerPager(new EverydayModel.HomeImpl() {
            @Override
            public void loadSuccess(Object object) {
                if (mBannerImages == null) {
                    mBannerImages = new ArrayList<String>();
                } else {
                    mBannerImages.clear();
                }
                FrontpageBean frontpageBean = (FrontpageBean) object;
                List<FrontpageBean.DataBeanX.DataBean> data = null;
                if (frontpageBean != null
                        && frontpageBean.getData() != null
                        && frontpageBean.getData().get(0) != null
                        && frontpageBean.getData().get(0).getData() != null) {
                    data = frontpageBean.getData().get(0).getData();
                }
                if (data != null && data.size() > 0) {
                    for (int i = 0; i < data.size(); i++) {
                        //获取所有图片的网址存入mBanerImages
                        String picUrl = data.get(i).getPicUrl();
                        mBannerImages.add(picUrl);
                    }
                    //轮播控件banner的用法
                    //banner.setImages(图片网址的集合).setImageLoader(实例继承ImageLoader的类).start();
                    mHeaderBinding.banner.setImages(mBannerImages)
                            .setImageLoader(new GlideImageLoader()).start();
                    maCache.remove(Constants.BANNER_PIC);
                    maCache.put(Constants.BANNER_PIC, mBannerImages, 30000);//缓存30秒
                }
            }

            @Override
            public void loadFailed() {

            }

            @Override
            public void addSubscription(Subscription subscription) {
                EverydayFragment.this.addSubscription(subscription);
            }
        });

    }
}
