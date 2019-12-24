package com.cat.oschina.discovtry.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.cat.oschina.R;
import com.cat.oschina.discovtry.adapter.CodeCloudAdapter;
import com.cat.oschina.discovtry.entity.CodeCloud;
import com.cat.oschina.synthetical.adapter.SoftwareAdapter;
import com.cat.oschina.synthetical.entity.Software;

import java.util.ArrayList;
import java.util.List;

public class CodeCloudActivity extends AppCompatActivity implements View.OnClickListener {
//
    private Unbinder binder;

    @BindView(R.id.recyclerView_codecloud)
    RecyclerView recyclerViewcodecloud;
    private List<CodeCloud> lists = new ArrayList<>();
    private CodeCloudAdapter mCodeCloudAdapter;
    private List<Integer> images = new ArrayList<>();

    private ImageButton code_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_cloud);
        code_back=findViewById(R.id.icon_back);
        code_back.setOnClickListener(this);


        CodeCloud codeCloud = new CodeCloud();
        for (int i = 0;i<30;i++){
            lists.add(codeCloud);
        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(CodeCloudActivity.this,RecyclerView.VERTICAL,false);
        recyclerViewcodecloud=findViewById(R.id.recyclerView_codecloud);
        recyclerViewcodecloud.setLayoutManager(manager);
        mCodeCloudAdapter = new CodeCloudAdapter(R.layout.item_codecloud,lists);
        recyclerViewcodecloud.setAdapter(mCodeCloudAdapter);
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
