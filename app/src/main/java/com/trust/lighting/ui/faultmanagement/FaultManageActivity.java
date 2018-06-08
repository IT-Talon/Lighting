package com.trust.lighting.ui.faultmanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.trust.lighting.R;
import com.trust.lighting.base.BaseActivity;

public class FaultManageActivity extends BaseActivity {


    public static void start(Activity activity) {
        Intent intent = new Intent(activity, FaultManageActivity.class);
        activity.startActivity(intent);
//        activity.overridePendingTransition(R.anim.in_rightleft, R.anim.out_rightleft);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fault_manage);
    }
}
