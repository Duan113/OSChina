package com.cat.oschina.discovtry.adapter;

import com.cat.oschina.discovtry.entity.Offline;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class OfflineAdapter extends BaseQuickAdapter<Offline, BaseViewHolder> {
    public OfflineAdapter(int layoutResId, @Nullable List<Offline> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Offline item) {

    }
}
