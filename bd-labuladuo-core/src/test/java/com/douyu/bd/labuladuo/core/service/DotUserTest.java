package com.douyu.bd.labuladuo.core.service;

import com.douyu.bd.labuladuo.core.model.DotUser;
import com.douyu.bd.labuladuo.core.model.DotUserAuto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author labuladuo
 * @date 2022/3/25
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DotUserTest {
    @Test
    public void testBuildUser() {
        DotUserAuto dotUser1 = new DotUserAuto();
        dotUser1.setOaUid(2);
        dotUser1.setOaUsername("2");
        dotUser1.setAdmin(false);

        DotUser dotUser2 = new DotUser().builder().oaUid(1).oaUsername("zsm").isAdmin(true).build();
        DotUser dotUser3 = new DotUser();
        System.out.println(dotUser3.getAdmin());

        Assert.assertNotNull(dotUser2);
    }
}
