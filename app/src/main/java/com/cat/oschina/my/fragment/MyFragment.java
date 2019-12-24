package com.cat.oschina.my.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cat.oschina.R;
import com.cat.oschina.my.activity.LoginActivity;
import com.cat.oschina.my.activity.SettingActivity;

import java.util.List;

public class MyFragment extends androidx.fragment.app.Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;


    private OnFragmentInteractionListener mListener;

    public MyFragment() {
    }


    public static MyFragment newInstance(String param1) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        super.onCreate(savedInstanceState);
    }

    private View view;
    //    private ListView lv2;
    private Button news,xun,note,boke,dan,da,tou,activity,foll,friend;
    private ImageView login,seting,code,img;
    private TextView login1;
//    private LinearLayout score,favorite,following,follower;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my, container, false);
        //   ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "我的");

        if (view == null){
            view = inflater.inflate(R.layout.fragment_my,container,false);
        }
        //0.获取数据
        //1.初始化控件
        // lv2 = view.findViewById(R.id.listView);
//        score = view.findViewById(R.id.ly_score);
//        favorite = view.findViewById(R.id.ly_favorite);
//        following = view.findViewById(R.id.ly_following);
//        follower = view.findViewById(R.id.ly_follower);
        login = view.findViewById(R.id.iv_logo_head);
        login1 = view.findViewById(R.id.iv_login);
        seting = view.findViewById(R.id.iv_logo_setting);
        code = view.findViewById(R.id.iv_qr_code);
        img = view.findViewById(R.id.img11);
        news = view.findViewById(R.id.news);
        xun = view.findViewById(R.id.xun);
        note = view.findViewById(R.id.read);
        boke = view.findViewById(R.id.boke);
        dan = view.findViewById(R.id.black);
        da =view.findViewById(R.id.answer);
        tou = view.findViewById(R.id.tou);
        activity = view.findViewById(R.id.activity);
        foll = view.findViewById(R.id.folwer);
        friend =view.findViewById(R.id.please);
        //2.创建Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,datas);
        //3.给ListView设置Adatper
//        lv2.setAdapter(adapter);
//    score.setOnClickListener(this);
//    favorite.setOnClickListener(this);
//    follower.setOnClickListener(this);
//    following.setOnClickListener(this);
        login1.setOnClickListener(this);
        login.setOnClickListener(this);
        seting.setOnClickListener(this);
        code.setOnClickListener(this);
        img.setOnClickListener(this);
        news.setOnClickListener(this);
        xun.setOnClickListener(this);
        note.setOnClickListener(this);
        boke.setOnClickListener(this);
        dan.setOnClickListener(this);
        da.setOnClickListener(this);
        tou.setOnClickListener(this);
        activity.setOnClickListener(this);
        foll.setOnClickListener(this);
        friend.setOnClickListener(this);



        return view;
    }


    private List<String> datas;




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_logo_setting:
                Intent intent=new Intent(getActivity(), SettingActivity.class);
                intent.putExtra("title","设置");
                startActivity(intent);
                break;
            case R.id.iv_logo_head:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.iv_login:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.iv_qr_code:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.img11:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.news:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.xun:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.read:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.boke:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.black:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.answer:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.tou:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.activity:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.folwer:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.please:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;

        }
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String data);

        void setActivityTitle(String data);
    }

}
