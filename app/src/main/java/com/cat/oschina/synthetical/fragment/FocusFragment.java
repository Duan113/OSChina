package com.cat.oschina.synthetical.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cat.oschina.R;
import com.cat.oschina.my.activity.LoginActivity;
import com.cat.oschina.synthetical.adapter.FocusAdapter;
import com.cat.oschina.synthetical.entity.Focus;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FocusFragment extends Fragment implements View.OnClickListener {
    private Unbinder binder;

    private Button login;


    @BindView(R.id.recyclerFocus)
    RecyclerView recyclerFocus;

    private List<Focus> lists = new ArrayList<>();

    private FocusAdapter mFocusAdapter;

    private List<Integer> images = new ArrayList<>();
    public  FocusFragment(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_focus, container, false);

        binder = ButterKnife.bind(this,view);




        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Focus focus = new Focus();
        for (int i = 0;i<30;i++){
            lists.add(focus);
        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerFocus.setLayoutManager(manager);
        mFocusAdapter = new FocusAdapter(R.layout.item_focus,lists);
//        recyclerSoftware.setHasFixedSize(false);
//        recyclerSoftware.setNestedScrollingEnabled(false);
        recyclerFocus.setAdapter(mFocusAdapter);
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.header_focus, null);
        login=view1.findViewById(R.id.login);
        login.setOnClickListener(this);
        mFocusAdapter.setHeaderView(view1);
    }





    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Intent intent= new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
