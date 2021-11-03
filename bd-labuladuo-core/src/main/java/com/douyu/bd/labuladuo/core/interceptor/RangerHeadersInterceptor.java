package com.douyu.bd.labuladuo.core.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 请求头拦截器，用于添加请求头
 *
 * @author 01
 * @date 2020-11-12
 **/
public class RangerHeadersInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("Accept", "application/json");
        template.header("X-XSRF_HEADER", "\"\"");
        template.header("Content-Type", "application/json");
    }
}
