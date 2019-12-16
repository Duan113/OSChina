package com.cat.oschina.my.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.cat.oschina.R;
//忘记密码
public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton ib_navigation_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        ib_navigation_back = findViewById(R.id.ib_navigation_back);

        ib_navigation_back.setOnClickListener(this);
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
