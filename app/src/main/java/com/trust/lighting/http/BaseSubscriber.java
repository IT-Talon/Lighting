package com.trust.lighting.http;

import android.content.Context;

import com.trust.lighting.http.error.ApiCode;
import com.trust.lighting.http.error.ApiErrorHelper;
import com.trust.lighting.http.error.ApiException;
import com.trust.lighting.utils.CommonUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Talon on 2018/6/6.
 */
public abstract class BaseSubscriber<T> implements Observer<T> {

    private Context mContext;

    public BaseSubscriber(Context context) {
        mContext = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        //请求开始之前，检查是否有网络。无网络直接抛出异常
        //另外，在你无法确定当前代码运行在什么线程的时候，不要将UI的相关操作放在这里。
        if (!CommonUtil.isNetworkAvailable(mContext)) {
            this.onError(new ApiException(ApiCode.ERROR_NO_INTERNET, "network interrupt"));
        }
    }

    @Override
    public void onError(Throwable e) {
        ApiErrorHelper.handleCommonError(mContext, e);
    }

    @Override
    public void onComplete() {

    }

}

