package com.transo.nippon.customer.vendor.nein.user.utils;//package com.ezyloads.transo.nippon.shipper.utils;
//
//import java.io.IOException;
//import java.lang.annotation.Annotation;
//
//import okhttp3.ResponseBody;
//import retrofit2.Converter;
//import retrofit2.Response;
//
//public class RetrofitErrorUtils {
//
//    public static RetrofitError parseError(Response<?> response) {
//        Converter<ResponseBody, RetrofitError> converter =
//                ServiceGenerator.retrofit()
//                        .responseBodyConverter(RetrofitError.class, new Annotation[0]);
//
//        RetrofitError error;
//
//        try {
//            error = converter.convert(response.errorBody());
//        } catch (IOException e) {
//            return new RetrofitError();
//        }
//        return error;
//    }
//}
