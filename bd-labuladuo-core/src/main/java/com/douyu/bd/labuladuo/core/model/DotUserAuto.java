package com.douyu.bd.labuladuo.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author labuladuo
 * @date 2022/3/25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DotUserAuto {
    private Integer oaUid;
    private String oaUsername;
    private Boolean admin;
}
