package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.RequestParameter;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.UserInfoService;
import com.hzlx.service.impl.MenuInfoServiceImpl;
import com.hzlx.service.impl.UserInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @param
 * @return
 */
@Controller
@RequestMapping("/api/user")
public class UserInfoController {

    private UserInfoService userInfoService = new UserInfoServiceImpl();

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response){
        return userInfoService.login(request);
    }
    /**
     * 调取数据库的数据显示在页面上
     * */
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request, HttpServletResponse response) {
        userInfoService.getUserList(request);
        return "pages/user_page";
    }
    /**
     * 获取用户提交的id
     * */
    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(HttpServletRequest request,HttpServletResponse response){
        return userInfoService.getUser(request);
    }
    /**
     * 新增用户
     * */
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(HttpServletRequest request, HttpServletResponse response){
        return userInfoService.addUser(request);
    }
    /**
     * 编辑用户
     * */
    @RequestMapping("/editUser")
    @ResponseBody
    public String editUser(HttpServletRequest request,HttpServletResponse response){
        return userInfoService.editUser(request);
    }
    /**
     * 批量删除用户
     * */
    @RequestMapping("/batchDeleteUser")
    @ResponseBody
    public String batchDeleteUser(HttpServletRequest request, HttpServletResponse response){
        return userInfoService.batchDeleteUser(request);
    }
    /**
     * 删除用户
     * */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(HttpServletRequest request,HttpServletResponse response){
        return userInfoService.deleteUser(request);
    }

    /**
     * 启用用户
     * */
    @RequestMapping("/enableUser")
    @ResponseBody
    public String enableUser(HttpServletRequest request,HttpServletResponse response){
        return userInfoService.enableUser(request);
    }
}
