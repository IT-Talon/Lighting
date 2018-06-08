package com.trust.lighting.http;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.trust.lighting.entity.HttpResponseEntity;
import com.trust.lighting.http.error.ApiException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Talon on 2018/6/6.
 */
public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Gson mGson;
    private final TypeAdapter<T> adapter;

    public MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        mGson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        HttpResponseEntity re = mGson.fromJson(response, HttpResponseEntity.class);
        //关注的重点，自定义响应码中非0的情况，一律抛出ApiException异常。
        //这样，我们就成功的将该异常交给onError()去处理了。
        if (!re.isSuccess()) {
            value.close();
            throw new ApiException(re.getCode(), re.getMsg());
        }

        MediaType mediaType = value.contentType();
        Charset charset = mediaType != null ? mediaType.charset(UTF_8) : UTF_8;
        ByteArrayInputStream bis = new ByteArrayInputStream(response.getBytes());
        InputStreamReader reader = new InputStreamReader(bis, charset);
        JsonReader jsonReader = mGson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}