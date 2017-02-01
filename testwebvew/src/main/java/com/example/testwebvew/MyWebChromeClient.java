package com.example.testwebvew;

import android.view.View;
import android.webkit.WebChromeClient;

/**
 * Created by Administrator on 2017/1/26.
 */

public class MyWebChromeClient extends WebChromeClient {
    //通知此页面已经进入全局模式
    @Override
    public void onShowCustomView(View view, CustomViewCallback callback) {
        super.onShowCustomView(view, callback);
    }
    //通知此页面已经退出全局模式
    @Override
    public void onHideCustomView() {
        super.onHideCustomView();
    }
}
