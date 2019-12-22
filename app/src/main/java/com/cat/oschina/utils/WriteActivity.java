package com.cat.oschina.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.cat.oschina.R;
import com.cat.oschina.net.URLList;
import com.cat.oschina.util.ACache;
import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;
import com.okhttplib.callback.Callback;

import java.io.IOException;


public class WriteActivity extends AppCompatActivity implements View.OnClickListener {

    //发送
    public Button send1;
    //返回键
    private ImageButton ib_navigation_back;
    //文字
    private EditText mEtInput,mEtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        send1 =findViewById(R.id.send1);
        send1.setOnClickListener(this);
        mEtInput = findViewById(R.id.et_content);
        mEtInput.setOnClickListener(this);
        mEtTitle =findViewById(R.id.et_title);
        mEtTitle.setOnClickListener(this);
        ib_navigation_back=findViewById(R.id.ib_navigation_back);
        ib_navigation_back.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.ib_navigation_back:
                finish();
            case R.id.send1:
                OkHttpUtil.getDefault(this)
                        .doGetAsync(HttpInfo.Builder().setUrl(URLList.SEND_QUESTION +"?title="+mEtTitle.getText().toString()+
                                "?content="+mEtInput.getText().toString()+
                                "&access_token="+ ACache.get(WriteActivity.this).getAsString("token")).build(), new Callback() {
                            @Override
                            public void onSuccess(HttpInfo info) throws IOException {
                                Toast.makeText(WriteActivity.this,"发送成功",Toast.LENGTH_LONG).show();

                            }

                            @Override
                            public void onFailure(HttpInfo info) throws IOException {
                                Toast.makeText(WriteActivity.this,"发送失败", Toast.LENGTH_LONG).show();


                            }
                        });
                break;

        }
    }




}
