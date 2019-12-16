package com.cat.oschina.synthetical.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.oschina.synthetical.entity.Question;

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
