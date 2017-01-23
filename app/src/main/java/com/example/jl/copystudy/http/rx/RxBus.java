package com.example.jl.copystudy.http.rx;

import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Administrator on 2017/1/19.
 * 参考网址: http://hanhailong.com/2015/10/09/RxBus%E2%80%94%E9%80%9A%E8%BF%87RxJava%E6%9D%A5%E6%9B%BF%E6%8D%A2EventBus/
 * http://www.loongwind.com/archives/264.html
 * https://theseyears.gitbooks.io/android-architecture-journey/content/rxbus.html
 */

public class RxBus {
    // volatile, 声明这个字段易变（可能被多个线程使用），
    // Java内存模型负责各个线程的工作区与主存区的该字段的值保持同步，
    // 即一致性。
    private static volatile RxBus mDefaultInstance;

    private RxBus() {
    }

    public static RxBus getDefault() {
        if (mDefaultInstance == null) {
            synchronized (RxBus.class) {
                if (mDefaultInstance == null) {
                    mDefaultInstance = new RxBus();
                }
            }
        }
        return mDefaultInstance;
    }

    private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        _bus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return _bus;
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的观察者
     *
     * @param eventType 事件类型
     * @param <T>       泛型
     * @return
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return _bus.ofType(eventType);
    }

    /**
     * 提供一个新的事件，根据code分发
     *
     * @param code 事件code
     * @param o
     */
    public void post(int code, Object o) {
        _bus.onNext(new RxBusBaseMessage(code, o));
    }

    /**
     * 根据传递的code和 eventType 类型返回特定类型(eventType)的 被观察者
     * 对于注册了code为0，class为voidMessage的观察者，那么就接收不到code为0之外的voidMessage。
     *
     * @param code      事件code
     * @param eventType 事件类型
     * @param <T>       Observable前面的<T>表示一个新的类型，和其他的没关系。
     * @return
     */
    public <T> Observable<T> toObservable(final int code, final Class<T> eventType) {
        return _bus.ofType(RxBusBaseMessage.class)//发射指定类型的数据，其内部就是filter和cast
                .filter(new Func1<RxBusBaseMessage, Boolean>() {
                    @Override
                    public Boolean call(RxBusBaseMessage message) {
                        //过滤code和eventType
                        return message.getCode() == code && message.getO() == eventType;
                    }
                }).map(new Func1<RxBusBaseMessage, Object>() {
                    @Override
                    public Object call(RxBusBaseMessage message) {
                        return message.getO();
                    }
                }).cast(eventType);

    }

    /**
     * 判断是否有订阅者
     *
     * @return
     */
    public boolean hasObservable() {
        return _bus.hasObservers();
    }


}
