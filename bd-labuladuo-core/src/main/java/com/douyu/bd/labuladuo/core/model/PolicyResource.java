package com.douyu.bd.labuladuo.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 策略所作用的资源，即hdfs目录、hive的库/表/列等
 * https://ranger.apache.org/apidocs/json_RangerPolicyResource.html
 *
 * @author labuladuo
 * @date 2021-11-12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyResource {
    private List<String> values = Lists.newArrayList();
    private Boolean isExcludes;
    private Boolean isRecursive;
}
