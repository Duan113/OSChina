package com.cat.oschina.synthetical.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cat.oschina.R;
import com.cat.oschina.synthetical.fragment.BlogFragment;
import com.cat.oschina.synthetical.fragment.EnglishFragment;
import com.cat.oschina.synthetical.fragment.FocusFragment;
import com.cat.oschina.synthetical.fragment.InformationFragment;
import com.cat.oschina.synthetical.fragment.QusetionFragment;
import com.cat.oschina.synthetical.fragment.RecommendFragment;
import com.cat.oschina.synthetical.fragment.SoftwareFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewsFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.tl_2)
    SlidingTabLayout tab;
    @BindView(R.id.vp)
    ViewPager pager;
    private ImageButton search;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "关注", "软件", "资讯"
            , "推荐", "问答", "博客", "英文"
    };
    private Unbinder binder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        binder = ButterKnife.bind(this, view);

        search = view.findViewById(R.id.search);
        search.setOnClickListener(this);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragments.add(new FocusFragment());
        mFragments.add(new SoftwareFragment());
        mFragments.add(new InformationFragment());
        mFragments.add(new RecommendFragment());
        mFragments.add(new QusetionFragment());
        mFragments.add(new BlogFragment());
        mFragments.add(new EnglishFragment());
        tab.setViewPager(pager, mTitles,getActivity(),mFragments);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search:
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
        }
    }
}
