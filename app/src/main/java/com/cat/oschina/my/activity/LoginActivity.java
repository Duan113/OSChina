package com.cat.oschina.my.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.cat.oschina.Main2Activity;
import com.cat.oschina.MainActivity;
import com.cat.oschina.R;
import com.cat.oschina.my.fragment.My1Fragment;
import com.cat.oschina.synthetical.entity.CallBackForUser;
import com.cat.oschina.synthetical.entity.LoginAccessUtil;
import com.cat.oschina.synthetical.entity.OauthClient;
import com.cat.oschina.util.ACache;

import org.json.JSONObject;

import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import okhttp3.internal.platform.Platform;

//登录
public class LoginActivity extends AppCompatActivity implements View.OnClickListener,CallBackForUser{
    private EditText et_login_username,et_login_password;
    private TextView tv_login_forget_password;
    private Button bt_login,bt_register;
    private View login_layer;
    private LinearLayout login_pull,login_options;
    ImageView ib_login_weibo,ib_login_wx,ib_login_qq,ib_login_csdn;



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

        login_layer=findViewById(R.id.login_layer);
        login_layer.setOnClickListener(this);
        login_options=findViewById(R.id.login_options);
        login_options.setOnClickListener(this);
         ib_login_weibo=findViewById(R.id.login_weibo);
         ib_login_weibo.setOnClickListener(this);
         ib_login_wx=findViewById(R.id.login_wechat);
         ib_login_wx.setOnClickListener(this);
         ib_login_csdn=findViewById(R.id.login_csdn);
        ib_login_csdn.setOnClickListener(this);

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
            case R.id.login_layer:
            case R.id.login_pull:
                login_pull.animate().cancel();
                login_layer.animate().cancel();
                int height = login_options.getHeight();
                float progress = (login_layer.getTag() != null && login_layer.getTag() instanceof Float) ?
                        (float) login_layer.getTag() : 1;
                int time = (int) (360 * progress);

                if (login_pull.getTag() != null) {
                    login_pull.setTag(null);
                    glide(height, progress, time);
                } else {
                    login_pull.setTag(true);
                    upGlide(height, progress, time);
                }
                break;
            case R.id.login_weibo:
//                weiBoLogin();
//                thirdSinaLogin();
                break;
//            case R.id.login_wechat:
//                //微信登录
//                wechatLogin();
//                break;
//            case R.id.login_csdn:
//                //csdn登录
//                CsdnLoginActivity.show(this);
//                break;


//                finish();
//                break;
        }
    }

//    //-----------------------------------------------------新浪微博授权相关--------------
//    /** 新浪微博授权、获取用户信息页面 */
//    private void thirdSinaLogin() {
//        //初始化新浪平台
//        Platform pf = ShareSDK.getPlatform(MainActivity.this, SinaWeibo.NAME);
//        pf.SSOSetting(true);
//        //设置监听
//        pf.setPlatformActionListener(MainActivity.this);
//        //获取登陆用户的信息，如果没有授权，会先授权，然后获取用户信息
//        pf.authorize();
//    }
//    /** 新浪微博授权成功回调页面 */
//    @Override
//    public void onComplete(Platform platform, int action, HashMap<String, Object> hashMap) {
//        /** res是返回的数据，例如showUser(null),返回用户信息，对其解析就行
//         *   http://sharesdk.cn/androidDoc/cn/sharesdk/framework/PlatformActionListener.html
//         *
//         */
//        Message msg = new Message();
//        msg.what = MSG_ACTION_CCALLBACK;
//        msg.arg1 = 1;
//        msg.arg2 = action;
//        msg.obj = platform;
//        UIHandler.sendMessage(msg, this);
//    }
//    /** 取消授权 */
//    @Override
//    public void onCancel(Platform platform, int action) {
//        Message msg = new Message();
//        msg.what = MSG_ACTION_CCALLBACK;
//        msg.arg1 = 3;
//        msg.arg2 = action;
//        msg.obj = platform;
//        UIHandler.sendMessage(msg, this);
//    }
//    /** 授权失败 */
//    @Override
//    public void onError(Platform platform, int action, Throwable t) {
//        t.printStackTrace();
//        t.getMessage();
//        Message msg = new Message();
//        msg.what = MSG_ACTION_CCALLBACK;
//        msg.arg1 = 2;
//        msg.arg2 = action;
//        msg.obj = t;
//        UIHandler.sendMessage(msg, this);
//    }
//
//    @Override
//    public boolean handleMessage(Message msg) {
//        switch(msg.what) {
//            case MSG_TOAST: {
//                String text = String.valueOf(msg.obj);
//                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
//            }
//            break;
//            case MSG_ACTION_CCALLBACK: {
//                switch (msg.arg1) {
//                    case 1: {
//                        // 成功, successful notification
//                        //授权成功后,获取用户信息，要自己解析，看看oncomplete里面的注释
//                        //ShareSDK只保存以下这几个通用值
//                        Platform pf = ShareSDK.getPlatform(MainActivity.this, SinaWeibo.NAME);
//                        Log.e("sharesdk use_id", pf.getDb().getUserId()); //获取用户id
//                        Log.e("sharesdk use_name", pf.getDb().getUserName());//获取用户名称
//                        Log.e("sharesdk use_icon", pf.getDb().getUserIcon());//获取用户头像
//                        mThirdLoginResult.setText("授权成功"+"\n"+"用户id:" + pf.getDb().getUserId() + "\n" + "获取用户名称" + pf.getDb().getUserName() + "\n" + "获取用户头像" + pf.getDb().getUserIcon());
//                        //mPf.author()这个方法每一次都会调用授权，出现授权界面
//                        //如果要删除授权信息，重新授权
//                        //mPf.getDb().removeAccount();
//                        //调用后，用户就得重新授权，否则下一次就不用授权
//                    }
//                    break;
//                    case 2: {
//                        mThirdLoginResult.setText("登录失败");
//                    }
//                    break;
//                    case 3: {
//                        // 取消, cancel notification
//                        mThirdLoginResult.setText("取消授权");
//                    }
//                    break;
//                }
//            }
//            break;
//            case MSG_CANCEL_NOTIFY: {
//                NotificationManager nm = (NotificationManager) msg.obj;
//                if (nm != null) {
//                    nm.cancel(msg.arg1);
//                }
//            }
//            break;
//        }
//        return false;
//    }


    private void upGlide(int height, float progress, int time) {
        login_pull.animate()
                .translationYBy(height * progress)
                .translationY(0)
                .setDuration(time)
                .start();
        login_layer.animate()
                .alphaBy(1 - progress)
                .alpha(1)
                .setDuration(time)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        login_layer.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        if (animation instanceof ValueAnimator) {
                            login_layer.setTag(((ValueAnimator) animation).getAnimatedValue());
                        }
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (animation instanceof ValueAnimator) {
                            login_layer.setTag(((ValueAnimator) animation).getAnimatedValue());
                        }
                    }
                })
                .start();
    }

    private void glide(int height, float progress, int time) {
        login_pull.animate()
                .translationYBy(height - height * progress)
                .translationY(height)
                .setDuration(time)
                .start();

        login_layer.animate()
                .alphaBy(1 * progress)
                .alpha(0)
                .setDuration(time)
                .setListener(new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        if (animation instanceof ValueAnimator) {
                            login_layer.setTag(((ValueAnimator) animation).getAnimatedValue());
                        }
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (animation instanceof ValueAnimator) {
                            login_layer.setTag(((ValueAnimator) animation).getAnimatedValue());
                        }
                        login_layer.setVisibility(View.GONE);
                    }
                })
                .start();
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
