package com.douyu.bd.labuladuo.core.api;

import com.douyu.bd.labuladuo.core.utils.RangerClient;
import com.douyu.bd.labuladuo.core.config.RangerClientConfig;
import com.douyu.bd.labuladuo.core.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertNotNull;

public class UserApiTest {

    private static RangerClient rangerClient;

    @Before
    public void initRangerClient() {
        rangerClient = new RangerClient(new RangerClientConfig());
        rangerClient.start();
    }

    @Test
    public void testCreateUser() {
        User user = User.builder().name("test")
                .firstName("first").lastName("last").password("user@123")
                .isVisible(1).status(1).userSource(0)
                .userRoleList(Collections.singletonList("ROLE_USER"))
                .build();

        User result = rangerClient.getUserApi().createUser(user);
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void testDeleteUser() {
        User result = rangerClient.getUserApi().getUserByName("test");
        assertNotNull(result);
        rangerClient.getUserApi().deleteUser(result.getId(), true);
    }

    @Test
    public void testGetUserByName() {
        User result = rangerClient.getUserApi().getUserByName("test");
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void testGetUsers() {
        User result = rangerClient.getUserApi().getUsers();
        assertNotNull(result);
        System.out.println(result);
    }
}
