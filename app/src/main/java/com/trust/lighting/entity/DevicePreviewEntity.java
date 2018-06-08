package com.trust.lighting.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

/**
 * Created by Talon on 2018/6/7.
 * Desc: 设备简单描述,用作设备管理 DeviceManageAdapter 数据
 */
public class DevicePreviewEntity implements Serializable, MultiItemEntity {

    private static final long serialVersionUID = -447731218009712930L;

    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_INFO = 2;
    public static final int TYPE_IMAGE_INFO = 3;

    private int itemType;
    private int icon;
    private String title;


    public DevicePreviewEntity(String title, int itemType) {
        this.title = title;
        this.itemType = itemType;
    }

    public DevicePreviewEntity(int icon, String title, int itemType) {
        this.icon = icon;
        this.title = title;
        this.itemType = itemType;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

}
