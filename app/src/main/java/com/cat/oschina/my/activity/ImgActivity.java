package com.cat.oschina.my.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.cat.oschina.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImgActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView( R.id.ib_navigation_back )
    ImageButton reBack;
    @BindView(R.id.share)
    ImageView share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        ButterKnife.bind(this);
        reBack.setOnClickListener ( this );
        share.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_navigation_back:
                finish();
                break;
            case R.id.share:
                Dialog bottomDialog = new Dialog ( this, R.style.screen );
//        获取底部菜单的布局样式
                View contentView = LayoutInflater.from ( this ).inflate ( R.layout.activity_share, null );
//        存放布局样式
                bottomDialog.setContentView ( contentView );
//                得到布局参数
                ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams ( );
//                得到宽度
                layoutParams.width = getResources ( ).getDisplayMetrics ( ).widthPixels;
                contentView.setLayoutParams ( layoutParams );
                bottomDialog.getWindow ( ).setGravity ( Gravity.BOTTOM );
//                点击弹框为true时消失
                bottomDialog.setCanceledOnTouchOutside ( true );
//             activity的进入和退出效果 从底部进入  从底部滑出
                bottomDialog.getWindow ( ).setWindowAnimations ( R.style.Animation );
//                展示
                bottomDialog.show ( );


                break;
        }
    }
}
