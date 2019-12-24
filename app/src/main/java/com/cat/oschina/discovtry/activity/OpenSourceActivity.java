package com.cat.oschina.discovtry.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.cat.oschina.R;

public class OpenSourceActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton code_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_source);

        code_back=findViewById(R.id.icon_back);
        code_back.setOnClickListener(this);
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
