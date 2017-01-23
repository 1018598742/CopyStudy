package com.example.jl.copystudy.view.webview.config;

import android.content.pm.ActivityInfo;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.example.jl.copystudy.view.webview.WebViewActivity;

/**
 * Created by Administrator on 2017/1/23.
 * - 播放网络视频配置
 * - 上传图片(兼容)
 * 点击空白区域的左边,因是公司图片,自己编辑过,所以显示不全,见谅
 */

public class MyWebChromeClient extends WebChromeClient {
    private IWebPageView mIWebPageView;
    private WebViewActivity mActivity;
    private View mXCustomView;
    private CustomViewCallback mCustomViewCallback;

    public MyWebChromeClient(IWebPageView mIWebPageView) {
        this.mIWebPageView = mIWebPageView;
        this.mActivity = (WebViewActivity) mIWebPageView;
    }

    //播放视频时全屏调用的方法
    @Override
    public void onShowCustomView(View view, CustomViewCallback callback) {
        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mIWebPageView.hideWebView();
        // 如果一个视图已经存在，那么立刻终止并新建一个
        if (mXCustomView != null) {
            callback.onCustomViewHidden();
            return;
        }
        mActivity.fullViewAddView(view);
        mXCustomView = view;
        mCustomViewCallback = callback;
        mIWebPageView.showVideoFullView();
    }

    //退出全屏时调用
    @Override
    public void onHideCustomView() {
        if (mXCustomView == null) {
            return;
        }
        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mXCustomView.setVisibility(View.GONE);
//        mActivity.getvideo
    }

    //视频加载时进程loading
    @Override
    public View getVideoLoadingProgressView() {
        return super.getVideoLoadingProgressView();
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);
    }
}
