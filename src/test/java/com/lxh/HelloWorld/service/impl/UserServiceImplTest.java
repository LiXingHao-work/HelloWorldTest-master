package com.lxh.HelloWorld.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lxh.HelloWorld.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lxh.HelloWorld.dao.User;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUserTest() {
        User user = User.builder()
                .id(1)
                .account("123")
                .name("lxh")
                .password("123")
                .build();
        userMapper.insert(user);
        System.out.println("插入成功");
    }

    @Test
    public void selectUserTest() {
        System.out.println(userMapper.selectById(1));
        System.out.println("查询成功");
    }

    @Test
    public void updateUserTest() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name","lxh").set("name", "123");
        userMapper.update(null, updateWrapper);
        System.out.println("更新成功");
    }

    @Test
    public void deleteUserTest() {
        userMapper.deleteById(1);
    }
}