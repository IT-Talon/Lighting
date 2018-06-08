package com.trust.lighting.http.error;

/**
 * Created by Talon on 2018/6/6.
 */
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 5599144597915559472L;

    private int errorCode;

    public ApiException(int code, String msg) {
        super(msg);
        this.errorCode = code;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
