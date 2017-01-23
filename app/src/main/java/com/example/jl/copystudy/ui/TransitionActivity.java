package com.example.jl.copystudy.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jl.copystudy.MainActivity;
import com.example.jl.copystudy.R;
import com.example.jl.copystudy.databinding.ActivityTransitionBinding;
import com.example.jl.copystudy.utils.CommonUtils;

import java.util.Random;

public class TransitionActivity extends AppCompatActivity {
    private ActivityTransitionBinding mBinding;
    private int[] mDrawables = new int[]{R.drawable.b_1, R.drawable.b_2, R.drawable.b_3,
            R.drawable.b_4, R.drawable.b_5, R.drawable.b_6};
    private boolean isIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_transition);
        int drawable = new Random().nextInt(mDrawables.length);
        mBinding.ivPic.setImageDrawable(CommonUtils.getDrawable(mDrawables[drawable]));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toMainActivity();
            }
        }, 2000);

        mBinding.tvJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity();
            }
        });

    }

    private void toMainActivity() {
        if (isIn) {
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        isIn = true;
    }
}
