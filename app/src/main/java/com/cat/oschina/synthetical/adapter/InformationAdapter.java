package com.cat.oschina.synthetical.adapter;

import com.cat.oschina.R;
import com.cat.oschina.synthetical.entity.Information;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InformationAdapter extends BaseQuickAdapter<Information, BaseViewHolder> {
    public InformationAdapter(int layoutResId, @Nullable List<Information> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Information item) {
        helper.setText(R.id.title_1,item.getTitle());
        helper.setText(R.id.context,item.getTitle());
        helper.setText(R.id.author,item.getAuthor());
        helper.setText(R.id.time1,item.getPubDate());
        helper.setText(R.id.readnumber,item.getCommentCount());
    }
}
