package com.example.jl.copystudy.view.viewbigimage;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.jl.copystudy.R;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * 查看大图
 */
public class ViewBigImageActivity extends FragmentActivity implements ViewPager.OnPageChangeListener, PhotoViewAttacher.OnPhotoTapListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_big_image);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPhotoTap(View view, float x, float y) {

    }

    @Override
    public void onOutsidePhotoTap() {

    }
}
