package com.stjh.firstdemo.service.impl;

import com.stjh.firstdemo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务实现类
 * @Author: wuge
 * @Date: 2021-2-26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("添加学生");
    }

    @Override
    public void delUser() {
        System.out.println("删除学生");
    }
}
