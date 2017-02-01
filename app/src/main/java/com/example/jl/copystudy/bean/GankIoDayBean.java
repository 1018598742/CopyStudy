package com.example.jl.copystudy.bean;

import com.example.jl.copystudy.http.ParamNames;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/20.
 */

public class GankIoDayBean implements Serializable {


    /**
     * category : ["前端","Android","瞎推荐","拓展资源","休息视频","iOS","福利"]
     * error : false
     * results : {"Android":[{"_id":"58807d41421aa911912f52e3","createdAt":"2017-01-19T16:48:01.15Z","desc":"实现 RecyclerView 布局切换动画的示例","images":["http://img.gank.io/589e9554-0c6f-4856-bd8f-c2208f2fdadb"],"publishedAt":"2017-01-22T11:39:29.779Z","source":"web","type":"Android","url":"https://github.com/gjiazhe/LayoutSwitch","used":true,"who":"郭佳哲"},{"_id":"588418ad421aa95ea7cbcf00","createdAt":"2017-01-22T10:27:57.636Z","desc":"Android 通过 JSON \b实现原生 UI 布局，太棒了这个！","images":["http://img.gank.io/a530fc9c-bd23-43f4-a610-6112fb3c8426"],"publishedAt":"2017-01-22T11:39:29.779Z","source":"chrome","type":"Android","url":"https://github.com/flipkart-incubator/proteus","used":true,"who":"代码家"},{"_id":"58841902421aa95ead13c4c1","createdAt":"2017-01-22T10:29:22.989Z","desc":"Android Textview Fading 动画效果。","images":["http://img.gank.io/b11f12b4-233e-4eb8-a0cf-8ff834d6d19f"],"publishedAt":"2017-01-22T11:39:29.779Z","source":"chrome","type":"Android","url":"https://github.com/rosenpin/FadingTextView","used":true,"who":"代码家"},{"_id":"58841a85421aa95eae2d92aa","createdAt":"2017-01-22T10:35:49.542Z","desc":"又一个漂亮的 Android MD 风格日历效果。","images":["http://img.gank.io/58902b99-37a4-432f-8d33-d4feb15f5136"],"publishedAt":"2017-01-22T11:39:29.779Z","source":"chrome","type":"Android","url":"https://github.com/jMavarez/MaterialCalendar","used":true,"who":"代码家"}],"iOS":[{"_id":"58841866421aa95ea7cbceff","createdAt":"2017-01-22T10:26:46.124Z","desc":"Swift 实现的歌词管理和显示组件。","images":["http://img.gank.io/114c2da1-588e-47a6-a63d-c901b10c1f54","http://img.gank.io/64aef0c9-68e6-4d2f-b9e0-1bd05165f83c"],"publishedAt":"2017-01-22T11:39:29.779Z","source":"chrome","type":"iOS","url":"https://github.com/MichaelRow/Lyrics","used":true,"who":"代码家"},{"_id":"588418e7421aa95ead13c4bf","createdAt":"2017-01-22T10:28:55.841Z","desc":"轻量级 Swift FAQ 页面组件。","images":["http://img.gank.io/991a7f6e-9323-4b34-aef3-bd0b9543555f","http://img.gank.io/399a2472-cc8f-4a4a-a9c5-8f5f619f7cae"],"publishedAt":"2017-01-22T11:39:29.779Z","source":"chrome","type":"iOS","url":"https://github.com/mukeshthawani/FAQView","used":true,"who":"代码家"}],"休息视频":[{"_id":"588377e2421aa95ead13c4ba","createdAt":"2017-01-21T23:01:54.902Z","desc":"【阿斗】我是吸血鬼德古拉，几分钟独白魔幻大片《德古拉元年》","publishedAt":"2017-01-22T11:39:29.779Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av8140497/","used":true,"who":"LHF"}],"前端":[{"_id":"588035cb421aa9119735ac4f","createdAt":"2017-01-19T11:43:07.739Z","desc":"TypeScript 入门教程。从 JavaScript 程序员的角度总结思考，循序渐进的理解 TypeScript。","publishedAt":"2017-01-22T11:39:29.779Z","source":"web","type":"前端","url":"https://github.com/xcatliu/typescript-tutorial","used":true,"who":"xcatliu"}],"拓展资源":[{"_id":"5881ec8e421aa91194ca0e50","createdAt":"2017-01-20T18:55:10.776Z","desc":"放假前来一发，ARM 推出的物联网平台 mbed OS 5 可以用了","images":["http://img.gank.io/58cd8757-b349-457b-8926-392cc3d07356","http://img.gank.io/59472ea1-7b66-4a42-989a-639945f68687"],"publishedAt":"2017-01-22T11:39:29.779Z","source":"web","type":"拓展资源","url":"https://makerdiary.co/introducing-mbed-os-5/","used":true,"who":"YottaStone"}],"瞎推荐":[{"_id":"5880e605421aa9119a6ca6b9","createdAt":"2017-01-20T00:15:01.158Z","desc":"基于 Gensim 的 Word2Vec 实践","publishedAt":"2017-01-22T11:39:29.779Z","source":"chrome","type":"瞎推荐","url":"https://zhuanlan.zhihu.com/p/24961011","used":true,"who":"王下邀月熊"},{"_id":"58816eaf421aa9119735ac5a","createdAt":"2017-01-20T09:58:07.681Z","desc":"高斯模糊的算法","images":["http://img.gank.io/c78dfc05-c1bf-4b17-8616-38fbac08e7b1","http://img.gank.io/893e8029-79b9-4071-af18-a70a05e8c0e0","http://img.gank.io/edd8ce57-d1cb-4536-b041-34a2ddabf777"],"publishedAt":"2017-01-22T11:39:29.779Z","source":"chrome","type":"瞎推荐","url":"http://www.ruanyifeng.com/blog/2012/11/gaussian_blur.html","used":true,"who":"LHF"}],"福利":[{"_id":"58841c08421aa95ea9de7a0c","createdAt":"2017-01-22T10:42:16.648Z","desc":"1-22","publishedAt":"2017-01-22T11:39:29.779Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/16229501_482786908558452_6858241750058663936_n.jpg","used":true,"who":"daimajia"}]}
     */
    @ParamNames("error")
    private boolean error;
    @ParamNames("results")
    private ResultsBean results;
    @ParamNames("category")
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class ResultsBean {
        @ParamNames("Android")
        private List<AndroidBean> Android;
        @ParamNames("iOS")
        private List<AndroidBean> iOS;
        @ParamNames("休息视频")
        private List<AndroidBean> restMovie;
        @ParamNames("前端")
        private List<AndroidBean> front;
        @ParamNames("拓展资源")
        private List<AndroidBean> resource;
        @ParamNames("瞎推荐")
        private List<AndroidBean> recommend;
        @ParamNames("福利")
        private List<AndroidBean> welfare;
        @ParamNames("App")
        private List<AndroidBean> app;

        public List<AndroidBean> getApp() {
            return app;
        }

        public List<AndroidBean> getAndroid() {
            return Android;
        }

        public List<AndroidBean> getiOS() {
            return iOS;
        }

        public List<AndroidBean> getRestMovie() {
            return restMovie;
        }

        public List<AndroidBean> getFront() {
            return front;
        }

        public List<AndroidBean> getResource() {
            return resource;
        }

        public List<AndroidBean> getRecommend() {
            return recommend;
        }

        public List<AndroidBean> getWelfare() {
            return welfare;
        }
    }
}
