package com.trust.lighting.http.error;

/**
 * Created by Talon on 2018/6/6.
 */
public interface ApiCode {
    /**
     * 网络请求成功
     */
    int HTTP_SUCCESS = 200;
    /**
     * 客户端错误
     */
    int ERROR_CLIENT_AUTHORIZED = 1;
    /**
     * 访问未授权
     */
    int ERROR_USER_AUTHORIZED = 401;
    /**
     * 请求参数错误
     */
    int ERROR_REQUEST_PARAM = 3;
    /**
     * 无网络连接
     */
    int ERROR_NO_INTERNET = 11;

}

