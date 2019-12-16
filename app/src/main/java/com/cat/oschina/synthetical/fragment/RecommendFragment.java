package com.cat.oschina.synthetical.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cat.oschina.R;
import com.cat.oschina.synthetical.adapter.RecommendAdapter;
import com.cat.oschina.synthetical.entity.Recommend;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecommendFragment extends Fragment {
    private Unbinder binder;
    @BindView(R.id.recyclerRecommend)
    RecyclerView recyclerRecommend;

    private List<Recommend> lists = new ArrayList<>();

    private RecommendAdapter mRecommendAdapter;

    private List<Integer> images = new ArrayList<>();
    public  RecommendFragment(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend,container,false);
        binder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Recommend recommend = new Recommend();
        for (int i = 0;i<30;i++){
            lists.add(recommend);
        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerRecommend.setLayoutManager(manager);
        mRecommendAdapter = new RecommendAdapter(R.layout.item_recommend,lists);
        recyclerRecommend.setAdapter(mRecommendAdapter);
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
}
