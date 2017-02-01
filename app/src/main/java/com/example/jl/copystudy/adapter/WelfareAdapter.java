package com.example.jl.copystudy.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.example.jl.copystudy.base.baseadapter.BaseRecyclerViewAdapter;
import com.example.jl.copystudy.base.baseadapter.BaseRecyclerViewHolder;
import com.example.jl.copystudy.bean.GankIoDataBean;
import com.example.jl.copystudy.databinding.ItemWelfareBinding;
import com.example.jl.copystudy.utils.DensityUtil;

/**
 * Created by Administrator on 2017/2/1.
 */

public class WelfareAdapter extends BaseRecyclerViewAdapter<GankIoDataBean.ResultsBean> {
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    private class ViewHolder extends BaseRecyclerViewHolder<GankIoDataBean.ResultsBean, ItemWelfareBinding> {

        public ViewHolder(ViewGroup viewGroup, int layoutId) {
            super(viewGroup, layoutId);
        }

        @Override
        public void onBindViewHolder(final GankIoDataBean.ResultsBean resultsBean, final int position) {
            if (position % 2 == 0) {
                DensityUtil.setViewMargin(itemView, false, 12, 6, 12, 0);
            } else {
                DensityUtil.setViewMargin(itemView, false, 6, 12, 12, 0);
            }
            binding.setBean(resultsBean);
            //防抖动
            binding.executePendingBindings();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClick(resultsBean, position);
                    }
                }
            });

        }
    }
}
