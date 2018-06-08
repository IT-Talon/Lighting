package com.trust.lighting.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.trust.lighting.R;
import com.trust.lighting.entity.PathEntity;
import com.trust.lighting.utils.CommonUtil;

import java.util.List;

/**
 * Created by Talon on 2018/6/7.
 * Desc: 设备路径adapter
 */
public class PathAdapter extends BaseQuickAdapter<PathEntity, BaseViewHolder> {

    private List<PathEntity> datas;

    public PathAdapter(@Nullable List<PathEntity> data) {
        super(R.layout.item_path, data);
        this.datas = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, PathEntity item) {
        View view = helper.getView(R.id.view);
        TextView tvTitle = helper.getView(R.id.tv_title);
        if (helper.getLayoutPosition() == 0) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
        if (helper.getLayoutPosition() == datas.size() - 1) {
            tvTitle.setTextColor(Color.BLACK);
            tvTitle.setTextSize(13);
        } else {
            tvTitle.setTextColor(0xff696969);
            tvTitle.setTextSize(13);
        }
        tvTitle.setText(item.getTitle());
    }
}
