package com.cat.oschina.tweet.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.R;
import com.cat.oschina.net.URLList;
import com.cat.oschina.synthetical.net.HotResult;
import com.cat.oschina.tweet.adapter.HotAdapter;
import com.cat.oschina.tweet.entity.Hot;
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

public class HotFragment extends Fragment {
    private Unbinder binder;
    @BindView(R.id.recycler_hot)
    RecyclerView recyclerView;
    private List<Hot> lists = new ArrayList<>();
    private HotAdapter mHotAdapter;

    public HotFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot,container,false);
        binder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("hot", "DATA onViewCreated: url:"+ URLList.GET_HOT + ACache.get(getActivity()).getAsString("token")+"&user=-1");
        OkHttpUtil.getDefault(this)
                .doGetAsync(HttpInfo.Builder().setUrl(URLList.GET_HOT + ACache.get(getActivity()).getAsString("token")+"&user=-1").build(), new Callback() {
                    @Override
                    public void onSuccess(HttpInfo info) throws IOException {
                        HotResult result = info.getRetDetail(HotResult.class);
                        mHotAdapter.replaceData(result.getTweetlist());
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
        mHotAdapter = new HotAdapter(R.layout.item_hot,lists);
        recyclerView.setAdapter(mHotAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
}
