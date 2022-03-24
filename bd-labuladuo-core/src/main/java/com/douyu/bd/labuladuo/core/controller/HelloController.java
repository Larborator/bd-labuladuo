package com.douyu.bd.labuladuo.core.controller;

import com.douyu.bd.labuladuo.core.utils.ResultWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author labuladuo
 */
@Api(tags = "首页接口")
@Slf4j
@RestController
@RequestMapping("/home")
public class HelloController {
    @ApiOperation(value = "首页")
    @GetMapping(value = "/hello")
    public ResultWrapper<String> sayHello() {
        return ResultWrapper.asOk("hello world!");
    }
}
