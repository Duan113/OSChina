package com.cat.oschina.synthetical.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
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
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

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
//
//        Banner banner = view1.findViewById(R.id.banner);
//        banner.setImageLoader(new GlideImageLoader());
//        imgs.add(R.mipmap.a);
//        imgs.add(R.mipmap.b);
//        imgs.add(R.mipmap.c);
//        imgs.add(R.mipmap.d);
//        banner.setImages(imgs);
//        banner.start();
        Banner banner = view1.findViewById(R.id.banner);

        //图片资源
        int[] imageResourceID = new int[]{R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d};
        List<Integer> imgeList = new ArrayList<>();
        //轮播标题
        String[] title = new String[]{"Facebook默认开发环境采用VS Code", "温绍锦：初心不改的阿里初代开源人", "2019 年 Haskell 调查报告", "实时数仓 和维度表进行关联"};
        List<String> titleList = new ArrayList<>();

        for (int i = 0; i < imageResourceID.length; i++) {
            imgeList.add(imageResourceID[i]);//把图片资源循环放入list里面
            titleList.add(title[i]);//把标题循环设置进列表里面
            //设置图片加载器，通过Glide加载图片
            banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(getActivity()).load(path).into(imageView);
                }
            });
            //设置轮播的动画效果,里面有很多种特效,可以到GitHub上查看文档。
            banner.setBannerAnimation(Transformer.Default);
            banner.setImages(imgeList);//设置图片资源
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);//设置banner显示样式（带标题的样式）
            banner.setBannerTitles(titleList); //设置标题集合（当banner样式有显示title时）
            //设置指示器位置（即图片下面的那个小圆点）
            banner.setIndicatorGravity(BannerConfig.CENTER);
            banner.setDelayTime(3000);//设置轮播时间3秒切换下一图
            banner.start();//开始进行banner渲染
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
}
