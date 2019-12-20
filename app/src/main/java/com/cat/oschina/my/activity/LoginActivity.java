package com.cat.oschina.my.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.alibaba.fastjson.JSON;
import com.cat.oschina.Main2Activity;
import com.cat.oschina.MainActivity;
import com.cat.oschina.R;
import com.cat.oschina.my.fragment.My1Fragment;
import com.cat.oschina.synthetical.entity.CallBackForUser;
import com.cat.oschina.synthetical.entity.LoginAccessUtil;
import com.cat.oschina.synthetical.entity.OauthClient;
import com.cat.oschina.util.ACache;

import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;

//登录
public class LoginActivity extends AppCompatActivity implements View.OnClickListener,CallBackForUser{
    private EditText et_login_username,et_login_password;
    private TextView tv_login_forget_password;
    private Button bt_login,bt_register;
    private LinearLayout login_pull;
    private ImageButton navigation_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //返回上级菜单 设置title
//        ActionBar actionBar=this.getSupportActionBar();
//        actionBar.setTitle("登录");
//        actionBar.setDisplayHomeAsUpEnabled(true);

        et_login_username = findViewById(R.id.et_login_username);
        et_login_password = findViewById(R.id.et_login_password);
        tv_login_forget_password = findViewById(R.id.tv_login_forget_password);
        bt_login = findViewById(R.id.bt_login);
        bt_register = findViewById(R.id.bt_register);
        login_pull = findViewById(R.id.login_pull);
        navigation_back =findViewById(R.id.navigation_back);

        et_login_username.setOnClickListener(this);
        et_login_password.setOnClickListener(this);
        tv_login_forget_password .setOnClickListener(this);
        bt_login .setOnClickListener(this);
        bt_register .setOnClickListener(this);
        login_pull.setOnClickListener(this);
        navigation_back.setOnClickListener(this);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId()==android.R.id.home){
//            finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                loginThree();
                break;

//                Intent intent=new Intent(LoginActivity.this, Main2Activity.class);
//                startActivity(intent);
            case R.id.bt_register:
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.navigation_back:
                finish();
                break;
            case R.id.tv_login_forget_password:
                intent=new Intent(LoginActivity.this,ForgetActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void loginThree(){
        OauthClient client = new OauthClient();
        client.setClientId("zJR9B11Htc9yvog4KZ0y");
        client.setClientSecret("eeXKbHVnf7CBE1qonyb0b0P69u5egAV0");
        client.setRedirectUrl("http://www.baidu.com");
        client.setUsername(et_login_username.getText().toString());
        client.setPassword(et_login_password.getText().toString());

        LoginAccessUtil.login(this,client);

    }

    @Override
    public void getUserMsg(String userJson) {
        ACache.get(this).put("user",userJson);
        ACache.get(this).put("isLogin",true);
        ACache.get(this).put("token",
                JSON.parseObject(userJson).getJSONObject("token").getString(
                        "accessToken"));
        startActivity(new Intent(this, Main2Activity.class));
        finish();
    }

}
