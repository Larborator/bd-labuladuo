package com.douyu.bd.labuladuo.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author labuladuo
 */
@Slf4j
@SpringBootApplication
public class ApplicationLauncher {
    public static void main(String[] args) {
        log.info("args: {}", Arrays.toString(args));
        SpringApplication.run(ApplicationLauncher.class, args);
    }
}
