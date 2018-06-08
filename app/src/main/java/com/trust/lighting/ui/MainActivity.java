package com.trust.lighting.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.trust.lighting.R;
import com.trust.lighting.adapter.MainItemAdapter;
import com.trust.lighting.base.BaseActivity;
import com.trust.lighting.entity.HomeModuleEntity;
import com.trust.lighting.entity.UserEntity;
import com.trust.lighting.http.BaseSubscriber;
import com.trust.lighting.http.RetrofitService;
import com.trust.lighting.ui.devicemanagement.DeviceManageActivity;
import com.trust.lighting.ui.faultmanagement.FaultManageActivity;
import com.trust.lighting.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends BaseActivity {

    @BindView(R.id.rec_main)
    RecyclerView mRecyclerView;

    private MainItemAdapter mAdapter;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
//        activity.overridePendingTransition(R.anim.in_rightleft, R.anim.out_rightleft);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        List<HomeModuleEntity> data = new ArrayList<>();
        data.add(new HomeModuleEntity(getResources().getString(R.string.fault_manage), R.mipmap.ic_launcher));
        data.add(new HomeModuleEntity(getResources().getString(R.string.device_manage), R.mipmap.ic_launcher));
        mAdapter = new MainItemAdapter(data);
        mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HomeModuleEntity entity = mAdapter.getData().get(position);
                switch (entity.getTitle()) {
                    case "故障管理":
                        RetrofitService.getDefault().postLogin("sdadsadada", "dsads")
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new BaseSubscriber<UserEntity>(MainActivity.this) {
                                    @Override
                                    public void onNext(UserEntity userEntity) {
                                        LogUtil.d("Talon", userEntity.getName());
                                    }
                                });
//                        FaultManageActivity.start(MainActivity.this);
                        break;
                    case "设备管理":
                        DeviceManageActivity.start(MainActivity.this);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
