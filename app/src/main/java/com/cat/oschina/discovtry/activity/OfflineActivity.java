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
import com.cat.oschina.discovtry.adapter.OfflineAdapter;
import com.cat.oschina.discovtry.entity.Offline;


import java.util.ArrayList;
import java.util.List;

public class OfflineActivity extends AppCompatActivity implements View.OnClickListener {

    private Unbinder binder;

    @BindView(R.id.recyclerView_offline)
    RecyclerView recyclerViewoffline;
    private List<Offline> lists = new ArrayList<>();
    private OfflineAdapter mOfflineAdapter;
    private List<Integer> images = new ArrayList<>();

    private ImageButton code_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        code_back=findViewById(R.id.icon_back);
        code_back.setOnClickListener(this);

        Offline offline = new Offline();
        for (int i = 0;i<4;i++){
            lists.add(offline);
        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(OfflineActivity.this,RecyclerView.VERTICAL,false);
        recyclerViewoffline=findViewById(R.id.recyclerView_offline);
        recyclerViewoffline.setLayoutManager(manager);
        mOfflineAdapter = new OfflineAdapter(R.layout.item_offline,lists);
        recyclerViewoffline.setAdapter(mOfflineAdapter);

        View view1 = LayoutInflater.from(OfflineActivity.this).inflate(R.layout.head_offline, null);
        mOfflineAdapter.setHeaderView(view1);
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
