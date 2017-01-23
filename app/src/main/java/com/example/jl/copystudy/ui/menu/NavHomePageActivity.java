package com.example.jl.copystudy.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jl.copystudy.R;

public class NavHomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_home_page);
    }
    public static void start(Context mContext){
        Intent intent = new Intent(mContext,NavHomePageActivity.class);
        mContext.startActivity(intent);
    }
}
