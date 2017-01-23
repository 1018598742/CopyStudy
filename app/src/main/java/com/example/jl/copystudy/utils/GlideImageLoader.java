package com.example.jl.copystudy.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jl.copystudy.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2017/1/21.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path)
                .placeholder(R.drawable.img_two_bi_one)//设置占位符
                .error(R.drawable.img_two_bi_one)
                .crossFade(1000)//设置淡入淡出效果
                .into(imageView);
    }
}
