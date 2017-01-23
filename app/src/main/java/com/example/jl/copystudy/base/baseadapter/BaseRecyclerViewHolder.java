package com.example.jl.copystudy.base.baseadapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/1/21.
 */

public abstract class BaseRecyclerViewHolder<T, D extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public D binding;

    /*//原始生成的
    public BaseRecyclerViewViewHolder(View itemView) {
        super(itemView);
    }*/
    public BaseRecyclerViewHolder(ViewGroup viewGroup, int layoutId) {
        //注意要依附 viewGroup，不然显示 item 不全
        super(DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext())
                , layoutId
                , viewGroup
                , false)
                .getRoot());
        binding = DataBindingUtil.getBinding(this.itemView);
    }

    /**
     *
     * @param object the data of bind
     * @param position the item position of recyclerView
     */
    public abstract void onBindViewHolder(T object,final int position);

    /**
     * 当数据改变时，binding会在下一帧去改变数据，如果我们需要立即改变，就去调用executePendingBindings方法。
     * @param object
     * @param position
     */
    void onBaseBindViewHolder(T object,final int position){
        onBindViewHolder(object,position);
        binding.executePendingBindings();
    }
}
