package com.cat.oschina.discovtry.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.cat.oschina.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class SweepActivity extends AppCompatActivity implements QRCodeView.Delegate{
    private ZXingView mQRCodeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweep);

        mQRCodeView = findViewById(R.id.qr);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }else {
            mQRCodeView.startSpot();
            mQRCodeView.setDelegate(this);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        //打开后置摄像头预览,但并没有开始扫描
        mQRCodeView.startCamera();
        //开启扫描框
        mQRCodeView.showScanRect();
        mQRCodeView.startSpot();
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override

    public void onScanQRCodeSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }
}


