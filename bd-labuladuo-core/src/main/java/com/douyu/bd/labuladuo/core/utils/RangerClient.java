package com.douyu.bd.labuladuo.core.utils;

import com.douyu.bd.labuladuo.core.api.PolicyApi;
import com.douyu.bd.labuladuo.core.api.PolicyFeignClient;
import com.douyu.bd.labuladuo.core.api.UserApi;
import com.douyu.bd.labuladuo.core.api.UserFeignClient;
import com.douyu.bd.labuladuo.core.config.RangerClientConfig;
import com.douyu.bd.labuladuo.core.decoder.RangerErrorDecoder;
import com.douyu.bd.labuladuo.core.interceptor.RangerHeadersInterceptor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 01
 * @date 2020-11-12
 **/
@Slf4j
public class RangerClient {

    @Getter
    private UserApi userApi;

    @Getter
    private PolicyApi policyApi;

    private final RangerClientConfig rangerClientConfig;

    public RangerClient(RangerClientConfig rangerClientConfig) {
        this.rangerClientConfig = rangerClientConfig;
    }

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(SerializationFeature.INDENT_OUTPUT, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static final JacksonEncoder ENCODER = new JacksonEncoder(MAPPER);
    private static final JacksonDecoder DECODER = new JacksonDecoder(MAPPER);

    /**
     * 标识client是否已启动
     */
    private final AtomicBoolean started = new AtomicBoolean(false);

    /**
     * 配置client的构建信息
     *
     * @return {@link Feign.Builder}
     */
    private Feign.Builder feignBuilder() {
        return Feign.builder()
                .logger(new Logger.JavaLogger())
                .logLevel(rangerClientConfig.getLevel())
                .options(new Request.Options(
                        rangerClientConfig.getConnectionTimeoutMills(),
                        rangerClientConfig.getReadTimeoutMills()
                )).encoder(ENCODER).decoder(DECODER)
                .client(new OkHttpClient())
                .errorDecoder(new RangerErrorDecoder())
                .requestInterceptor(new RangerHeadersInterceptor())
                .requestInterceptor(new BasicAuthRequestInterceptor(
                        rangerClientConfig.getAuthConfig().getUsername(),
                        rangerClientConfig.getAuthConfig().getPassword()
                ));
    }

    /**
     * 启动client
     */
    public void start() {
        if (started.get()) {
            log.info("ranger client is already started");
            return;
        }

        userApi = new UserApi(feignBuilder().target(
                UserFeignClient.class, rangerClientConfig.getUrl()
        ));
        policyApi = new PolicyApi(feignBuilder().target(
                PolicyFeignClient.class, rangerClientConfig.getUrl()
        ));
        started.set(true);
    }

    /**
     * 停止client
     */
    public void stop() {
        if (started.get()) {
            started.set(false);
        } else {
            log.info("ranger client is not started");
        }
    }
}
