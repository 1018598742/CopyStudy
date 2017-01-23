package com.example.jl.copystudy.view.webview.config;

import android.view.View;

/**
 * Created by Administrator on 2017/1/23.
 */

public interface IWebPageView {
    //    隐藏进度条
    void hideProgressBar();

    //    显示WebView
    void showWebView();

    //    隐藏WebView
    void hideWebView();

    //    进度条先加载到90，在加载到100
    void startProgress();

    //    进度条变化时调用
    void progressChanged(int progress);

    //    添加js监听
    void addImageClickListener();

    //    播放网络视频全屏调用
    void fullViewAddView(View view);

    void showVideoFullView();

    void hideViderFullView();
}
