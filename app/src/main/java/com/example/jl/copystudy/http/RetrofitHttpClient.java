package com.example.jl.copystudy.http;

import com.example.jl.copystudy.bean.FrontpageBean;
import com.example.jl.copystudy.bean.GankIoDataBean;
import com.example.jl.copystudy.bean.GankIoDayBean;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/21.
 */

public interface RetrofitHttpClient {
    /**
     * 首页轮播图
     *
     * @return
     */
    @GET("/frontpage/frontpage")
    Observable<FrontpageBean> getFrontpage();

    /**
     * 首页内容需要
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    @GET("/day/{year}/{month}/{day}")
    Observable<GankIoDayBean> getGankIoDay(@Path("year") String year
            , @Path("month") String month, @Path("day") String day);

    @GET("/data/{type}/{pre_page}/{page}")
    Observable<GankIoDataBean> getGankIoData(@Path("type") String type, @Path("page") int page, @Path("pre_page") int pre_page);
}
