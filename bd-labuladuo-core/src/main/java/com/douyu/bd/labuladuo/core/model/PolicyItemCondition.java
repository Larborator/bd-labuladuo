package com.douyu.bd.labuladuo.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * https://ranger.apache.org/apidocs/json_RangerPolicyItemCondition.html
 *
 * @author 01
 * @date 2020-11-12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyItemCondition {
    private String type;
    private List<String> value = Lists.newArrayList();
}
