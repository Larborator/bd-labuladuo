package com.douyu.bd.labuladuo.core.controller;

import com.douyu.bd.labuladuo.core.service.GetService;
import com.douyu.bd.labuladuo.core.utils.ResultWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author labuladuo
 */
@Api(tags = "接口测试")
@Slf4j
@RestController
@AllArgsConstructor
public class HelloController {
    private final GetService getService;

    @ApiOperation(value = "首页")
    @GetMapping(value = "/get")
    public ResultWrapper<String> getService() {
        getService.get();
        return ResultWrapper.asOk();
    }


}
