package com.cat.oschina.synthetical.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.R;
import com.cat.oschina.synthetical.adapter.EnglishAdapter;
import com.cat.oschina.synthetical.entity.English;


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

public class EnglishFragment extends Fragment {
    private Unbinder binder;
    @BindView(R.id.recyclerEnglish)
    RecyclerView recyclerEnglish;

    private List<English> lists = new ArrayList<>();

    private EnglishAdapter mEnglishAdapter;


    public  EnglishFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_english,container,false);
        binder = ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        English english = new English();
        for (int i = 0;i<30;i++){
            lists.add(english);
        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerEnglish.setLayoutManager(manager);
        mEnglishAdapter = new EnglishAdapter(R.layout.item_english,lists);
        recyclerEnglish.setAdapter(mEnglishAdapter);
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
}
