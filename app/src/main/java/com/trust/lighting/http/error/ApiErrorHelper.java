package com.trust.lighting.http.error;

import android.content.Context;
import android.widget.Toast;

import com.trust.lighting.utils.LogUtil;

import java.io.IOException;

import retrofit2.HttpException;

/**
 * Created by Talon on 2018/6/6.
 */

public class ApiErrorHelper {
    public static void handleCommonError(Context context, Throwable e) {
        String msg = "未知错误";
        if (e instanceof HttpException) {
            msg = "服务暂不可用";
        } else if (e instanceof IOException) {
            msg = "连接失败";
        } else if (e instanceof ApiException) {
            //ApiException处理
            ApiException apiException = (ApiException) e;
            switch (apiException.getErrorCode()) {
                case ApiCode.ERROR_CLIENT_AUTHORIZED:
                    msg = "客户端错误";
                    break;
                case ApiCode.ERROR_USER_AUTHORIZED:
                    msg = "访问未授权";
                    break;
                case ApiCode.ERROR_REQUEST_PARAM:
                    msg = "请求参数错误";
                    break;
                default:
                    break;
            }
        }
        LogUtil.e("OKHttpApiError", msg);
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}