package com.douyu.bd.labuladuo.core.controller;

import com.douyu.bd.labuladuo.core.utils.ResultWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author labuladuo
 */
@Api(tags = "首页接口")
@Slf4j
@RestController
public class HelloController {

    @ApiOperation(value = "首页")
    @GetMapping(value = "/hello")
    public ResultWrapper<String> deleteDocs() {
        Runnable r = () -> {
            log.info("线程启动时间: {}", System.currentTimeMillis());
            for (long i = 0; i < 1000000000; i++) {
                long b = i+i;
                long c = b+i;
            }
            log.info("线程结束时间: {}", System.currentTimeMillis());
        };
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.execute(r);
        return ResultWrapper.asOk("hello world!");
    }

}
