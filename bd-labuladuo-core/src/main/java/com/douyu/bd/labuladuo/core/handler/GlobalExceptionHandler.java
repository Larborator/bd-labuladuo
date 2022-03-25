package com.douyu.bd.labuladuo.core.handler;

import com.douyu.bd.labuladuo.core.utils.ResultWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author labuladuo
 * @date 2022/3/25
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultWrapper<Void> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.warn("400 - Bad Request", e);
        return ResultWrapper.asError(e.getMessage());
    }

    /**
     * 404 - Not Found
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public ResultWrapper<Void> handleNoHandlerFoundException(HttpServletRequest request, NoHandlerFoundException e) {
        //正常404请求打warn日志
        log.warn("404 - Not Found, url={}, address={}, host={}, port={}", request.getRequestURL(), request.getRemoteAddr(), request.getRemoteHost(), request.getRemotePort(), e);
        return ResultWrapper.asError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultWrapper<Void> handleException(Exception e) {
        log.error("500 - Internal Server Error", e);
        return ResultWrapper.asError(e.getMessage());
    }
}
