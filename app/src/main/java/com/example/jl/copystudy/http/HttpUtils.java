package com.example.jl.copystudy.http;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit.Ok3Client;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Administrator on 2017/1/19.
 * <p>
 * 网络请求工具类
 * * <p>
 * 豆瓣api:
 * 问题：API限制为每分钟40次，一不小心就超了，马上KEY就被封,用不带KEY的API，每分钟只有可怜的10次。
 * 返回：code:112（rate_limit_exceeded2 IP 访问速度限制）
 * 解决：1.使用每分钟访问次数限制（客户端）2.更换ip (更换wifi)
 * 豆瓣开发者服务使用条款: https://developers.douban.com/wiki/?title=terms
 */

public class HttpUtils {
    private static HttpUtils sHttpUtils;
    private Context context;

    private static final RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.NONE;
    //轮播图
    private final static String API_DONGTING = "http://api.dongting.com";
    //首页图
    private final static String API_GANKIO = "http://gank.io/api";

    private RestAdapter dongTingRestAdapter;
    private static RetrofitHttpClient sDongTingClient;
    private RestAdapter gankIoRestAdapter;
    private static RetrofitHttpClient sGankioClient;

    private Gson gson;

    public void setContext(Context context) {
        this.context = context;
    }

    private HttpUtils() {
    }

    public static HttpUtils getInstance() {
        if (sHttpUtils == null) {
            sHttpUtils = new HttpUtils();
        }
        return sHttpUtils;
    }

    public RetrofitHttpClient getGankioServer() {
        if (sGankioClient == null) {
            sGankioClient = getGankIoRestAdapter().create(RetrofitHttpClient.class);
        }
        return sGankioClient;
    }

    private RestAdapter getGankIoRestAdapter() {
        if (gankIoRestAdapter == null) {
            File cacheFile = new File(context.getApplicationContext().getCacheDir().getAbsolutePath()
                    , "HttpCache");
            int cacheSize = 10 * 1024 * 1024;
            Cache cache = new Cache(cacheFile, cacheSize);
            OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
            okBuilder.cache(cache);
            okBuilder.writeTimeout(20, TimeUnit.SECONDS);
            okBuilder.readTimeout(20, TimeUnit.SECONDS);
            okBuilder.connectTimeout(10, TimeUnit.SECONDS);
            OkHttpClient client = okBuilder.build();

            RestAdapter.Builder builder = new RestAdapter.Builder();
            builder.setClient(new Ok3Client(client));
            builder.setEndpoint(API_GANKIO);//设置远程地址
            builder.setConverter(new GsonConverter(getGson()));
            gankIoRestAdapter = builder.build();
            gankIoRestAdapter.setLogLevel(logLevel);
        }
        return gankIoRestAdapter;
    }

    public RetrofitHttpClient getDongTingServer() {
        if (sDongTingClient == null) {
            sDongTingClient = getDongTingAdapter().create(RetrofitHttpClient.class);
        }
        return sDongTingClient;
    }

    private RestAdapter getDongTingAdapter() {
        if (dongTingRestAdapter == null) {
            File cacheFile = new File(context.getApplicationContext().getCacheDir().getAbsolutePath()
                    , "HttpCache");
            int cacheSize = 10 * 1024 * 1024;
            Cache cache = new Cache(cacheFile, cacheSize);
            OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
            okBuilder.cache(cache);
            okBuilder.readTimeout(20, TimeUnit.SECONDS);
            okBuilder.connectTimeout(10, TimeUnit.SECONDS);
            okBuilder.writeTimeout(20, TimeUnit.SECONDS);
            OkHttpClient client = okBuilder.build();

            RestAdapter.Builder builder = new RestAdapter.Builder();
            builder.setClient(new Ok3Client(client));
            builder.setEndpoint(API_DONGTING);//设置远程地址
            builder.setConverter(new GsonConverter(getGson()));
            dongTingRestAdapter = builder.build();
            dongTingRestAdapter.setLogLevel(logLevel);
        }
        return dongTingRestAdapter;
    }

    private Gson getGson() {
        if (gson == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.setFieldNamingStrategy(new AnnotateNaming());
            builder.serializeNulls();
            builder.excludeFieldsWithModifiers(Modifier.TRANSIENT);
            gson = builder.create();
        }
        return gson;
    }

    private static class AnnotateNaming implements FieldNamingStrategy {

        @Override
        public String translateName(Field f) {
            ParamNames a = f.getAnnotation(ParamNames.class);
            return a != null ? a.value() : FieldNamingPolicy.IDENTITY.translateName(f);
        }
    }

}
