package com.douyu.bd.labuladuo.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户信息实体类
 * https://ranger.apache.org/apidocs/json_VXUser.html
 *
 * @author 01
 * @date 2020-11-12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;
    private String name;
    private String createDate;
    private String updateDate;
    private String owner;
    private String updateBy;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String description;
    private int status;
    private int isVisible;
    private int userSource;
    private List<String> userRoleList;
}
