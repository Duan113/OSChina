package com.cat.oschina.synthetical.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cat.oschina.R;
import com.cat.oschina.synthetical.entity.Question;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionAdapter extends BaseQuickAdapter<Question, BaseViewHolder> {
    //    private Context context;
    public QuestionAdapter(int layoutResId, @Nullable List<Question> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Question item) {
        ImageView imageView = helper.getView(R.id.imageQuestion);
        Glide.with(mContext).load(item.getPortrait()).into(imageView);
        helper.setText(R.id.titleQuestion,item.getTitle());
        helper.setText(R.id.authorQuestion,item.getAuthor());
        helper.setText(R.id.timeQuestion,item.getPubDate());
        helper.setText(R.id.readNumberQuestion,String.valueOf(item.getViewCount()));
    }
}