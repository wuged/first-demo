package com.stjh.firstdemo.invocation;

import com.stjh.firstdemo.service.UserService;
import com.stjh.firstdemo.service.impl.UserServiceImpl;

/**
 * 静态代理
 * @Author: wuge
 * @Date: 2021-2-26
 */
public class UserServiceInvoImpl1 implements UserService {

    UserService userService;

    public UserServiceInvoImpl1(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void addUser() {
        System.out.println("准备添加");
        userService.addUser();
    }

    @Override
    public void delUser() {
        System.out.println("准备删除");
        userService.delUser();
    }

    public static void main(String[] args) {
        UserServiceInvoImpl1 userServiceInvoImpl1 = new UserServiceInvoImpl1(new UserServiceImpl());
        userServiceInvoImpl1.addUser();
        userServiceInvoImpl1.delUser();
    }
}
