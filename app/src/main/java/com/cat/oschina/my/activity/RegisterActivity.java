package com.cat.oschina.my.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.cat.oschina.R;
//注册
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton navigation_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        navigation_back = findViewById(R.id.navigation_back);

        navigation_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigation_back:
                finish();
                break;
        }
    }
}
