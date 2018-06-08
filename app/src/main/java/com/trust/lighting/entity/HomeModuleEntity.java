package com.trust.lighting.entity;

import java.io.Serializable;

/**
 * Created by Talon on 2018/6/6.
 * Desc:首页模块数据实体
 */
public class HomeModuleEntity implements Serializable {

    private static final long serialVersionUID = 7432478469989376041L;
    private String title;
    private int resId;

    public HomeModuleEntity(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
