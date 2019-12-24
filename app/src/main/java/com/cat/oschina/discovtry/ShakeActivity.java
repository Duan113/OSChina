package com.cat.oschina.discovtry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.cat.oschina.MainActivity;
import com.cat.oschina.R;
import com.cat.oschina.discovtry.fragment.GiftFragment;
import com.cat.oschina.discovtry.fragment.ShakeInforFragment;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class ShakeActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.navigationBar)
    EasyNavigationBar bar;
    @BindView(R.id.lin)
    LinearLayout linearLayout;
    private ImageButton iconback;

    private String[] tabText = {"礼品", "资讯"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.lipin_normal, R.mipmap.zixun_normal};
    //选中时icon
    private int[] selectIcon = {R.mipmap.lipin_activity, R.mipmap.zixun_activity};

    private List<Fragment> fragments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);


        ButterKnife.bind(this);
        iconback=findViewById(R.id.icon_back);

        fragments.add(new GiftFragment());
        fragments.add(new ShakeInforFragment());

        bar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .build();
        iconback.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.icon_back:
                finish();
                break;
        }
    }
}
