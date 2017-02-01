package com.example.testwebvew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.testwebvew.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private WebView mWebVew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       mBinding =  DataBindingUtil.setContentView(this,R.layout.activity_main);
        mWebVew = mBinding.webview;
//        mBinding.webview.loadUrl("https://github.com/qinci/EdgeTranslucent");
            mWebVew.loadUrl("https://movie.douban.com/subject/21324900/cinema/hengshui/");
        WebSettings webSettings = mBinding.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mBinding.webview.addJavascriptInterface(new WebAppInterface(this),"android");
        mBinding.webview.setWebViewClient(new WebViewClient());
        mWebVew.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                super.onShowCustomView(view, callback);
            }

            @Override
            public void onHideCustomView() {
                super.onHideCustomView();
            }
        });



    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebVew.canGoBack()) {
            mWebVew.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
