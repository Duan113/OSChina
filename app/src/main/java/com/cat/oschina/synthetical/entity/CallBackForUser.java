package com.cat.oschina.synthetical.entity;

import android.os.Message;

import java.util.HashMap;

import okhttp3.internal.platform.Platform;

public interface CallBackForUser {
    void onComplete(Platform platform, int action, HashMap<String, Object> hashMap);

    void onCancel(Platform platform, int action);

    void onError(Platform platform, int action, Throwable t);

    boolean handleMessage(Message msg);

    void getUserMsg(String userJson);
}
