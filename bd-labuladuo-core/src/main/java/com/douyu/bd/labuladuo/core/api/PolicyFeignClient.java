package com.douyu.bd.labuladuo.core.api;

import com.douyu.bd.labuladuo.core.model.Policy;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * 策略相关api
 * https://ranger.apache.org/apidocs/resource_PublicAPIsv2.html
 * https://ranger.apache.org/apidocs/resource_ServiceREST.html
 *
 * @author labuladuo
 **/
public interface PolicyFeignClient {

    /**
     * 创建策略
     * https://ranger.apache.org/apidocs/resource_PublicAPIsv2.html#resource_PublicAPIsv2_createPolicy_POST
     *
     * @param policy 策略信息
     * @return 策略信息
     */
    @RequestLine("POST /service/public/v2/api/policy")
    Policy createPolicy(Policy policy);

    /**
     * 删除策略
     * https://ranger.apache.org/apidocs/resource_ServiceREST.html#resource_ServiceREST_deletePolicy_DELETE
     *
     * @param id 策略id
     */
    @RequestLine("DELETE /service/plugins/policies/{id}")
    void deletePolicy(@Param("id") Integer id);

    /**
     * 通过服务和策略名称获取策略信息
     * https://ranger.apache.org/apidocs/resource_PublicAPIsv2.html#resource_PublicAPIsv2_getPolicyByName_GET
     *
     * @param serviceName 服务名称
     * @param policyName  策略名称
     * @return 策略信息
     */
    @RequestLine("GET /service/public/v2/api/service/{serviceName}/policy/{policyName}")
    Policy getPolicyByName(@Param("serviceName") String serviceName,
                           @Param("policyName") String policyName);

    /**
     * 获取指定服务下的策略信息列表
     *
     * @param serviceName 服务名称
     * @return 该服务下的策略信息列表
     */
    @RequestLine("GET /service/public/v2/api/service/{serviceName}/policy")
    List<Policy> getAllPoliciesByService(@Param("serviceName") String serviceName);
}
