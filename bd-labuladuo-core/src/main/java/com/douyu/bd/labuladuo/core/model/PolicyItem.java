package com.douyu.bd.labuladuo.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * 策略中的条件项，对应“Allow Conditions”或“Deny Conditions”中的每一栏信息
 * https://ranger.apache.org/apidocs/json_RangerPolicyItem.html
 *
 * @author 01
 * @date 2020-11-12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyItem {
    private List<PolicyItemAccess> accesses = Lists.newArrayList();
    private Set<String> users = Sets.newHashSet();
    private List<String> groups = Lists.newArrayList();
    private List<PolicyItemCondition> conditions = Lists.newArrayList();
    private Boolean delegateAdmin;
}
