package com.trust.lighting.entity;

import com.trust.lighting.http.error.ApiCode;

import java.io.Serializable;

/**
 * Created by Talon on 2018/6/5.
 * Desc:网络请求返回数据模型
 */
public class HttpResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = 386002752966058442L;
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return code == ApiCode.HTTP_SUCCESS;
    }
}
