package com.cat.oschina.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.cat.oschina.R;
import com.cat.oschina.net.DialogHelp;
import com.cat.oschina.net.ImageUtils;
import com.cat.oschina.net.URLList;
import com.cat.oschina.synthetical.net.QuestionResult;
import com.cat.oschina.util.ACache;
import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;
import com.okhttplib.callback.Callback;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.zhyd.oauth.utils.StringUtils;

import static android.view.accessibility.AccessibilityEvent.MAX_TEXT_LENGTH;

public class TakingActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton ib_emoji_keyboard,ib_trend_software,ib_picture,ib_mention;
    private EditText editText;
    private GridViewFaceAdapter mGVFaceAdapter;
    public Button send;
    private String theLarge;
private EditText mEtInput;
    private static final String TEXT_SOFTWARE = "#请输入软件名#";
//    private final EmojiKeyboardFragment keyboardFragment = new EmojiKeyboardFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taking);
        editText=findViewById(R.id.et_content);
        editText.setOnClickListener(this);
        send =findViewById(R.id.send);
        send.setOnClickListener(this);
        ib_mention=findViewById(R.id.ib_mention);
        ib_mention.setOnClickListener(this);
        mEtInput = findViewById(R.id.et_content);
        mEtInput.setOnClickListener(this);
        ib_picture=findViewById(R.id.ib_picture);
        ib_picture.setOnClickListener(this);
        ib_trend_software = findViewById(R.id.ib_trend_software);
        ib_trend_software.setOnClickListener(this);
        ib_emoji_keyboard = findViewById(R.id.ib_emoji_keyboard);
        ib_emoji_keyboard.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_emoji_keyboard:
//                if (keyboardFragment.isShow()) {
//                    keyboardFragment.hideEmojiKeyBoard();
//                    keyboardFragment.showSoftKeyboard(mEtInput);
//                } else {
//                    keyboardFragment.showEmojiKeyBoard();
//                    keyboardFragment.hideSoftKeyboard();
//                }
                break;
            case R.id.ib_trend_software:
                insertTrendSoftware();
                break;
            case R.id.ib_mention:
                break;
            case R.id.send:
                OkHttpUtil.getDefault(this)
                        .doGetAsync(HttpInfo.Builder().setUrl(URLList.SEND_TWEET +"?msg="+editText.getText().toString()+
                                "&access_token="+ACache.get(TakingActivity.this).getAsString("token")).build(), new Callback() {
                            @Override
                            public void onSuccess(HttpInfo info) throws IOException {
                                Toast.makeText(TakingActivity.this,"发送成功",Toast.LENGTH_LONG).show();

                            }

                            @Override
                            public void onFailure(HttpInfo info) throws IOException {
                                Toast.makeText(TakingActivity.this,"发送失败",Toast.LENGTH_LONG).show();


                            }
                        });
                break;
            case R.id.ib_picture:
                handleSelectPicture();
                break;
//                initGridView();
        }
    }

    private void handleSelectPicture() {
        DialogHelp.getSelectDialog(this, getResources().getStringArray(R.array.choose_picture), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                goToSelectPicture(i);
            }
        }).show();
    }

    public static final int ACTION_TYPE_ALBUM = 0;
    public static final int ACTION_TYPE_PHOTO = 1;

    private void goToSelectPicture(int position) {
        switch (position) {
            case ACTION_TYPE_ALBUM:
                Intent intent;
                if (Build.VERSION.SDK_INT < 19) {
                    intent = new Intent();
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    intent.setType("image/*");
                    startActivityForResult(Intent.createChooser(intent, "选择图片"),
                            ImageUtils.REQUEST_CODE_GETIMAGE_BYSDCARD);
                } else {
                    intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(Intent.createChooser(intent, "选择图片"),
                            ImageUtils.REQUEST_CODE_GETIMAGE_BYSDCARD);
                }
                break;
            case ACTION_TYPE_PHOTO:
                // 判断是否挂载了SD卡
                String savePath = "";
                String storageState = Environment.getExternalStorageState();
                if (storageState.equals(Environment.MEDIA_MOUNTED)) {
                    savePath = Environment.getExternalStorageDirectory()
                            .getAbsolutePath() + "/oschina/Camera/";
                    File savedir = new File(savePath);
                    if (!savedir.exists()) {
                        savedir.mkdirs();
                    }
                }


                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss")
                        .format(new Date());
                String fileName = "osc_" + timeStamp + ".jpg";// 照片命名
                File out = new File(savePath, fileName);
                Uri uri = Uri.fromFile(out);

                theLarge = savePath + fileName;// 该照片的绝对路径

                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(intent,
                        ImageUtils.REQUEST_CODE_GETIMAGE_BYCAMERA);
                break;
            default:
                break;
        }
    }

    private void insertTrendSoftware() {
        // 在光标所在处插入“#软件名#”
        int curTextLength = mEtInput.getText().length();
        if (curTextLength >= MAX_TEXT_LENGTH)
            return;
        String software = TEXT_SOFTWARE;
        int start, end;
        if ((MAX_TEXT_LENGTH - curTextLength) >= software.length()) {
            start = mEtInput.getSelectionStart() + 1;
            end = start + software.length() - 2;
        } else {
            int num = MAX_TEXT_LENGTH - curTextLength;
            if (num < software.length()) {
                software = software.substring(0, num);
            }
            start = mEtInput.getSelectionStart() + 1;
            end = start + software.length() - 1;
        }
        if (start > MAX_TEXT_LENGTH || end > MAX_TEXT_LENGTH) {
            start = MAX_TEXT_LENGTH;
            end = MAX_TEXT_LENGTH;
        }
        mEtInput.getText().insert(mEtInput.getSelectionStart(), software);
        mEtInput.setSelection(start, end);// 设置选中文字
    }

//    //初始化表情控件
//    private void initGridView() {
////        mGVFaceAdapter = new GridViewFaceAdapter(this);
//        @SuppressLint("WrongViewCast") GridView mGridView = (GridView) findViewById(R.id.ib_emoji_keyboard);
//        mGridView.setAdapter(mGVFaceAdapter);
//        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //插入的表情
//                SpannableString ss = new SpannableString(view.getTag().toString());
//                Drawable d = getResources().getDrawable((int) mGVFaceAdapter.getItemId(position));
//                d.setBounds(0, 0, 35, 35);//设置表情图片的显示大小 				ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BOTTOM); 				ss.setSpan(span, 0, view.getTag().toString().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);				 				//在光标所在处插入表情 				mContent.getText().insert(mContent.getSelectionStart(), ss);				 			} 		 	}); }
//            }
//
//        });
//    }

}
