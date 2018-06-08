package com.trust.lighting.base;

import android.content.Context;

public interface SimpleView<P> extends BaseView<P> {

    Context getContext();

    void showToast(String content);

    void showOrHideProgressView(boolean show);

}