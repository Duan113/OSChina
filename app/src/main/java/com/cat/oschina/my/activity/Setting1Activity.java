package com.cat.oschina.my.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.cat.oschina.MainActivity;
import com.cat.oschina.R;

import butterknife.BindView;
import butterknife.ButterKnife;
//设置（登陆前）
public class Setting1Activity extends AppCompatActivity implements View.OnClickListener {
    @BindView( R.id.ib_navigation_back )
    ImageButton reBack;
    @BindView(R.id.zhuxiao)
    FrameLayout Zhuxiao;
    @BindView(R.id.rl_check_version)
    FrameLayout check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting1);
        ButterKnife.bind(this);
        Zhuxiao.setOnClickListener(this);
        check.setOnClickListener(this);
        reBack.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_navigation_back:
                finish();
                break;
            case R.id.zhuxiao:
                Intent intent = new Intent(Setting1Activity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_check_version:
                final String[] items = {"已经是新版本了"};

                AlertDialog.Builder listDialog = new AlertDialog.Builder ( Setting1Activity.this );
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
