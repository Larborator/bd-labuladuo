package com.douyu.bd.labuladuo.core.api;

import com.douyu.bd.labuladuo.core.model.User;
import feign.Param;
import feign.RequestLine;

/**
 * 用户相关api
 * https://ranger.apache.org/apidocs/resource_XUserREST.html
 *
 * @author labuladuo
 **/
public interface UserFeignClient {

    /**
     * 创建用户接口
     * https://ranger.apache.org/apidocs/resource_XUserREST.html#resource_XUserREST_secureCreateXUser_POST
     *
     * @param user user
     * @return 用户信息
     */
    @RequestLine("POST /service/xusers/secure/users")
    User createUser(User user);

    /**
     * 删除用户
     * https://ranger.apache.org/apidocs/resource_XUserREST.html#resource_XUserREST_deleteSingleUserByUserId_DELETE
     *
     * @param id          用户id
     * @param forceDelete 是否强制删除
     */
    @RequestLine("DELETE /service/xusers/secure/users/id/{id}?forceDelete={forceDelete}")
    void deleteUser(@Param("id") Integer id,
                    @Param("forceDelete") boolean forceDelete);

    /**
     * 获取用户信息
     * https://ranger.apache.org/apidocs/resource_XUserREST.html#resource_XUserREST_getXUserByUserName_GET
     *
     * @param name 用户名称
     * @return 用户信息
     */
    @RequestLine("GET /service/xusers/users/userName/{name} ")
    User getUserByName(@Param("name") String name);

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @RequestLine("GET /mrsranger/service/xusers/users ")
    User getUsers();
}
