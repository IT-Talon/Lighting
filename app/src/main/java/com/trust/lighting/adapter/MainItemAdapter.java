package com.trust.lighting.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.trust.lighting.R;
import com.trust.lighting.entity.HomeModuleEntity;

import java.util.List;

/**
 * Created by Talon on 2018/6/6.
 * Desc: 首页模块adapter
 */
public class MainItemAdapter extends BaseQuickAdapter<HomeModuleEntity, BaseViewHolder> {

    private List<HomeModuleEntity> datas;

    public MainItemAdapter(@Nullable List<HomeModuleEntity> data) {
        super(R.layout.item_home_module, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeModuleEntity item) {
        helper.setText(R.id.tv_item_title, item.getTitle());
        helper.setImageResource(R.id.img_item_res, item.getResId());
    }
}
