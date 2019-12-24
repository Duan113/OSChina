package com.cat.oschina.discovtry.adapter;
import com.cat.oschina.discovtry.entity.Discovtry;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DiscovtryAdapter extends BaseQuickAdapter<Discovtry, BaseViewHolder> {
    public DiscovtryAdapter(int layoutResId, @Nullable List<Discovtry> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Discovtry item) {

    }
}
