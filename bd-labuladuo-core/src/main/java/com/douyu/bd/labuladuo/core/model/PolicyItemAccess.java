package com.douyu.bd.labuladuo.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 策略条件项中的权限信息，即在该项中拥有哪些权限，对应“Permissions”
 * https://ranger.apache.org/apidocs/json_RangerPolicyItemAccess.html
 *
 * @author 01
 * @date 2020-11-12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyItemAccess {
    private String type;
    private Boolean isAllowed;
}
