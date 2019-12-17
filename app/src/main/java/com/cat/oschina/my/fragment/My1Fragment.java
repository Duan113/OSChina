package com.cat.oschina.my.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.cat.oschina.R;
import com.cat.oschina.my.activity.ImgActivity;
import com.cat.oschina.my.activity.LoginActivity;
import com.cat.oschina.my.activity.MaterialActivity;
import com.cat.oschina.my.activity.Setting1Activity;
import com.cat.oschina.my.activity.SettingActivity;

import java.util.List;

public class My1Fragment extends androidx.fragment.app.Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    private LinearLayout score, favorite, following, follower;

    Bitmap bitmap;
    Context context = getActivity ( );
    private OnFragmentInteractionListener mListener;

    public My1Fragment() {

    }


    public static My1Fragment newInstance(String param1) {
        My1Fragment fragment = new My1Fragment();
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
    Dialog dia;
    private Button news,xun,note,boke,dan,da,tou,activity,foll,friend;
    private ImageView login,seting,code,img;
    private TextView login1;
//    private LinearLayout score,favorite,following,follower;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my1, container, false);
        //   ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "我的");

        if (view == null){
            view = inflater.inflate(R.layout.fragment_my1,container,false);
        }
        //0.获取数据
        //1.初始化控件
        // lv2 = view.findViewById(R.id.listView);
        score = view.findViewById(R.id.ly_tweet);
        favorite = view.findViewById(R.id.ly_favorite);
        following = view.findViewById(R.id.ly_following);
        follower = view.findViewById(R.id.ly_follower);
        login = view.findViewById(R.id.iv_logo_head1);
        login1 = view.findViewById(R.id.iv_login1);
        seting = view.findViewById(R.id.iv_logo_setting1);
        code = view.findViewById(R.id.iv_qr_code1);
        img = view.findViewById(R.id.img1);
        news = view.findViewById(R.id.news1);
        xun = view.findViewById(R.id.xz1);
        note = view.findViewById(R.id.read1);
        boke = view.findViewById(R.id.boke1);
        dan = view.findViewById(R.id.black1);
        da =view.findViewById(R.id.wen1);
        tou = view.findViewById(R.id.tou1);
        activity = view.findViewById(R.id.activity1);
        foll = view.findViewById(R.id.gun1);
        friend =view.findViewById(R.id.please1);
        //2.创建Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,datas);
        //3.给ListView设置Adatper
//        lv2.setAdapter(adapter);
    score.setOnClickListener(this);
    favorite.setOnClickListener(this);
    follower.setOnClickListener(this);
    following.setOnClickListener(this);
        login1.setOnClickListener(this);
        login.setOnClickListener(this);
        seting.setOnClickListener(this);
        code.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        switch (v.getId()){
                                            case R.id.iv_qr_code1:
//                                查看大头像
                                                                LayoutInflater inflater = LayoutInflater.from ( getActivity ( ) );
                                                                View imgView = inflater.inflate ( R.layout.activity_start_dialog, null );
                                                                Dialog dialog1 = new Dialog ( getActivity ( ), R.style.Dialog_Fullscreen );
//                                使得弹框中的某个元素失效，不显示
//                             ImageView img=(ImageView)imgView. findViewById ( R.id.iv_denglu1 );
//                                img.setImageBitmap ( bitmap);
                                                                dialog1.setContentView ( imgView );
                                                                dialog1.show ( );
//                                 设置全屏显示
                                                                imgView.setOnClickListener ( new View.OnClickListener ( ) {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        dialog1.cancel ( );
                                                                    }
                                                                } );
                                                                break;
                                                        }


                                                    }

                                                } );







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
            case R.id.iv_logo_setting1:
                Intent intent=new Intent(getActivity(), Setting1Activity.class);
                intent.putExtra("title","设置");
                startActivity(intent);
                break;
            case R.id.iv_logo_head1:
                //                登录后的头像点击
                final String[] items = {"更换头像", "查看大头像"};
                AlertDialog.Builder listDialog = new AlertDialog.Builder ( getActivity ( ) );
                listDialog.setTitle ( "选择操作" );
                listDialog.setItems ( items, new DialogInterface.OnClickListener ( ) {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
//                                更换头像
                                break;
                            case 1:
//                                查看大头像
                                LayoutInflater inflater = LayoutInflater.from ( getActivity ( ) );
                                View imgView = inflater.inflate ( R.layout.fragment_my1_head, null );
                            Dialog dialog1 = new Dialog ( getActivity ( ), R.style.Dialog_Fullscreen );
//                                使得弹框中的某个元素失效，不显示
//                             ImageView img=(ImageView)imgView. findViewById ( R.id.iv_denglu1 );
//                                img.setImageBitmap ( bitmap);
                                dialog1.setContentView ( imgView );
                                dialog1.show ( );
//                                 设置全屏显示
                                imgView.setOnClickListener ( new View.OnClickListener ( ) {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.cancel ( );
                                    }
                                } );
                                break;
                        }


                    }

                } );
                listDialog.setNegativeButton ( "取消", new DialogInterface.OnClickListener ( ) {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );
                listDialog.show ( );
                break;
            case R.id.iv_login1:
                intent=new Intent(getActivity(), MaterialActivity.class);
                intent.putExtra("title","我的资料");
                startActivity(intent);
                break;
            case R.id.img1:
                intent=new Intent(getActivity(), ImgActivity.class);
                intent.putExtra("title","图片");
                startActivity(intent);
                break;
            case R.id.news1:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.xz1:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.read1:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.boke1:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.black1:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.wen1:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.tou1:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.activity1:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.gun1:
                intent=new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("title","登录");
                startActivity(intent);
                break;
            case R.id.please1:
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
