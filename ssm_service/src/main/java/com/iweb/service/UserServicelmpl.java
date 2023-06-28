package com.iweb.service;

import com.iweb.dao.UserDao;
import com.iweb.pojo.PageModel;
import com.iweb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServicelmpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> login(User user) {
        return userDao.selectByLoginnameAndPassword(user);
    }

    @Override
    public List<User> findUser(String likeValue, PageModel pageModel) {
//        当前需要分页的总数据条数
        Map<String,Object> params = new HashMap<>();
        params.put("likevalue",likeValue);
//        查询总记录条数
        int recordCount = userDao.count(params);
        pageModel.setRecordCount(recordCount);
//        开始分页查询数据,查询第几页数据
        params.put("pageIndex",pageModel.getPageIndex());
        params.put("startNum",pageModel.getStartNum());
        params.put("pageSize",pageModel.getPageSize());
        List<User> users = userDao.selectByPage(params);
        return users;
    }
}