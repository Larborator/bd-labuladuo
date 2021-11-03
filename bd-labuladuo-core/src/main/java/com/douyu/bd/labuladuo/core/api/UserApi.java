package com.douyu.bd.labuladuo.core.api;

import com.douyu.bd.labuladuo.core.exception.RangerClientException;
import com.douyu.bd.labuladuo.core.model.User;
import lombok.AllArgsConstructor;

/**
 * @author labuladuo
 */
@AllArgsConstructor
public class UserApi {

    private final UserFeignClient userClient;

    public User createUser(User user) throws RangerClientException {
        return userClient.createUser(user);
    }

    public void deleteUser(Integer id, boolean forceDelete) {
        userClient.deleteUser(id, forceDelete);
    }

    public User getUserByName(String name) throws RangerClientException {
        return userClient.getUserByName(name);
    }

    public User getUsers() {
        return userClient.getUsers();
    }
}
