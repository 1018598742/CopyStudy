package com.example.jl.copystudy.view.webview;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.jl.copystudy.R;
import com.example.jl.copystudy.databinding.ActivityOneWebViewBinding;
import com.example.jl.copystudy.utils.CommonUtils;
import com.jaeger.library.StatusBarUtil;

public class OneWebViewActivity extends AppCompatActivity {
    private ActivityOneWebViewBinding mBinding;
    private Toolbar mToolbar;
    private WebView mWebView;
    private ProgressBar mProgressBar;
    private String mTitle;
    private String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_one_web_view);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_one_web_view);
        getLoadData();
        initView();
        initTitle();
        showWebView();
    }

    private void showWebView() {
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(mUrl);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initTitle() {
        StatusBarUtil.setColor(this, CommonUtils.getColor(R.color.colorTheme),0);
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayShowTitleEnabled(false);
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeAsUpIndicator(R.drawable.icon_back);
        }
        setTitle(mTitle);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void getLoadData() {
        Intent intent = getIntent();
        mTitle = intent.getStringExtra("mTitle");
        mUrl = intent.getStringExtra("mUrl");

    }

    private void initView() {
        mToolbar = mBinding.oneToolbar;
        mWebView = mBinding.oneWebView;
        mProgressBar = mBinding.oneProgressbar;
    }

    public static void loadUrl(Context context, String url, String title) {
        Intent intent = new Intent(context, OneWebViewActivity.class);
        intent.putExtra("mTitle", title);
        intent.putExtra("mUrl", url);
        context.startActivity(intent);
    }
}
