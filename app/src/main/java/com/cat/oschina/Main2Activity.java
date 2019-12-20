package com.cat.oschina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.cat.oschina.discovtry.fragment.DiscovtryFragment;
import com.cat.oschina.my.fragment.My1Fragment;
import com.cat.oschina.my.fragment.MyFragment;
import com.cat.oschina.synthetical.fragment.NewsFragment;
import com.cat.oschina.tweet.fragment.TweetFragment;
import com.cat.oschina.view.MoreWindow;

import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    //private EasyNavigationBar bar;
    @BindView(R.id.navigationBar1)
    EasyNavigationBar bar;
    @BindView(R.id.lin1)
    LinearLayout linearLayout;
    private String[] tabText = {"综合", "动弹", "发现", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.ic_nav_news_normal, R.mipmap.ic_nav_tweet_normal, R.mipmap.ic_nav_discover_normal,R.mipmap.ic_nav_my_normal};
    //选中时icon
    private int[] selectIcon = {R.mipmap.ic_nav_news_actived, R.mipmap.ic_nav_tweet_actived, R.mipmap.ic_nav_discover_actived, R.mipmap.ic_nav_my_pressed};

    private List<Fragment> fragments = new ArrayList<>();
    private Handler mHandler = new Handler();
    private boolean flag = true;
    private MoreWindow mMoreWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);

        mMoreWindow = new MoreWindow(this);
        mMoreWindow.init(linearLayout);

        fragments.add(new NewsFragment());
        fragments.add(new TweetFragment());
        fragments.add(new DiscovtryFragment());
        fragments.add(new My1Fragment());


        View view = LayoutInflater.from(this).inflate(R.layout.custom_add_view, null);
        String s = "123";

        bar.titleItems(tabText)
                .tabTextSize(15)
                .tabTextTop(5)
                .selectTextColor(Color.parseColor("#24cf5f"))
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .canScroll(true)
                .addAsFragment(false)
                .mode(EasyNavigationBar.MODE_ADD_VIEW)
                .addCustomView(view)
                .fragmentManager(getSupportFragmentManager())
                .onTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabClickEvent(View view, int position) {
                        Log.e("Tap->Position", position + "");
                        if (position == 2) {
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    //＋ 旋转动画
                                    if (flag) {
                                        bar.getCustomAddView().animate().rotation(180).setDuration(400);
                                    } else {
                                        bar.getCustomAddView().animate().rotation(0).setDuration(400);
                                    }
                                    flag = !flag;
                                    showMoreWindow();
                                }
                            });
                        }

                        return false;
                    }
                })
                .build();

    }
    private void showMoreWindow() {
        if (null == mMoreWindow) {
            mMoreWindow = new MoreWindow(this);
            mMoreWindow.init(linearLayout);
        }

        mMoreWindow.showMoreWindow(linearLayout );
    }
    public EasyNavigationBar getNavigationBar() {
        return bar;
    }

}
