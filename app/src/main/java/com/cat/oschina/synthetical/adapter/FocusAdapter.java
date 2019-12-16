package com.cat.oschina.synthetical.adapter;

import com.cat.oschina.synthetical.entity.Focus;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FocusAdapter extends BaseQuickAdapter<Focus, BaseViewHolder> {
    public FocusAdapter(int layoutResId, @Nullable List<Focus> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Focus item) {

    }
}
