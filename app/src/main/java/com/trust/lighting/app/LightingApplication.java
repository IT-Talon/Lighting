package com.trust.lighting.app;

import android.app.Application;

/**
 * Created by Talon on 2018/5/30.
 */
public class LightingApplication extends Application {

    private static LightingApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        init();
    }

    private void init() {
    }

    public static LightingApplication getInstance() {
        return instance;
    }
}
