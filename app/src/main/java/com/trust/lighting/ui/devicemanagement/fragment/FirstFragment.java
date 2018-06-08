package com.trust.lighting.ui.devicemanagement.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trust.lighting.R;
import com.trust.lighting.adapter.DeviceManageAdapter;
import com.trust.lighting.base.BaseFragment;
import com.trust.lighting.entity.DevicePreviewEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */

public class FirstFragment extends BaseFragment {

    @BindView(R.id.rec_content)
    RecyclerView mRecContent;
    Unbinder unbinder;

    private DeviceManageAdapter mAdapter;

    public static FirstFragment newInstance() {

        Bundle args = new Bundle();

        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mAdapter = new DeviceManageAdapter(new ArrayList<DevicePreviewEntity>());
        mRecContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecContent.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
