package com.example.jl.copystudy.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jl.copystudy.R;

public class NavDownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_download);
    }

    public static void start(Context mContext){
        Intent intent = new Intent(mContext,NavDownloadActivity.class);
        mContext.startActivity(intent);
    }
}
