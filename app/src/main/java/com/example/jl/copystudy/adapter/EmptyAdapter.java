package com.example.jl.copystudy.adapter;

import android.view.ViewGroup;

import com.example.jl.copystudy.R;
import com.example.jl.copystudy.base.baseadapter.BaseRecyclerViewAdapter;
import com.example.jl.copystudy.base.baseadapter.BaseRecyclerViewHolder;
import com.example.jl.copystudy.databinding.ItemEmptyBinding;

/**
 * Created by Administrator on 2017/1/23.
 */

public class EmptyAdapter extends BaseRecyclerViewAdapter<String> {
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.item_empty);
    }

    class ViewHolder extends BaseRecyclerViewHolder<String, ItemEmptyBinding> {

        public ViewHolder(ViewGroup viewGroup, int layoutId) {
            super(viewGroup, layoutId);
        }

        @Override
        public void onBindViewHolder(String object, int position) {
            binding.setString(object);
        }
    }

}
