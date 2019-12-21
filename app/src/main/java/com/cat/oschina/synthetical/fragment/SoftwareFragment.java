package com.cat.oschina.synthetical.fragment;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.R;
import com.cat.oschina.net.URLList;
import com.cat.oschina.synthetical.adapter.SoftwareAdapter;
import com.cat.oschina.synthetical.entity.Software;
import com.cat.oschina.synthetical.net.SoftwareResult;
import com.cat.oschina.util.ACache;
import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;
import com.okhttplib.callback.Callback;


import java.io.IOException;
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
        Log.d("soft", "Software onViewCreated: url:"+ URLList.GET_SOFTWARE + ACache.get(getActivity()).getAsString("token"));
        OkHttpUtil.getDefault(this)
                .doGetAsync(HttpInfo.Builder().setUrl(URLList.GET_SOFTWARE + ACache.get(getActivity()).getAsString("token")).build(), new Callback() {
                    @Override
                    public void onSuccess(HttpInfo info) throws IOException {
                        SoftwareResult result = info.getRetDetail(SoftwareResult.class);
                        mSoftwareAdapter.replaceData(result.getProjectlist());
                    }

                    @Override
                    public void onFailure(HttpInfo info) throws IOException {
                        System.out.println(info);

                    }
                });

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerSoftware.setLayoutManager(manager);
        mSoftwareAdapter = new SoftwareAdapter(R.layout.item_software,lists);
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
