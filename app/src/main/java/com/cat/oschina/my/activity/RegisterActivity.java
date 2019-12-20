package com.cat.oschina.my.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cat.oschina.Main2Activity;
import com.cat.oschina.R;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

//注册
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
private ImageButton navigation_back;
    private EditText edit_phone;
    private EditText edit_cord;
    private TextView now;
    private Button btn_getCord;
    private Button btn_register;
    private String phone_number;
    private String cord_number;
    EventHandler eventHandler;
    private int time=60;
    private boolean flag=true;

    private Time time1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        time1 = new Time(60000,1000);
        getId();


        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                Message msg=new Message();
                msg.arg1=event;
                msg.arg2=result;
                msg.obj=data;
                handler.sendMessage(msg);
            }
        };

        SMSSDK.registerEventHandler(eventHandler);
    }
    public class Time extends CountDownTimer{

        public Time(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            btn_getCord.setClickable(false);
            btn_getCord.setText(millisUntilFinished/1000+"秒后获取");
        }

        @Override
        public void onFinish() {
            btn_getCord.setClickable(true);
            btn_getCord.setText("获取验证码");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }

    /**
     * 使用Handler来分发Message对象到主线程中，处理事件
     */
    Handler handler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int event=msg.arg1;
            int result=msg.arg2;
            Object data=msg.obj;
            if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                if(result == SMSSDK.RESULT_COMPLETE) {
                    boolean smart = (Boolean)data;
                    if(smart) {
                        Toast.makeText(getApplicationContext(),"该手机号已经注册过，请重新输入",
                                Toast.LENGTH_LONG).show();
                        edit_phone.requestFocus();
                        return;
                    }
                }
            }
            if(result==SMSSDK.RESULT_COMPLETE)
            {

                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    Toast.makeText(getApplicationContext(), "验证码输入正确",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, Main2Activity.class);
                    startActivity(intent);
                }
            }
            else
            {
                if(flag)
                {
                    btn_getCord.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"验证码获取失败请重新获取", Toast.LENGTH_LONG).show();
                    edit_phone.requestFocus();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"验证码输入错误", Toast.LENGTH_LONG).show();
                }
            }

        }

    };

    /**
     * 获取id
     */
    private void getId()
    {
        edit_phone=findViewById(R.id.et_register_username);
        edit_cord=findViewById(R.id.et_register_auth_code);
        btn_getCord=findViewById(R.id.bt_getcode_id);
        btn_register=findViewById(R.id.bt_register_submit);
        btn_getCord.setOnClickListener(this);
        btn_register.setOnClickListener(this);

        navigation_back = findViewById(R.id.navigation_back);
        navigation_back.setOnClickListener(this);
    }

    /**
     * 按钮点击事件
     */
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bt_getcode_id:
                if(judPhone())//去掉左右空格获取字符串
                {
                    SMSSDK.getVerificationCode("86",phone_number);
                    time1.start();
                    edit_cord.requestFocus();
                }
                break;
            case R.id.bt_register_submit:
                if(judCord())
                    SMSSDK.submitVerificationCode("86",phone_number,cord_number);
                flag=false;

                break;
            case R.id.navigation_back:
                finish();
                break;

            default:
                break;
        }
    }


    private boolean judPhone()
    {
        if(TextUtils.isEmpty(edit_phone.getText().toString().trim()))
        {
            Toast.makeText(RegisterActivity.this,"请输入您的电话号码",Toast.LENGTH_LONG).show();
            edit_phone.requestFocus();
            return false;
        }
        else if(edit_phone.getText().toString().trim().length()!=11)
        {
            Toast.makeText(RegisterActivity.this,"您的电话号码位数不正确",Toast.LENGTH_LONG).show();
            edit_phone.requestFocus();
            return false;
        }
        else
        {
            phone_number=edit_phone.getText().toString().trim();
            String num="[1][2345678]\\d{9}";
            if(phone_number.matches(num))
                return true;
            else
            {
                Toast.makeText(RegisterActivity.this,"请输入正确的手机号码",Toast.LENGTH_LONG).show();
                return false;
            }
        }
    }

    private boolean judCord()
    {
        judPhone();
        if(TextUtils.isEmpty(edit_cord.getText().toString().trim()))
        {
            Toast.makeText(RegisterActivity.this,"请输入您的验证码",Toast.LENGTH_LONG).show();
            edit_cord.requestFocus();
            return false;
        }
        else if(edit_cord.getText().toString().trim().length()!=4)
        {
            Toast.makeText(RegisterActivity.this,"您的验证码位数不正确",Toast.LENGTH_LONG).show();
            edit_cord.requestFocus();

            return false;
        }
        else
        {
            cord_number=edit_cord.getText().toString().trim();
            return true;
        }

    }
}

