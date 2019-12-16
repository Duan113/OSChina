package com.cat.oschina.synthetical.adapter;

import com.cat.oschina.synthetical.entity.English;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EnglishAdapter extends BaseQuickAdapter<English, BaseViewHolder> {
    public EnglishAdapter(int layoutResId, @Nullable List<English> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, English item) {

    }
}
