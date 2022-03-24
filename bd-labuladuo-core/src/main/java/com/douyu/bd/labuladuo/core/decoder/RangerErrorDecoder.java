package com.douyu.bd.labuladuo.core.decoder;

import com.douyu.bd.labuladuo.core.exception.RangerClientException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;

/**
 * 异常信息解析
 *
 * @author labuladuo
 * @date 2021-11-12
 **/
public class RangerErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return new RangerClientException(response.status(), errorMessage(methodKey, response));
    }

    private String errorMessage(String methodKey, Response response) {
        String msg = String.format("status %s reading %s", response.status(), methodKey);
        if (response.body() != null) {
            try {
                msg += "content:\n" + Util.toString(response.body().asReader());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }
}
