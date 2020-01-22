//package com.example.demoapi;
//
//import com.example.demoapi.Response.CommonResponse;
//import com.example.demoapi.Service.FastService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//
//import java.util.concurrent.Callable;
//
//public class ExpensiveTask<T> implements Callable<CommonResponse<T>> {
//
////    @Autowired
////    private FastService fastService;
////
////    public ExpensiveTask(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<CommonResponse<T>> type) {
////        this.url = url;
////        this.method = method;
////        this.requestEntity = requestEntity;
////        this.type = type;
////    }
////
////    private String url;
////    private HttpMethod method;
////    private HttpEntity<?> requestEntity;
////    private ParameterizedTypeReference<CommonResponse<T>> type;
////
////
////    @Override
////    public CommonResponse<T> call() throws Exception {
////        return fastService.restTemplateCall(url,method,requestEntity,type);
////    }
//
//}
