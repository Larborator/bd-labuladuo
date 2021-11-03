package com.douyu.bd.labuladuo.core.api;

import com.douyu.bd.labuladuo.core.utils.RangerClient;
import com.douyu.bd.labuladuo.core.config.RangerClientConfig;
import com.douyu.bd.labuladuo.core.model.Policy;
import com.douyu.bd.labuladuo.core.model.PolicyItem;
import com.douyu.bd.labuladuo.core.model.PolicyItemAccess;
import com.douyu.bd.labuladuo.core.model.PolicyResource;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertNotNull;

public class PolicyApiTest {

    private static RangerClient rangerClient;

    @Before
    public void initRangerClient() {
        rangerClient = new RangerClient(new RangerClientConfig());
        rangerClient.start();
    }

    @Test
    public void testCreatePolicy() {
        PolicyResource policyResource = PolicyResource.builder()
                .values(Collections.singletonList("/testdir2"))
                .isRecursive(true)
                .build();

        Map<String, PolicyResource> policyResourceMap = new HashMap<>();
        policyResourceMap.put("path", policyResource);

        Set<String> users = new HashSet<>();
        users.add("hive");

        List<PolicyItemAccess> policyItemAccessList = new ArrayList<>();
        policyItemAccessList.add(PolicyItemAccess.builder().type("read").build());
        policyItemAccessList.add(PolicyItemAccess.builder().type("write").build());
        policyItemAccessList.add(PolicyItemAccess.builder().type("execute").build());

        PolicyItem policyItem = PolicyItem.builder()
                .delegateAdmin(true).users(users)
                .accesses(policyItemAccessList)
                .build();

        Policy policy = Policy.builder()
                .service("dev_hdfs")
                .name("test_ranger_api")
                .isEnabled(true).policyType(0)
                .resources(policyResourceMap)
                .policyItems(Collections.singletonList(policyItem))
                .build();

        Policy result = rangerClient.getPolicyApi().createPolicy(policy);
        assertNotNull(result);
        System.out.println(result.getName());
    }

    @Test
    public void testGetPolicyByName() {
        Policy result = rangerClient.getPolicyApi()
                .getPolicyByName("dev_hdfs", "test_ranger_api");
        assertNotNull(result);
        System.out.println(result.getName());
    }

    @Test
    public void testGetAllPoliciesByService() {
        List<Policy> result = rangerClient.getPolicyApi()
                .getAllPoliciesByService("dev_hdfs");
        assertNotNull(result);
        System.out.println(result.size());
    }

    @Test
    public void testDeletePolicy() {
        Policy result = rangerClient.getPolicyApi()
                .getPolicyByName("dev_hdfs", "test_ranger_api");
        assertNotNull(result);
        rangerClient.getPolicyApi().deletePolicy(result.getId());
        System.out.println(result.getName());
    }
}