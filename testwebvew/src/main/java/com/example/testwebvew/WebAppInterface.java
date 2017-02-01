package com.example.testwebvew;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/26.
 */

public class WebAppInterface {
   private Context context;
    public WebAppInterface(Context context){
        this.context = context ;
    }
    @JavascriptInterface
    public void showToast(String info){
        Toast.makeText(context,info+"xinxi", Toast.LENGTH_LONG).show();
    }

}
