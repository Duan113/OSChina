package com.cat.oschina.synthetical.adapter;

import com.cat.oschina.R;
import com.cat.oschina.synthetical.entity.Software;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SoftwareAdapter extends BaseQuickAdapter<Software, BaseViewHolder> {
    public SoftwareAdapter(int layoutResId, @Nullable List<Software> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Software item) {
        helper.setText(R.id.title,item.getName());
    }
}

