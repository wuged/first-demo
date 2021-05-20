package com.stjh.firstdemo.invocation;

import com.stjh.firstdemo.service.UserService;
import com.stjh.firstdemo.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @Author: wuge
 * @Date: 2021-2-26
 */
public class UserServiceInvoImpl2 implements InvocationHandler {

    UserService userService;

    public UserServiceInvoImpl2(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法调用前。。");
        method.invoke(userService, args);
        System.out.println("方法调用后。。");
        return null;
    }

    public static void main(String[] args) {
        UserService studentService = new UserServiceImpl();
        InvocationHandler studentInvocationHandler = new UserServiceInvoImpl2(studentService);
        UserService studentServiceProxy = (UserService) Proxy.newProxyInstance(studentInvocationHandler.getClass().getClassLoader(), studentService.getClass().getInterfaces(), studentInvocationHandler);
        studentServiceProxy.addUser();
        studentServiceProxy.delUser();
    }
}
