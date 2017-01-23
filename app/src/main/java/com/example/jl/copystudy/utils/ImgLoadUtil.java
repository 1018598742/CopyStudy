package com.example.jl.copystudy.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jl.copystudy.R;

import java.util.Random;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 2017/1/19.
 */

public class ImgLoadUtil {
    private static ImgLoadUtil instance;

    //六图的随机图
    private static int[] homeSix = {R.drawable.home_six_1, R.drawable.home_six_2, R.drawable.home_six_3
            , R.drawable.home_six_4, R.drawable.home_six_5, R.drawable.home_six_6, R.drawable.home_six_7
            , R.drawable.home_six_8, R.drawable.home_six_9, R.drawable.home_six_10, R.drawable.home_six_11
            , R.drawable.home_six_12, R.drawable.home_six_13, R.drawable.home_six_14, R.drawable.home_six_15
            , R.drawable.home_six_16, R.drawable.home_six_17, R.drawable.home_six_18, R.drawable.home_six_19
            , R.drawable.home_six_20, R.drawable.home_six_21, R.drawable.home_six_22, R.drawable.home_six_23};
    //两张图的随机图
    private static int[] homeTwo = {R.drawable.home_two_one, R.drawable.home_two_two, R.drawable.home_two_three
            , R.drawable.home_two_four, R.drawable.home_two_five, R.drawable.home_two_six, R.drawable.home_two_eleven
            , R.drawable.home_two_eight, R.drawable.home_two_nine};
    //一张图的随机图
    private static int[] homeOne = {R.drawable.home_one_1, R.drawable.home_one_2, R.drawable.home_one_3, R.drawable.home_one_4
            , R.drawable.home_one_5, R.drawable.home_one_6, R.drawable.home_one_7, R.drawable.home_one_9, R.drawable.home_one_10
            , R.drawable.home_one_11, R.drawable.home_one_12};

    private ImgLoadUtil() {
    }

    public static ImgLoadUtil getInstance() {
        if (instance == null) {
            instance = new ImgLoadUtil();
        }
        return instance;
    }

    /**
     * @param imgNumber    有几张图片要显示
     * @param position     第几张图片
     * @param itemPosition 是第几个item，如android是第一个
     * @param imageView    对应图片控件
     */
    public static void displayRandoom(int imgNumber, int position, int itemPosition, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(getRandomPic(imgNumber, position, itemPosition))
                .placeholder(getDefaultPic(imgNumber, position))
                .error(getDefaultPic(imgNumber, position))
                .crossFade(1500)
                .into(imageView);
    }

    /**
     * @param imgNumber 显示几张图的
     * @param position  （ 目前没用 ）
     * @return
     */
    private static int getDefaultPic(int imgNumber, int position) {
        switch (imgNumber) {
            case 1:
                return R.drawable.img_two_bi_one;
            case 2:
                return R.drawable.img_four_bi_three;
            case 3:
                return R.drawable.img_one_bi_one;
        }
        return R.drawable.img_four_bi_three;
    }

    /**
     * @param imgNumber    是显示几张图片的 1,2,3
     * @param position     （ 目前没用 ）
     * @param itemPosition （ 目前没用 ）
     * @return 返回R.drawable.xx格式 int值
     */
    private static int getRandomPic(int imgNumber, int position, int itemPosition) {
        Random random = new Random();
        int randomInt = 0;
        switch (imgNumber) {
            case 1:
                randomInt = random.nextInt(homeOne.length);
                return homeOne[randomInt];
            case 2:
                randomInt = random.nextInt(homeTwo.length);
                return homeTwo[randomInt];
            case 3:
                randomInt = random.nextInt(homeSix.length);
                return homeSix[randomInt];
        }
        return homeOne[randomInt];
    }

    /**
     * 加载圆形图
     *
     * @param imageView 图片放的位置
     * @param imageUrl  图片的地址
     */
    public static void displayCircle(ImageView imageView, int imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .bitmapTransform(new CropCircleTransformation(imageView.getContext()))
                .crossFade(1000)//设置淡入淡出效果
                .into(imageView);
    }
}
