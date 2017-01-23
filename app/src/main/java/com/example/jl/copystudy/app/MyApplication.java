package com.example.jl.copystudy.app;

import android.app.Application;

import com.example.jl.copystudy.http.HttpUtils;

/**
 * Created by Administrator on 2017/1/18.
 */

public class MyApplication extends Application {
    private static MyApplication application;

    public static MyApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        HttpUtils.getInstance().setContext(getApplicationContext());
    }
}
