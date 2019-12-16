package com.cat.oschina.synthetical.fragment;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.R;
import com.cat.oschina.synthetical.adapter.SoftwareAdapter;
import com.cat.oschina.synthetical.entity.Software;


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

public class SoftwareFragment extends Fragment {
    private Unbinder binder;

    @BindView(R.id.recyclerSoftware)
    RecyclerView recyclerSoftware;

    private List<Software> lists = new ArrayList<>();

    private SoftwareAdapter mSoftwareAdapter;

    private List<Integer> images = new ArrayList<>();
    public  SoftwareFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_software,container,false);
        binder = ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Software software = new Software();
        for (int i = 0;i<30;i++){
            lists.add(software);
        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerSoftware.setLayoutManager(manager);
        mSoftwareAdapter = new SoftwareAdapter(R.layout.item_software,lists);
//        recyclerSoftware.setHasFixedSize(false);
//        recyclerSoftware.setNestedScrollingEnabled(false);
        recyclerSoftware.setAdapter(mSoftwareAdapter);
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.header_software, null);
        mSoftwareAdapter.setHeaderView(view1);
    }






    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
}
