package com.cat.oschina;

import android.app.Application;
import android.os.Environment;

import com.okhttplib.OkHttpUtil;
import com.okhttplib.annotation.CacheType;
import com.okhttplib.annotation.Encoding;
import com.okhttplib.cookie.PersistentCookieJar;
import com.okhttplib.cookie.cache.SetCookieCache;
import com.okhttplib.cookie.persistence.SharedPrefsCookiePersistor;

import java.io.File;

public class MyApplication extends Application {
    private static String APPKEY = "14ce7f774ef10";
    // 填写从短信SDK应用后台注册得到的APPSECRET
    private static String APPSECRET = "04e0f08d04a22edd307247a4e947c88d";
    @Override
    public void onCreate() {
        super.onCreate();

        String downloadFileDir = Environment.getExternalStorageDirectory().getPath() +
                "/myOsChina/okHttp_download/";
        String cacheDir = Environment.getExternalStorageDirectory().getPath() +
                "/myOsChina/okHttp_cache";
        OkHttpUtil.init(getApplicationContext())
                .setConnectTimeout(15)
                .setWriteTimeout(15)
                .setReadTimeout(15)
                .setMaxCacheSize(10*1024*1024)
                .setCacheType(CacheType.FORCE_NETWORK)
                .setHttpLogTAG("HttpLog")
                .setIsGzip(false)
                .setShowHttpLog(true)
                .setShowLifecycleLog(false)
                .setRetryOnConnectionFailure(false)
                .setCachedDir(new File(cacheDir))
                .setDownloadFileDir(downloadFileDir)
                .setResponseEncoding(Encoding.UTF_8)
                .setRequestEncoding(Encoding.UTF_8)
                .setCookieJar(new PersistentCookieJar(new SetCookieCache(),new SharedPrefsCookiePersistor(getApplicationContext())))
                .build();
    }
}
