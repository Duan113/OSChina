package com.cat.oschina.discovtry.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cat.oschina.R;
import com.cat.oschina.discovtry.ShakeActivity;
import com.cat.oschina.discovtry.activity.CodeCloudActivity;
import com.cat.oschina.discovtry.activity.OfflineActivity;
import com.cat.oschina.discovtry.activity.OpenSourceActivity;
import com.cat.oschina.discovtry.activity.SOClassificationActivity;
import com.cat.oschina.discovtry.activity.SweepActivity;
import com.cat.oschina.discovtry.adapter.DiscovtryAdapter;
import com.cat.oschina.discovtry.adapter.DiscovtryAdapter1;
import com.cat.oschina.discovtry.entity.Discovtry;

import com.cat.oschina.discovtry.entity.Discovtry1;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

public class DiscovtryFragment extends androidx.fragment.app.Fragment implements OnBannerListener, View.OnClickListener {

    private Banner mBanner;
    private Unbinder binder;
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    private List<Discovtry> lists = new ArrayList<>();
    private List<Discovtry1> lists1 = new ArrayList<>();
    private DiscovtryAdapter mDiscovtryAdapter;
    private DiscovtryAdapter1 mDiscovtryAdapter1;

    private ImageView img_shake,sweep;
    private RadioButton rbky,rbmy,rbxx,rbrj;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discovtry, container, false);
        mBanner =view.findViewById(R.id.mBanner);
//        recyclerView=view.findViewById(R.id.recyclerView_discovtry);
        recyclerView1=view.findViewById(R.id.recyclerView_focus);

        mBanner.setOnBannerListener(this);//设置监听

        img_shake=view.findViewById(R.id.shake);
        sweep=view.findViewById(R.id.sweep);
        rbky=view.findViewById(R.id.rb_ky);
        rbmy=view.findViewById(R.id.rb_my);
        rbxx=view.findViewById(R.id.rb_xx);
        rbrj=view.findViewById(R.id.rb_rj);

        img_shake.setOnClickListener(this);
        sweep.setOnClickListener(this);
        rbky.setOnClickListener(this);
        rbmy.setOnClickListener(this);
        rbxx.setOnClickListener(this);
        rbrj.setOnClickListener(this);

        initView();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Discovtry1 discovtry1 = new Discovtry1();
        for (int i = 0; i <1 ; i++) {
            lists1.add(discovtry1);
        }
        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView1.setLayoutManager(manager1);
        mDiscovtryAdapter1 = new DiscovtryAdapter1(R.layout.item_discivtrtfocus,lists1);
        recyclerView1.setAdapter(mDiscovtryAdapter1);



        Discovtry discovtry = new Discovtry();
        for (int i = 0; i <3 ; i++) {
            lists.add(discovtry);
        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
//        recyclerView.setLayoutManager(manager);
        mDiscovtryAdapter = new DiscovtryAdapter(R.layout.item_discivtrt,lists);
//        recyclerView.setAdapter(mDiscovtryAdapter);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }


    private void initView() {
        //图片资源
        int[] imageResourceID = new int[]{R.mipmap.icon_banner2, R.mipmap.icon_banner3, R.mipmap.icon_banner4};
        List<Integer> imgeList = new ArrayList<>();
        //轮播标题
        String[] mtitle = new String[]{"2019年度最受欢迎中国开源软件评选", "奇葩面试经历分享",
                "多语言云端IDE和桌面IDE", "码云推荐"};
        List<String> titleList = new ArrayList<>();
        for (int i = 0; i < imageResourceID.length; i++) {
            imgeList.add(imageResourceID[i]);//把图片资源循环放入list里面
            titleList.add(mtitle[i]);//把标题循环设置进列表里面
            //设置图片加载器，通过Glide加载图片
            mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(DiscovtryFragment.super.getActivity()).load(path).into(imageView);
                }
            });
            mBanner.setBannerAnimation(Transformer.Accordion);
            mBanner.setImages(imgeList);//设置图片资源
            mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);//设置banner显示样式（带标题的样式）
            mBanner.setBannerTitles(titleList); //设置标题集合（当banner样式有显示title时）
            //设置指示器位置（即图片下面的那个小圆点）
            mBanner.setIndicatorGravity(BannerConfig.CENTER);
            mBanner.setDelayTime(3000);//设置轮播时间3秒切换下一图

            mBanner.start();
        }

    }
    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();//开始轮播
    }

    @Override
    public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();//结束轮播
    }

    //对轮播图设置点击监听事件
    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(DiscovtryFragment.super.getActivity(), "你点击了第" + (position + 1) + "张轮播图", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.shake:
                intent=new Intent(getActivity(), ShakeActivity.class);
                startActivity(intent);
                break;
            case R.id.sweep:
                intent=new Intent(getActivity(), SweepActivity.class);
                startActivity(intent);
                break;
            case R.id.rb_ky:
                intent=new Intent(getActivity(), OpenSourceActivity.class);
                startActivity(intent);
                break;
            case R.id.rb_my:
                intent=new Intent(getActivity(), CodeCloudActivity.class);
                startActivity(intent);
                break;
            case R.id.rb_xx:
                intent=new Intent(getActivity(), OfflineActivity.class);
                startActivity(intent);
                break;
            case R.id.rb_rj:
                intent=new Intent(getActivity(), SOClassificationActivity.class);
                startActivity(intent);
                break;
        }
    }

}
