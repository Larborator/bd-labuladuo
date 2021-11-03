package com.douyu.bd.labuladuo.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 策略实体
 * https://ranger.apache.org/apidocs/json_RangerPolicy.html
 *
 * @author 01
 * @date 2020-11-12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Policy {
    private Map<String, PolicyResource> resources;
    private List<PolicyItem> policyItems = Lists.newArrayList();
    private List<PolicyItem> denyPolicyItems = Lists.newArrayList();
    private List<PolicyItem> allowExceptions = Lists.newArrayList();
    private List<PolicyItem> denyExceptions = Lists.newArrayList();
    private List<Object> dataMaskPolicyItems = Lists.newArrayList();
    private List<Object> rowFilterPolicyItems = Lists.newArrayList();

    private int id;
    private String guid;
    private boolean isEnabled;
    private int version;
    private String service;
    private String name;
    private int policyType;
    private String description;
    private boolean isAuditEnabled;
}
