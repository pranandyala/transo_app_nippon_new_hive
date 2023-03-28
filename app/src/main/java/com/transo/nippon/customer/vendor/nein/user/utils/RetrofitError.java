package com.transo.nippon.customer.vendor.nein.user.utils;

public class RetrofitError {

    private int statusCode;
    private String message;

    public RetrofitError() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }
}