package com.cat.oschina.synthetical.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.R;
import com.cat.oschina.synthetical.adapter.QuestionAdapter;
import com.cat.oschina.synthetical.entity.Question;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class QusetionFragment extends Fragment {
    private Unbinder binder;
    @BindView(R.id.recyclerQuestion)
    RecyclerView recyclerQuestion;

    private List<Question> lists = new ArrayList<>();

    private QuestionAdapter mQuestionAdapter;

    private List<Integer> images = new ArrayList<>();
    public  QusetionFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question,container,false);
        binder = ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Question question = new Question();
        for (int i = 0;i<30;i++){
            lists.add(question);
        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerQuestion.setLayoutManager(manager);
        mQuestionAdapter = new QuestionAdapter(R.layout.item_question,lists);
        recyclerQuestion.setAdapter(mQuestionAdapter);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
}
