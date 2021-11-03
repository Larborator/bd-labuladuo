package com.douyu.bd.labuladuo.core.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 配置ranger admin的用户名和密码
 *
 * @author 01
 * @date 2020-11-12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RangerAuthConfig {
    private String username = "labuladuo";
    private String password = "mvS3G6d2IA";
}
