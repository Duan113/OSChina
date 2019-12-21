package com.cat.oschina.tweet.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cat.oschina.R;
import com.cat.oschina.tweet.entity.Data;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataAdapter extends BaseQuickAdapter<Data, BaseViewHolder> {
    public DataAdapter(int layoutResId, @Nullable List<Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Data item) {
        ImageView imageView = helper.getView(R.id.imageData);
        Glide.with(mContext).load(item.getPortrait()).into(imageView);
        helper.setText(R.id.authorData,item.getAuthor());
        helper.setText(R.id.timeData,item.getPubDate());
        helper.setText(R.id.bodyData,item.getBody());
        helper.setText(R.id.readNumberData,String.valueOf(item.getCommentCount()));
    }
}
