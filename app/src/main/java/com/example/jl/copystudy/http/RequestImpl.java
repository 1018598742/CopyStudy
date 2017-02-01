package com.example.jl.copystudy.http;

import rx.Subscription;

/**
 * Created by Administrator on 2017/2/1.
 */

public interface RequestImpl {
    void loadSucess(Object object);

    void loadFailed();

    void addSubscription(Subscription subscription);
}
