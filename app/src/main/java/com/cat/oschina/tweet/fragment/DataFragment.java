package com.cat.oschina.tweet.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.R;
import com.cat.oschina.tweet.adapter.DataAdapter;
import com.cat.oschina.tweet.entity.Data;


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

public class DataFragment extends Fragment {
    private Unbinder binder;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private List<Data> lists = new ArrayList<>();
    private DataAdapter mDataAdapter;

    public DataFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data,container,false);
        binder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Data data = new Data();
        for (int i = 0; i <30 ; i++) {
            lists.add(data);

        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        mDataAdapter = new DataAdapter(R.layout.item_data,lists);
        recyclerView.setAdapter(mDataAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
}
