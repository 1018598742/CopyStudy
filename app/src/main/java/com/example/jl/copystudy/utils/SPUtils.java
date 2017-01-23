package com.example.jl.copystudy.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.jl.copystudy.app.MyApplication;

/**
 * Created by Administrator on 2017/1/21.
 */

public class SPUtils {
    private static String CONFIG = "config";

    /**
     * 获取SharedPreferences实例对象
     *
     * @param fileName
     * @return
     */
    private static SharedPreferences getSharedPreferences(String fileName) {
        return MyApplication.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    /**
     * 保存一个string类型的值
     * apply提交和commit提交不同
     * apply没有返回值
     * apply属于异步，从一定程度提高效率
     *
     * @param key
     * @param value
     */
    public static void putString(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences(CONFIG).edit();
        editor.putString(key, value).apply();
    }

    /**
     * 获取String的value
     *
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(String key, String defValue) {
        SharedPreferences sp = getSharedPreferences(CONFIG);
        return sp.getString(key, defValue);
    }
}
