package com.douyu.bd.labuladuo.core.api;

import com.douyu.bd.labuladuo.core.config.RangerClientConfig;
import com.douyu.bd.labuladuo.core.model.Policy;
import com.douyu.bd.labuladuo.core.model.PolicyItem;
import com.douyu.bd.labuladuo.core.model.PolicyItemAccess;
import com.douyu.bd.labuladuo.core.model.PolicyResource;
import com.douyu.bd.labuladuo.core.utils.RangerClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                .values(Collections.singletonList("/testdir"))
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

    @Test
    public void testSpel() {
        String time = "20211223" + "000000";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime date = LocalDateTime.parse(time, dateFormat);

        String time2 = "20211224" + "235959";
        LocalDateTime date2 = LocalDateTime.parse(time2, dateFormat);
        long l = Duration.between(date, date2).toDays();
        System.out.println(l);

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("T(java.time.Duration).between(T(java.time.LocalDateTime).parse(#param + '000000', T(java.time.format.DateTimeFormatter).ofPattern('yyyyMMddHHmmss')), T(java.time.LocalDateTime).now()).toDays()");
//        "T(java.time.temporal.ChronoUnit).DAYS.between(T(java.time.LocalDateTime).parse(#param + '000000', T(java.time.format.DateTimeFormatter).ofPattern(\"yyyy-MM-dd\")), T(java.time.LocalDateTime).now().format(T(java.time.format.DateTimeFormatter).ofPattern('yyyy-MM-dd')))"
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("param", "20211219");
        Object value = exp.getValue(context);
        System.out.println(value);
        assertNotNull(value);
    }
}
