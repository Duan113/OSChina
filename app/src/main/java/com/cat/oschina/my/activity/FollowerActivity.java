package com.cat.oschina.my.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.cat.oschina.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FollowerActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView( R.id.ib_navigation_back )
    ImageButton reBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower);
        ButterKnife.bind(this);
        reBack.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_navigation_back:
                finish();
                break;
        }
    }
}
