package com.example.jl.copystudy.ui.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.example.jl.copystudy.R;
import com.example.jl.copystudy.base.BaseFragment;
import com.example.jl.copystudy.databinding.FragmentGankBinding;
import com.example.jl.copystudy.http.rx.RxBus;
import com.example.jl.copystudy.http.rx.RxCodeConstants;
import com.example.jl.copystudy.ui.gank.child.AndroidFragment;
import com.example.jl.copystudy.ui.gank.child.CustomFragment;
import com.example.jl.copystudy.ui.gank.child.EverydayFragment;
import com.example.jl.copystudy.ui.gank.child.WelfareFragment;
import com.example.jl.copystudy.view.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/1/19.
 * 展示干货的页面
 */

public class GankFragment extends BaseFragment<FragmentGankBinding> {
    @Override
    public int setContent() {
        return R.layout.fragment_gank;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showLoading();
        initFragmentList();
        /**
         * 注意使用的是： getChildFragmentManager，
         * 这样 setOffscreenPageLimit 就可以添加上，保留相邻3个实例，切换时不会卡，
         * 但会内存溢出，在显示时加载数据
         */
        MyFragmentPagerAdapter myAdapter = new MyFragmentPagerAdapter(getChildFragmentManager()
                , mFragments
                , mTitleList);
        bindingView.vpGank.setAdapter(myAdapter);
        //左右加载页面的个数
        bindingView.vpGank.setOffscreenPageLimit(3);
        myAdapter.notifyDataSetChanged();
        // TabLayout.MODE_FIXED固定模式
        // TabLayout.MODE_SCROLLABLE可滚动模式(根据字的长度不同)
        bindingView.tabGank.setTabMode(TabLayout.MODE_FIXED);
        bindingView.tabGank.setupWithViewPager(bindingView.vpGank);
        showContentView();
        //item点击跳转
        initBus();
    }

    /**
     * 每日推荐点击更多跳转
     */
    private void initBus() {
        Subscription subscribe = RxBus.getDefault().toObservable(RxCodeConstants.JUMP_TYPE, Integer.class)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        if (integer == 0) {
                            bindingView.vpGank.setCurrentItem(3);
                        } else if (integer == 1) {
                            bindingView.vpGank.setCurrentItem(1);
                        } else if (integer == 2) {
                            bindingView.vpGank.setCurrentItem(2);
                        }
                    }
                });
        addSubscription(subscribe);
    }


    private List<Fragment> mFragments = new ArrayList<>(4);
    private List<String> mTitleList = new ArrayList<>(4);

    private void initFragmentList() {
        mTitleList.add("每日推荐");
        mTitleList.add("福利");
        mTitleList.add("干货定制");
        mTitleList.add("大安卓");
        mFragments.add(new EverydayFragment());
        mFragments.add(new WelfareFragment());
        mFragments.add(new CustomFragment());
        mFragments.add(new AndroidFragment());

    }
}
