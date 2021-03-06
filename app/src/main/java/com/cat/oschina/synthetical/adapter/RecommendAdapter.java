package com.cat.oschina.synthetical.adapter;

import com.cat.oschina.R;
import com.cat.oschina.synthetical.entity.Recommend;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RecommendAdapter extends BaseQuickAdapter<Recommend, BaseViewHolder> {
    public RecommendAdapter(int layoutResId, @Nullable List<Recommend> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Recommend item) {
        helper.setText(R.id.titleRecommend,item.getTitle());
        helper.setText(R.id.authorRecommend,item.getAuthor());
        helper.setText(R.id.timeRecommend,item.getPubDate());
        helper.setText(R.id.readNumberRecommend,String.valueOf(item.getCommentCount()));

    }
}
