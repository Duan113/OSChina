package com.cat.oschina.my.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.UiModeManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.cat.oschina.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.panpf.switchbutton.SwitchButton;

//设置（登陆前）
public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView( R.id.ib_navigation_back )
    ImageButton reBack;
    @BindView(R.id.rl_check_version)
    FrameLayout check;
    @BindView(R.id.light)
    LinearLayout night;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        reBack.setOnClickListener(this);
        check.setOnClickListener(this);
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.get(SettingActivity.this, "theme", "dayTheme").equals(
                        "dayTheme")) {
                    Utils.put(SettingActivity.this, "theme", "nightTheme");
                } else {
                    Utils.put(SettingActivity.this, "theme", "dayTheme");
                }
                recreate();
            }
        });
        if (Utils.get(this, "theme", "dayTheme").equals("dayTheme")) {
            setTheme(R.style.dayTheme);
        } else {
            setTheme(R.style.nightTheme);
        }
    }






    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_navigation_back:
                finish();
                break;
            case R.id.rl_check_version:
                final String[] items = {"已经是新版本了"};

                AlertDialog.Builder listDialog = new AlertDialog.Builder ( SettingActivity.this );
                listDialog.setItems ( items, new DialogInterface.OnClickListener ( ) {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                listDialog.setNegativeButton ( "确定", new DialogInterface.OnClickListener ( ) {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );
                listDialog.show ( );
                break;


        }
    }





}
