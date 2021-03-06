package com.example.jl.copystudy.utils;


import android.view.View;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/1/20.
 * 避免在一秒内触发多次点击
 */

public abstract class PerfectClickListener implements View.OnClickListener {
    //DELAY延迟
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;
    private int id = -1;
    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        int mId = v.getId();
        if (id != mId) {
            id = mId;
            lastClickTime = currentTime;
            onNoDoubleClick(v);
            return;
        }
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }
    protected abstract void onNoDoubleClick(View v);
}
