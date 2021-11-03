package com.douyu.bd.labuladuo.core.api;

import com.douyu.bd.labuladuo.core.model.Policy;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author labuladuo
 **/
@AllArgsConstructor
public class PolicyApi {

    private final PolicyFeignClient policyFeignClient;

    public Policy getPolicyByName(String serviceName, String policyName)  {
        return policyFeignClient.getPolicyByName(serviceName, policyName);
    }

    public List<Policy> getAllPoliciesByService(String serviceName)  {
        return policyFeignClient.getAllPoliciesByService(serviceName);
    }

    public Policy createPolicy(Policy policy)  {
        return policyFeignClient.createPolicy(policy);
    }

    public void deletePolicy(Integer id) {
        policyFeignClient.deletePolicy(id);
    }
}
