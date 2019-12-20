package com.cat.oschina.synthetical.adapter;

import com.cat.oschina.synthetical.entity.Question;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionAdapter extends BaseQuickAdapter<Question, BaseViewHolder> {
    public QuestionAdapter(int layoutResId, @Nullable List<Question> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Question item) {

    }
}
