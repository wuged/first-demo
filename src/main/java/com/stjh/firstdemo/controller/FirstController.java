package com.stjh.firstdemo.controller;

import com.stjh.firstdemo.bo.Result;
import com.stjh.firstdemo.dao.UserMapper;
import com.stjh.firstdemo.entity.User;
import com.stjh.firstdemo.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 第一个控制器
 * @Author: wuge
 * @Date: 2020/8/28
 */
@RestController
@RequestMapping("/api")
public class FirstController extends BaseController {

    @Value("${server.port}")
    private String port;

    @Resource
    private UserMapper userMapper;

    @GetMapping("/port")
    public String getMyPort() {
        return "我是第一个项目的端口号：" + port;
    }

    @GetMapping("/users")
    public Result getUsers() {
        User user = userMapper.selectByPrimaryKey(1);
        return successResult(user);
    }

    @GetMapping("/test")
    public void test() {
        try {
            int a = 1/0;
        } catch (Exception e) {
            throw new ServiceException("瞎算", "test");
        }
    }
}
