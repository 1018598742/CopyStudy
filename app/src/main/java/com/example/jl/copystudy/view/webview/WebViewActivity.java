package com.example.jl.copystudy.view.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.jl.copystudy.R;
import com.example.jl.copystudy.utils.CommonUtils;
import com.example.jl.copystudy.view.webview.config.IWebPageView;
import com.example.jl.copystudy.view.webview.config.ImageClickInterface;
import com.example.jl.copystudy.view.webview.config.MyWebChromeClient;
import com.example.jl.copystudy.view.webview.config.MyWebViewClient;
import com.jaeger.library.StatusBarUtil;

/**
 * 网页可以处理:
 * 点击相应控件:拨打电话、发送短信、发送邮件、上传图片、播放视频
 * 进度条、返回网页上一层、显示网页标题
 * Thanks to: https://github.com/youlookwhat/WebViewStudy
 * contact me: http://www.jianshu.com/users/e43c6e979831/latest_articles
 */
public class WebViewActivity extends AppCompatActivity implements IWebPageView {

    private String mTitle;
    private String mUrl;
    private ProgressBar mProgressBar;
    private WebView webView;
    private FrameLayout viderFullView;
    private Toolbar mTitleToolbar;
    private MyWebChromeClient myWebChromeClient;
    //进度条是否加载到90%
    private boolean mProgress90;
    //网页是否加载完成
    private boolean mPageFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getIntentData();
        initTitle();
        initWebView();
        webView.loadUrl(mUrl);
    }

    private void initWebView() {
        mProgressBar.setVisibility(View.VISIBLE);
        WebSettings ws = webView.getSettings();
//        网页内容宽度是否可以大于控件的宽度
        ws.setLoadWithOverviewMode(false);
//        保存表单数据
        ws.setSaveFormData(true);
//        是否应该支持使用其屏幕缩放控件和手势缩放
        ws.setSupportZoom(true);
        ws.setBuiltInZoomControls(true);
        ws.setDisplayZoomControls(false);
//        启动应用缓存
        ws.setAppCacheEnabled(true);
//        设置缓存模式
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);
        // setDefaultZoom  api19被弃用
//        设置此属性，可任意比例缩放
        ws.setUseWideViewPort(true);
//        缩放比例1
        webView.setInitialScale(1);
//        告诉webview启用javascript执行，默认false
        ws.setJavaScriptEnabled(true);
//        页面加载以后，在放开图片
        ws.setBlockNetworkImage(false);
//        使用localStorage则必须打开
        ws.setDomStorageEnabled(true);
//        排版适应屏幕
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        webview是否支持多个窗口
        ws.setSupportMultipleWindows(true);
//        webview从5.0开始默认不允许混合模式,https中不能加载http资源,需要设置开启。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ws.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
//        设置字体默认缩放大小(改变网页字体大小,setTextSize  api14被弃用)
        ws.setTextZoom(100);
        myWebChromeClient = new MyWebChromeClient(this);
        webView.setWebChromeClient(myWebChromeClient);
        //与js交互
        webView.addJavascriptInterface(new ImageClickInterface(this), "injectedObject");
        webView.setWebViewClient(new MyWebViewClient(this));

    }

    private void initTitle() {
        // 设置状态栏颜色
        StatusBarUtil.setColor(this, CommonUtils.getColor(R.color.colorTheme), 0);
        mProgressBar = ((ProgressBar) findViewById(R.id.pb_progress));
        webView = ((WebView) findViewById(R.id.webview_detail));
        viderFullView = ((FrameLayout) findViewById(R.id.video_fullView));
        mTitleToolbar = ((Toolbar) findViewById(R.id.title_tool_bar));
        setSupportActionBar(mTitleToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认title显示
            actionBar.setDisplayShowTitleEnabled(false);
            //给左上角图标加上一个返回的图标
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon_back);
        }
        setTitle(mTitle);
//        navigation导航
        mTitleToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    private void getIntentData() {
        if (getIntent() != null) {
            mUrl = getIntent().getStringExtra("mUrl");
            mTitle = getIntent().getStringExtra("mTitle");
        }
    }

    /**
     * 打开网页
     *
     * @param mContext
     * @param mUrl
     * @param mTitle
     */
    public static void loadUrl(Context mContext, String mUrl, String mTitle) {
        Intent intent = new Intent(mContext, WebViewActivity.class);
        intent.putExtra("mUrl", mUrl);
        intent.putExtra("mTitle", mTitle);
        mContext.startActivity(intent);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showWebView() {
        webView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideWebView() {
        webView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void startProgress() {
        startProgress90();
    }

    /**
     * 进度条假装加载到90%
     */
    private void startProgress90() {
        for (int i = 0; i < 900; i++) {
            final int progress = i + 1;
            mProgressBar.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mProgressBar.setProgress(progress);
                    if (progress == 900) {
                        mProgress90 = true;
                        if (mPageFinish) {
                            startProgress90to100();
                        }

                    }
                }
            }, (i + 1) * 2);

        }
    }

    /**
     * 进度条加载到100%
     */
    private void startProgress90to100() {
        for (int i = 900; i < 1000; i++) {
            final int progress = i + 1;
            mProgressBar.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mProgressBar.setProgress(progress);
                    if (progress == 1000) {
                        mProgressBar.setVisibility(View.GONE);
                    }
                }
            }, (i + 1) * 2);

        }
    }

    @Override
    public void progressChanged(int newProgress) {
        if (mProgress90){
            int progress = newProgress * 100;
            if (progress > 900) {
                mProgressBar.setProgress(progress);
                if (progress == 1000){
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        }
    }

    @Override
    public void addImageClickListener() {

    }

    @Override
    public void fullViewAddView(View view) {

    }

    @Override
    public void showVideoFullView() {

    }

    @Override
    public void hideViderFullView() {

    }
}
