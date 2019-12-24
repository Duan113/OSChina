package com.cat.oschina.my.activity;

import android.content.Context;
import android.content.SharedPreferences;

import com.cat.oschina.R;

public class Utils {


    private static SharedPreferences sp;

    public static void put(Context ct, String key, String value) {
        if (sp == null)
            sp = ct.getSharedPreferences(key, 0);
        sp.edit().putString(key, value).commit();
    }

    public static String get(Context ct, String key,String value) {
        if (sp == null)
            sp = ct.getSharedPreferences(key, 0);
        if (sp.getString(key, "") != null) {
            return sp.getString(key, "");
        }
        return null;
    }
}


