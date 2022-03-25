package com.douyu.bd.labuladuo.core.service.impl;

import com.douyu.bd.labuladuo.core.service.GetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author labuladuo
 * @date 2022/3/24
 */
@Slf4j
@Service
public class GetServiceImpl implements GetService {
    @Override
    public void get() {
        log.info("Class is: {}", this);
    }
}
