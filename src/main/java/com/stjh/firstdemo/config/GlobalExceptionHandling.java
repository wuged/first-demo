package com.stjh.firstdemo.config;

import com.stjh.firstdemo.bo.Result;
import com.stjh.firstdemo.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: wuge
 * @Date: 2020/10/14
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandling {

    /**
     * 自定义异常
     */
    @ExceptionHandler(value = ServiceException.class)
    public Result processException(ServiceException e) {
        log.error("位置:{} -> 错误信息:{}", e.getMethod() ,e.getLocalizedMessage());
        return Result.error(e.getCode(), e.getMessage());
    }

    /**
     * 通用异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        e.printStackTrace();
        return Result.error(400, e.getMessage());
    }
}
