package com.cat.oschina.tweet.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.R;
import com.flyco.tablayout.SlidingTabLayout;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TweetFragment extends Fragment {
    @BindView(R.id.tl_2)
    SlidingTabLayout tab;
    @BindView(R.id.vp)
    ViewPager pager;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "最新","热门","话题","乱弹","我的"
    };
    private Unbinder binder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet,container,false);
        binder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragments.add(new DataFragment());
        mFragments.add(new HotFragment());
        mFragments.add(new GambitFragment());
        mFragments.add(new ThrumFragment());
        mFragments.add(new MeFragment());

//        tab.setViewPager(pager,mTitles,getActivity(),mFragments);

        MyPagerAdapter mAdapter = new MyPagerAdapter(getChildFragmentManager());
        //设置ViewPager与适配器关联
        pager.setAdapter(mAdapter);
        //设置Tab与ViewPager关联
        tab.setViewPager(pager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}