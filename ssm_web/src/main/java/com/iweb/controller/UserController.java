package com.iweb.controller;


import com.iweb.pojo.PageModel;
import com.iweb.pojo.User;
import com.iweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    /*
    用户登录
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView, @RequestParam String loginname, @RequestParam String password, HttpSession session){
        //调用业务逻辑判断用户是否可以登录
        List<User> list = userService.login(new User(loginname,password));
        if (list!=null&&list.size()>0){
            session.setAttribute("user_session",list.get(0));
            modelAndView.setViewName("main");
        }else {
                //设置登录失败信息
            modelAndView.addObject("message","登录失败，账号或密码错误");
            modelAndView.setViewName("loginForm");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/selectUser")
    public String selectUser(Model model,@RequestParam("pageIndex") String pageIndex, @RequestParam("likevalue") String likevalue){
        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(pageIndex!=null?Integer.parseInt(pageIndex):1);
        pageModel.setStartNum((pageModel.getPageIndex()-1)*pageModel.getPageSize());
        List<User> users=userService.findUser(likevalue,pageModel);
        model.addAttribute("users",users);
        model.addAttribute("pageModel",pageModel);
        model.addAttribute("likevalue",likevalue);

        return "user/user";
    }


    @RequestMapping(value = "/toUpdateUser")
    public ModelAndView toUpdateUser(@RequestParam("id") String id, ModelAndView modelAndView){
        //根据id查询对象
        User user = userService.findUserById(id);
        modelAndView.addObject("user",user);
        //设置客户端跳转到查询请求
        modelAndView.setViewName("user/addOrUpdateUser");
        return modelAndView;
    }


    @RequestMapping(value = "/updateUser")
    public ModelAndView updateUser(@ModelAttribute User user, ModelAndView modelAndView){
        //执行修改操作
        userService.updateUser(user);
        //设置客户端跳转到查询请求
        modelAndView.setViewName("forward:/selectUser?pageIndex=1&likevalue=");
        return modelAndView;
    }
}
