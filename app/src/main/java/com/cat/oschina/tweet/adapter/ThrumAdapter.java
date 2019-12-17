package com.cat.oschina.tweet.adapter;

import com.cat.oschina.tweet.entity.Thrum;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ThrumAdapter extends BaseQuickAdapter<Thrum, BaseViewHolder> {
    public ThrumAdapter(int layoutResId, @Nullable List<Thrum> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Thrum item) {

    }
}
