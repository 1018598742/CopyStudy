package com.example.jl.copystudy.ui.gank.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.jl.copystudy.R;
import com.example.jl.copystudy.adapter.WelfareAdapter;
import com.example.jl.copystudy.app.Constants;
import com.example.jl.copystudy.base.BaseFragment;
import com.example.jl.copystudy.base.baseadapter.OnItemClickListener;
import com.example.jl.copystudy.bean.GankIoDataBean;
import com.example.jl.copystudy.databinding.FragmentWelfareBinding;
import com.example.jl.copystudy.http.HttpUtils;
import com.example.jl.copystudy.http.RequestImpl;
import com.example.jl.copystudy.http.cache.ACache;
import com.example.jl.copystudy.model.GankOtherModel;
import com.example.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by Administrator on 2017/1/19.
 */

public class WelfareFragment extends BaseFragment<FragmentWelfareBinding> {
    private GankOtherModel mModel;
    private ACache aCache;
    private WelfareAdapter mWelfareAdapter;
    private boolean isPrepared = false;
    private boolean isFirst = true;
    private int mPage = 1;
    private GankIoDataBean meiziBean;
    private List<String> imgList = new ArrayList<>();

    @Override
    public int setContent() {
        return R.layout.fragment_welfare;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mModel = new GankOtherModel();
        aCache = ACache.get(getContext());
        bindingView.xrvWelfare.setPullRefreshEnabled(false);
        bindingView.xrvWelfare.clearHeader();
        mWelfareAdapter = new WelfareAdapter();

        bindingView.xrvWelfare.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                mPage++;
                loadWelfareData();
            }
        });
        isPrepared = true;


    }

    private void loadWelfareData() {
        mModel.setData("福利", mPage, HttpUtils.per_page_more);
        mModel.getGankIoData(new RequestImpl() {
            @Override
            public void loadSucess(Object object) {
                showContentView();
                GankIoDataBean gankIoDataBean = (GankIoDataBean) object;
                if (mPage == 1) {
                    if (gankIoDataBean != null && gankIoDataBean.getResults() != null && gankIoDataBean.getResults().size() > 0) {
                        imgList.clear();
                        for (int i = 0; i < gankIoDataBean.getResults().size(); i++) {
                            imgList.add(gankIoDataBean.getResults().get(i).getUrl());
                        }
                        setAdatpter(gankIoDataBean);
                        aCache.remove(Constants.GANK_MEIZI);
                        aCache.put(Constants.GANK_MEIZI, gankIoDataBean, 3000);


                    }
                } else {
                    if (gankIoDataBean != null && gankIoDataBean.getResults() != null && gankIoDataBean.getResults().size() > 0) {
                        bindingView.xrvWelfare.refreshComplete();
                        mWelfareAdapter.addAll(gankIoDataBean.getResults());
                        mWelfareAdapter.notifyDataSetChanged();

                        for (int i = 0; i < gankIoDataBean.getResults().size(); i++) {
                            imgList.add(gankIoDataBean.getResults().get(i).getUrl());
                        }
                    } else {
                        bindingView.xrvWelfare.noMoreLoading();
                    }
                }
            }

            @Override
            public void loadFailed() {
                bindingView.xrvWelfare.refreshComplete();
                if (mWelfareAdapter.getItemCount() == 0) {
                    showError();
                }
                if (mPage > 1) {
                    mPage--;
                }
            }

            @Override
            public void addSubscription(Subscription subscription) {
                WelfareFragment.this.addSubscription(subscription);
            }
        });

    }

    @Override
    protected void loadData() {
        if (!mIsVisible || !isPrepared || !isFirst) {
            return;
        }
        if (meiziBean != null && meiziBean.getResults() != null && meiziBean.getResults().size() > 0) {
            showContentView();
            imgList.clear();
            for (int i = 0; i < meiziBean.getResults().size(); i++) {
                imgList.add(meiziBean.getResults().get(i).getUrl());
            }
            meiziBean = (GankIoDataBean) aCache.getAsObject(Constants.GANK_MEIZI);
            setAdatpter(meiziBean);
        } else {
            loadWelfareData();
        }

    }

    private void setAdatpter(GankIoDataBean gankIoDataBean) {
        mWelfareAdapter.addAll(gankIoDataBean.getResults());
        //构造器中，第一个参数表示列数或者行数，第二个参数表示方向:瀑布流
        bindingView.xrvWelfare.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        bindingView.xrvWelfare.setAdapter(mWelfareAdapter);
        mWelfareAdapter.notifyDataSetChanged();

        mWelfareAdapter.setOnItemClickListener(new OnItemClickListener<GankIoDataBean.ResultsBean>() {

            @Override
            public void onClick(GankIoDataBean.ResultsBean resultsBean, int position) {
                //跳转到查看大图activity图片

            }
        });

        //显示成功后不是第一次了，不再刷新
        isFirst = false;

    }

    @Override
    protected void onRefresh() {
//        super.onRefresh();
        loadWelfareData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
