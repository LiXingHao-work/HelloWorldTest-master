package com.lxh.HelloWorld.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxh.HelloWorld.dao.User;

public interface UserService extends IService<User> {
    User login(User user);
}
