package com.king.oschina.tweet.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.king.oschina.tweet.entity.Data;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataAdapter extends BaseQuickAdapter<Data, BaseViewHolder> {
    public DataAdapter(int layoutResId, @Nullable List<Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Data item) {

    }
}