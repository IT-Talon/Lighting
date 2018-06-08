package com.trust.lighting.base;

import android.content.Intent;

public interface SimplePresenter<V> extends BasePresenter<V>
{
    void start();

    void result(int requestCode, int resultCode, Intent data);
}