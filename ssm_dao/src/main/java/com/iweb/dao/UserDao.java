package com.iweb.dao;

import com.iweb.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //根据账号密码查询用户信息
    public List<User> selectByLoginnameAndPassword(User user);

    //根据参数查询用户总数
    public Integer count(Map<String, Object> params);

    //    动态查询
    public List<User> selectByPage(Map<String, Object> params);
}
