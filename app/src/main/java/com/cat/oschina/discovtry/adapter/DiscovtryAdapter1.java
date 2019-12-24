package com.cat.oschina.discovtry.adapter;
import com.cat.oschina.discovtry.entity.Discovtry1;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DiscovtryAdapter1 extends BaseQuickAdapter<Discovtry1, BaseViewHolder> {
    public DiscovtryAdapter1(int layoutResId, @Nullable List<Discovtry1> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Discovtry1 item) {

    }
}
