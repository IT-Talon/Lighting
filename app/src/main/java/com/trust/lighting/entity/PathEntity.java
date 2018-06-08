package com.trust.lighting.entity;

import java.io.Serializable;

/**
 * Created by Talon on 2018/6/7.
 * Desc:描述设备路径实体
 */
public class PathEntity implements Serializable {

    private static final long serialVersionUID = 8407636167739633052L;
    private String title;

    public PathEntity(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
