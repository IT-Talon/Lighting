package com.trust.lighting.http;


import com.trust.lighting.entity.UserEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Talon on 2018/5/28.
 */

public interface ApiService {

//    public static final String BASE_URL = "http://116.62.48.231:10081/api/";
    public static final String BASE_URL = "http://47.106.133.127:8000/api/";

    //用户登录
    @FormUrlEncoded
    @POST("login")
    Observable<UserEntity> postLogin(@Field("telephone") String telephone, @Field("password") String password);

    // 查询所有项目
//    @GET("projects")
//    Observable<HttpResponseModel<List<ProjectModel>>> getProjects();
}
