package com.cat.oschina.tweet.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.R;
import com.cat.oschina.net.URLList;
import com.cat.oschina.synthetical.net.DataResult;
import com.cat.oschina.tweet.adapter.DataAdapter;
import com.cat.oschina.tweet.entity.Data;
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

public class DataFragment extends Fragment {
    private Unbinder binder;
    @BindView(R.id.recycler_data)
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
        Log.d("data", "DATA onViewCreated: url:"+ URLList.GET_DATA + ACache.get(getActivity()).getAsString("token"));
        OkHttpUtil.getDefault(this)
                .doGetAsync(HttpInfo.Builder().setUrl(URLList.GET_DATA + ACache.get(getActivity()).getAsString("token")).build(), new Callback() {
                    @Override
                    public void onSuccess(HttpInfo info) throws IOException {
                        DataResult result = info.getRetDetail(DataResult.class);
                        mDataAdapter.replaceData(result.getTweetlist());
                    }

                    @Override
                    public void onFailure(HttpInfo info) throws IOException {
                        System.out.println(info);

                    }
                });
//        Data data = new Data();
//        for (int i = 0; i <30 ; i++) {
//            lists.add(data);
//
//        }
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
