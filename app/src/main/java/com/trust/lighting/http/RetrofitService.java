package com.trust.lighting.http;

import com.trust.lighting.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Talon on 2018/5/28.
 */

public class RetrofitService {

    private static ApiService service;

    public static ApiService getDefault() {
        if (service == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                // Log信息拦截器
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //设置 Debug Log 模式
                builder.addInterceptor(interceptor);
            }
            builder.addInterceptor(new HttpInterceptor());
            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiService.BASE_URL)
                    .client(client)
                    .addConverterFactory(MyGsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            service = retrofit.create(ApiService.class);
        }
        return service;
    }

}
