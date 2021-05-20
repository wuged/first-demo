package com.stjh.firstdemo.bo;

import lombok.Data;

/**
 * 返回封装实体
 * @Author: wuge
 * @Date: 2020/9/9
 */
@Data
public class Result {

    private Integer code;

    private String msg;

    private Object data;

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public static Result error(Integer code, String msg) {
        return new Result().setCode(code).setMsg(msg);
    }

    public static Result success(String msg) {
        return new Result().setCode(200).setMsg(msg);
    }

    public static Result success(Object data) {
        return new Result().setCode(200).setData(data).setMsg("操作成功！");
    }
}
