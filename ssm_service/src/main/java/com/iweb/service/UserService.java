package com.iweb.service;

import com.iweb.pojo.PageModel;
import com.iweb.pojo.User;


import java.util.List;
import java.util.Map;

public interface UserService {
    //用户登录
    public List<User> login(User user);


    //User对象的list集合
    public List<User> findUser(String likevalue, PageModel pageModel);


    public User findUserById(String id);

    public void updateUser(User user);
}
