package com.douyu.bd.labuladuo.core.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import feign.Logger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * http客户端配置
 *
 * @author labuladuo
 * @date 2021-11-12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RangerClientConfig {
    private int connectionTimeoutMills = 5 * 1000;
    private int readTimeoutMills = 30 * 1000;
    private Logger.Level level = Logger.Level.BASIC;
    private String url = "https://114.116.229.11:9022";
    private RangerAuthConfig authConfig = new RangerAuthConfig();
}
