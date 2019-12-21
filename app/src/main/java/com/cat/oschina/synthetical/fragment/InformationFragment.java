package com.cat.oschina.synthetical.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.cat.oschina.R;
import com.cat.oschina.synthetical.adapter.InformationAdapter;
import com.cat.oschina.synthetical.entity.Information;
import com.cat.oschina.synthetical.net.InformationResult;
import com.cat.oschina.util.ACache;
import com.cat.oschina.util.GlideImageLoader;
import com.cat.oschina.net.URLList;
import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;
import com.okhttplib.callback.Callback;
import com.youth.banner.Banner;

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

public class InformationFragment extends Fragment {
    private Unbinder binder;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<Information> lists = new ArrayList<>();
    private List<Integer> imgs = new ArrayList<>();

    private InformationAdapter mInformationAdapter;

    public InformationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information,container,false);
        binder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OkHttpUtil.getDefault(this)
                .doGetAsync(HttpInfo.Builder().setUrl(URLList.GET_INFORMATION + ACache.get(getActivity()).getAsString("token")).build(), new Callback() {
                    @Override
                    public void onSuccess(HttpInfo info) throws IOException {
                        InformationResult result = info.getRetDetail(InformationResult.class);
                        mInformationAdapter.replaceData(result.getNewsList());
                    }

                    @Override
                    public void onFailure(HttpInfo info) throws IOException {
                        System.out.println(info);

                    }
                });


//        Information information = new Information();
//        for (int i=0;i<30;i++){
//            lists.add(information);
//
//        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,
                false);
        recyclerView.setLayoutManager(manager);
        mInformationAdapter = new InformationAdapter(R.layout.item_information,lists);
        recyclerView.setAdapter(mInformationAdapter);

        View view1 = View.inflate(getActivity(),R.layout.xbanner,null);
        mInformationAdapter.addHeaderView(view1);

        Banner banner = view1.findViewById(R.id.banner);
        banner.setImageLoader(new GlideImageLoader());
        imgs.add(R.mipmap.a);
        imgs.add(R.mipmap.b);
        imgs.add(R.mipmap.c);
        imgs.add(R.mipmap.d);
        banner.setImages(imgs);
        banner.start();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
}
