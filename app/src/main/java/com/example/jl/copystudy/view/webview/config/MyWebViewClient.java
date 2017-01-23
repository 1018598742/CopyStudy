package com.example.jl.copystudy.view.webview.config;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.jl.copystudy.view.webview.WebViewActivity;

/**
 * Created by Administrator on 2017/1/24.
 */

public class MyWebViewClient extends WebViewClient {
    private IWebPageView mIWebPageView;
    private WebViewActivity mActivity;

    public MyWebViewClient(IWebPageView mIWebPageView) {
        this.mIWebPageView = mIWebPageView;
        this.mActivity = (WebViewActivity) mIWebPageView;
    }


//    deprecation弃用
    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {


        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {



        super.onPageFinished(view, url);
    }

    // 视频全屏播放按返回页面被放大的问题
    @Override
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        super.onScaleChanged(view, oldScale, newScale);
        if (newScale - oldScale > 7) {
            view.setInitialScale((int) (oldScale / newScale * 100));//异常放大缩回去
        }
    }
}
