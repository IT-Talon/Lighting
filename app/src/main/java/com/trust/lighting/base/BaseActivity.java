package com.trust.lighting.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.gyf.barlibrary.ImmersionBar;
import com.trust.lighting.R;
import com.trust.lighting.manager.ActivityManager;


/**
 * Created by Talon on 2018/5/31.
 */
public class BaseActivity extends AppCompatActivity {

    private InputMethodManager imm;
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActivityManager.addActivity(this);
        //初始化沉浸式
        if (isImmersionBarEnabled())
            initImmersionBar();
    }

    @Override
    protected void onDestroy() {
        ActivityManager.removeActivity(this);
        this.imm = null;
        if (mImmersionBar != null)
            mImmersionBar.destroy();
        super.onDestroy();
    }

    @Override
    public void finish() {
        super.finish();
        hideSoftKeyBoard();
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    private void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
                .fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
                .statusBarColor(R.color.black);
        mImmersionBar.init();
    }

    public void hideSoftKeyBoard() {
        View localView = getCurrentFocus();
        if (this.imm == null) {
            this.imm = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        }
        if ((localView != null) && (this.imm != null)) {
            this.imm.hideSoftInputFromWindow(localView.getWindowToken(), 2);
        }
    }
}
