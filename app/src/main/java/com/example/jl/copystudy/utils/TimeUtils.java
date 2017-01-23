package com.example.jl.copystudy.utils;

import android.text.format.Time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/20.
 */

public class TimeUtils {
    public static String getData() {
        SimpleDateFormat sDataFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = sDataFormat.format(new Date());
        return date;
    }

    /**
     * 获取当前事件是否大于12:30
     *
     * @return
     */
    public static boolean isRightTime() {
        Time t = new Time();// or Time t=new Time("GMT+8"); 加上Time Zone资料。
        t.setToNow();//取得系统时间
        int hour = t.hour;//0-23
        int minute = t.minute;
        return hour > 12 || (hour == 12 && minute >= 30);
    }

    /**
     * 得到上一天的时间
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static ArrayList<String> getLastTime(String year, String month, String day) {
        Calendar calendar = Calendar.getInstance();//得到一个Calendar的实例
        calendar.set(Integer.valueOf(year)
                , Integer.valueOf(month) - 1//月份是从0开始，所以要减一
                , Integer.valueOf(day));
        /*
         calendar.get(Calendar.YEAR)得到的是现在是哪一年
        calendar.get(Calendar.MONDAY)得到的是现在月份的前一个月份的数字和月份从0开始有关
        calendar.get(Calendar.DATE)得到的时现在是哪一天
         */
        int inDay = calendar.get(Calendar.DATE);//得到的是现在是哪一天
        calendar.set(Calendar.DATE, inDay - 1);
        /*
         calendar.roll(Calendar.MONTH,-1);只会对当月-1；不能智能调整年
         calendar.add(Calendar.MONTH,-1);可以智能调整年
         */
        ArrayList<String> list = new ArrayList<>();
        list.add(String.valueOf(calendar.get(Calendar.YEAR)));
        list.add(String.valueOf(calendar.get(Calendar.MONTH) + 1));
        list.add(String.valueOf(calendar.get(Calendar.DATE)));
        return list;
    }
}
