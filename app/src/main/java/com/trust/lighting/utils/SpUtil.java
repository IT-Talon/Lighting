package com.trust.lighting.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.trust.lighting.app.LightingApplication;

public class SpUtil {

    private static SharedPreferences getSharedPreferences() {
        return LightingApplication.getInstance().getSharedPreferences("Lighting", Context.MODE_PRIVATE);
    }

    public static void saveString(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(String key) {
        return getString(key, null);
    }

    public static String getString(String key, String defaultValue) {
        return getSharedPreferences().getString(key, defaultValue);
    }

    public static void saveInt(String key, int value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(String key) {
        return getInt(key, 0);
    }

    public static int getInt(String key, int defaultValue) {
        return getSharedPreferences().getInt(key, defaultValue);
    }

    public static void saveLong(String key, long value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static long getLong(String key) {
        return getLong(key, 0);
    }

    public static long getLong(String key, long defaultValue) {
        return getSharedPreferences().getLong(key, defaultValue);
    }

    public static void saveBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return getSharedPreferences().getBoolean(key, defaultValue);
    }

    public static void saveDouble(String key, double value) {
        saveLong(key, Double.doubleToRawLongBits(value));
    }

    public static double getDouble(String key) {
        return getDouble(key, 0);
    }

    public static double getDouble(String key, double defaultValue) {
        return Double.longBitsToDouble(getLong(key, Double.doubleToLongBits(defaultValue)));
    }
}