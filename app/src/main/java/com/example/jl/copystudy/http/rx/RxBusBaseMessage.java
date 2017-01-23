package com.example.jl.copystudy.http.rx;

/**
 * Created by Administrator on 2017/1/19.
 */

public class RxBusBaseMessage {
    private int code;
    private Object o;

    public int getCode() {
        return code;
    }

    public Object getO() {
        return o;
    }

    public RxBusBaseMessage(int code, Object o) {

        this.code = code;
        this.o = o;
    }

    public RxBusBaseMessage() {

    }
}
