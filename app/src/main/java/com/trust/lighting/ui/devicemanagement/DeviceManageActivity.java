package com.trust.lighting.ui.devicemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.trust.lighting.R;
import com.trust.lighting.adapter.PathAdapter;
import com.trust.lighting.base.BaseActivity;
import com.trust.lighting.entity.PathEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeviceManageActivity extends BaseActivity {

    @BindView(R.id.rec_path)
    RecyclerView mRecyclerView;
    @BindView(R.id.content_view)
    FrameLayout mContentView;

    private PathAdapter mAdapter;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, DeviceManageActivity.class);
        activity.startActivity(intent);
//        activity.overridePendingTransition(R.anim.in_rightleft, R.anim.out_rightleft);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_manage);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        List<PathEntity> datas = new ArrayList<>();
        datas.add(new PathEntity("默认根目录"));
        datas.add(new PathEntity("/目录1"));
        datas.add(new PathEntity("/目录2"));
        mAdapter = new PathAdapter(datas);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }
}
