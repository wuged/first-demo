package com.stjh.firstdemo.controller;

import com.stjh.firstdemo.bo.Result;

/**
 * @Author: wuge
 * @Date: 2020/9/9
 */
public class BaseController {

    public Result successResult(Object data) {
        return new Result().setCode(200).setMsg("success").setData(data);
    }

    public Result successResult() {
        return new Result().setCode(200).setMsg("success");
    }

    public Result faileResult(String msg) {
        return new Result().setCode(400).setMsg(msg);
    }
}
