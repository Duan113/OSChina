package com.cat.oschina.discovtry.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.discovtry.entity.CodeCloud;
import com.cat.oschina.synthetical.entity.Software;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class CodeCloudAdapter extends BaseQuickAdapter<CodeCloud, BaseViewHolder> {
    public CodeCloudAdapter(int layoutResId, @Nullable List<CodeCloud> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CodeCloud item) {

    }
}
