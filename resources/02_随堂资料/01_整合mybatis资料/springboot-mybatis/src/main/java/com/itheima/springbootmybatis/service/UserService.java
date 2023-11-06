package com.itheima.springbootmybatis.service;

import com.itheima.springbootmybatis.pojo.User;

public interface UserService {

    User findById(Integer id);
}
