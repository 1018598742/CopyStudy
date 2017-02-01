package com.example.jl.copystudy.model;

import com.example.jl.copystudy.bean.GankIoDataBean;
import com.example.jl.copystudy.http.HttpUtils;
import com.example.jl.copystudy.http.RequestImpl;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/2/1.
 */

public class GankOtherModel {
    private String id;
    private int page;
    private int per_page;
    public void setData(String id,int page,int per_page){
        this.id = id;
        this.page = page;
        this.per_page = per_page;
    }
    public void getGankIoData(final RequestImpl listener){
        Subscription subscribe = HttpUtils.getInstance().getGankioServer().getGankIoData(id, page, per_page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankIoDataBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.loadFailed();
                    }

                    @Override
                    public void onNext(GankIoDataBean gankIoDataBean) {
                        listener.loadSucess(gankIoDataBean);
                    }
                });
        listener.addSubscription(subscribe);
    }
}
