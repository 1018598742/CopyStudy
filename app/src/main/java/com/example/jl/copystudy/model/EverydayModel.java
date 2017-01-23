package com.example.jl.copystudy.model;

import com.example.jl.copystudy.bean.AndroidBean;
import com.example.jl.copystudy.bean.FrontpageBean;
import com.example.jl.copystudy.bean.GankIoDataBean;
import com.example.jl.copystudy.http.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/1/20.
 */

public class EverydayModel {
    private String year = "2016";
    private String month = "11";
    private String day = "24";

    public void setData(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public interface HomeImpl {
        void loadSuccess(Object object);

        void loadFailed();

        void addSubscription(Subscription subscription);
    }

    /**
     * 轮播图
     *
     * @param listener
     */
    public void showBanncerPager(final HomeImpl listener) {
        Subscription subscription = HttpUtils.getInstance().getDongTingServer().getFrontpage()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FrontpageBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.loadFailed();
                    }

                    @Override
                    public void onNext(FrontpageBean frontpageBean) {
                        listener.loadSuccess(frontpageBean);
                    }
                });
        listener.addSubscription(subscription);

    }

    private List<List<AndroidBean>> lists;

    public void showRecyclerViewData(final HomeImpl listener) {
        Func1<GankIoDataBean, Observable<List<List<AndroidBean>>>> func1 = new Func1<GankIoDataBean, Observable<List<List<AndroidBean>>>>() {
            @Override
            public Observable<List<List<AndroidBean>>> call(GankIoDataBean gankIoDataBean) {
                lists = new ArrayList<>();

                GankIoDataBean.ResultsBean results = gankIoDataBean.getResults();
                if (results.getAndroid() != null && results.getAndroid().size() > 0) {
                    addList(results.getAndroid(), "Android");
                }
                if (results.getWelfare() != null && results.getWelfare().size() > 0) {
                    addList(results.getWelfare(), "福利");
                }
                if (results.getiOS() != null && results.getiOS().size() > 0) {
                    addList(results.getiOS(), "IOS");
                }
                if (results.getRestMovie() != null && results.getRestMovie().size() > 0) {
                    addList(results.getRestMovie(), "休息视频");
                }
                if (results.getResource() != null && results.getResource().size() > 0) {
                    addList(results.getResource(), "拓展资源");
                }
                if (results.getRecommend() != null && results.getRecommend().size() > 0) {
                    addList(results.getRecommend(), "瞎推荐");
                }
                if (results.getFront() != null && results.getFront().size() > 0) {
                    addList(results.getFront(), "前端");
                }
                if (results.getApp() != null && results.getApp().size() > 0) {
                    addList(results.getApp(), "App");
                }

                return Observable.just(lists);
            }
        };

        Observer<List<List<AndroidBean>>> observer = new Observer<List<List<AndroidBean>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                    listener.loadFailed();
            }

            @Override
            public void onNext(List<List<AndroidBean>> lists) {
                listener.loadSuccess(lists);
            }
        };


        Subscription subscribe = HttpUtils.getInstance().getGankioServer().getGankIoDay(year, month, day)
                .flatMap(func1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        listener.addSubscription(subscribe);
    }

    /**
     * 给集合中添加值，lists集合中会至少又一个对象，不论传的arrayList是否为空
     *
     * @param arryList
     * @param typeTitle
     */
    private void addList(List<AndroidBean> arryList, String typeTitle) {
        AndroidBean bean = new AndroidBean();
        bean.setType_title(typeTitle);
        ArrayList<AndroidBean> androidBean = new ArrayList<>();
        androidBean.add(bean);
        lists.add(androidBean);//存入的androidbean对象只有一个type_title有值

        int androidSize = arryList.size();
        if (androidSize > 0 && androidSize < 4) {
            lists.add(arryList);
        } else if (androidSize >= 4) {
            ArrayList<AndroidBean> list1 = new ArrayList<>();
            ArrayList<AndroidBean> list2 = new ArrayList<>();
            for (int i = 0; i < androidSize; i++) {
                if (i < 3) {
                    list1.add(arryList.get(i));
                } else if (i < 6) {
                    list2.add(arryList.get(i));
                }
            }
            lists.add(list1);
            lists.add(list2);
        }
    }
}
