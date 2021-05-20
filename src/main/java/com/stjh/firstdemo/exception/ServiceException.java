package com.stjh.firstdemo.exception;

import com.stjh.firstdemo.constant.ResultEnum;
import lombok.Data;

/**
 * 自定义异常
 * @Author: wuge
 * @Date: 2020/10/14
 */
@Data
public class ServiceException extends RuntimeException {

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 方法名称
     */
    private final String method;

    /**
     * 自定义异常
     *
     * @param resultEnum 返回枚举对象
     * @param method     方法
     */
    public ServiceException(ResultEnum resultEnum, String method) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
        this.method = method;
    }

    /**
     * @param code    状态码
     * @param message 错误信息
     * @param method  方法
     */
    public ServiceException(Integer code, String message, String method) {
        super(message);
        this.code = code;
        this.method = method;
    }

    /**
     * @param message 错误信息
     */
    public ServiceException(String message, String method) {
        super(message);
        this.code = 400;
        this.method = method;
    }
}
