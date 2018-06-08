package com.trust.lighting.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.trust.lighting.R;
import com.trust.lighting.entity.DevicePreviewEntity;

import java.util.List;

/**
 * Created by Talon on 2018/6/7.
 * Desc:设备管理下面的列表adapter
 */
public class DeviceManageAdapter extends BaseMultiItemQuickAdapter<DevicePreviewEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public DeviceManageAdapter(List<DevicePreviewEntity> data) {
        super(data);
        addItemType(DevicePreviewEntity.TYPE_NORMAL, R.layout.item_device_normal);
        addItemType(DevicePreviewEntity.TYPE_INFO, R.layout.item_device_info);
        addItemType(DevicePreviewEntity.TYPE_IMAGE_INFO, R.layout.item_device_image_info);
    }

    @Override
    protected void convert(BaseViewHolder helper, DevicePreviewEntity item) {
        switch (helper.getItemViewType()) {
            case DevicePreviewEntity.TYPE_NORMAL:
                helper.setText(R.id.tv_item_title, item.getTitle());
                break;
            case DevicePreviewEntity.TYPE_INFO:
                helper.setText(R.id.tv_item_title, item.getTitle());
                break;
            case DevicePreviewEntity.TYPE_IMAGE_INFO:
                helper.setImageResource(R.id.img_item_icon, item.getIcon());
                helper.setText(R.id.tv_item_title, item.getTitle());
                break;
        }
    }
}
