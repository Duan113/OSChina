package com.cat.oschina.tweet.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cat.oschina.R;
import com.cat.oschina.tweet.entity.Hot;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HotAdapter extends BaseQuickAdapter<Hot, BaseViewHolder> {
    public HotAdapter(int layoutResId, @Nullable List<Hot> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Hot item) {
        ImageView imageView = helper.getView(R.id.imageHot);
        Glide.with(mContext).load(item.getPortrait()).into(imageView);
        helper.setText(R.id.authorHot,item.getAuthor());
        helper.setText(R.id.timeHot,item.getPubDate());
        helper.setText(R.id.bodyHot,item.getBody());
        helper.setText(R.id.readNumberHot,String.valueOf(item.getCommentCount()));

    }
}
