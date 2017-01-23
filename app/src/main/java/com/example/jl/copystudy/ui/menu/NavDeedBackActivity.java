package com.example.jl.copystudy.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jl.copystudy.R;

public class NavDeedBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_deed_back);
    }
    public static void start(Context mContext){
        Intent intent = new Intent(mContext,NavDeedBackActivity.class);
        mContext.startActivity(intent);
    }
}
