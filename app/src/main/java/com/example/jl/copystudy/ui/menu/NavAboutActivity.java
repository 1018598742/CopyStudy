package com.example.jl.copystudy.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jl.copystudy.R;

public class NavAboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_about);
    }
    public static void start(Context mcContext){
        Intent intent = new Intent(mcContext,NavAboutActivity.class);
        mcContext.startActivity(intent);
    }
}
