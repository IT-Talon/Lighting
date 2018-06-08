package com.trust.lighting.http;

import android.content.Context;
import android.os.Build;

import com.trust.lighting.app.LightingApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Talon on 2018/5/31.
 */

class HttpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Context context = LightingApplication.getInstance();
//        String token = AppCache.getUserToken();
//        token = token == null ? "" : token;
        Request request = chain.request();
        request = request.newBuilder()
                //接口访问凭证：Bearer token
//                .addHeader("Authorization", "Bearer " + token)

                .addHeader("DeviceOS", "Android")
                //设备型号（如"Redmi Note 3"）
                .addHeader("DeviceVersion", Build.MODEL)
                //设备操作系统版本号
                .addHeader("OSVersion", Build.VERSION.RELEASE).build();
        return chain.proceed(request);
    }
}
