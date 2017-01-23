package com.example.jl.copystudy.bean;

import com.example.jl.copystudy.http.ParamNames;

import java.io.Serializable;
import java.util.List;

/**
 * 首页item bean
 * Created by Administrator on 2017/1/21.
 */

public class AndroidBean implements Serializable{

    //存储单独设置的信息，用来显示title
    @ParamNames("type_title")
    private String type_title;

    @ParamNames("_id")
    private String _id;
    @ParamNames("createdAt")
    private String createdAt;
    @ParamNames("desc")
    private String desc;
    @ParamNames("publishedAt")
    private String publishedAt;
    @ParamNames("type")
    private String type;
    @ParamNames("url")
    private String url;
    @ParamNames("used")
    private boolean used;
    @ParamNames("who")
    private String who;

    @ParamNames("source")
    private String source;
    @ParamNames("images")
    private List<String> images;

    public String getType_title() {
        return type_title;
    }

    public String get_id() {
        return _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public boolean isUsed() {
        return used;
    }

    public String getWho() {
        return who;
    }

    public String getSource() {
        return source;
    }

    public List<String> getImages() {
        return images;
    }

    public void setType_title(String type_title) {
        this.type_title = type_title;
    }
}
