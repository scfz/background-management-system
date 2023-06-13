package com.hzlx.service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserInfoService {
    /**
     * 用户登录方法
     * @param request http请求,用于获取用户提交的数据
     *
     * */
    String login(HttpServletRequest request);
    /**
     * 调取数据库的数据显示在页面上
     * */
    void getUserList(HttpServletRequest request);
    /**
     * 获取用户提交过来的id
     * */
    String getUser(HttpServletRequest request);
    /**
     * 新增用户
     * */
    String addUser(HttpServletRequest request);

    String editUser(HttpServletRequest request);
    /**
     * ;批量删除用户
     * */
    String batchDeleteUser(HttpServletRequest request);
    /**
     * 删除用户
     * */
    String deleteUser(HttpServletRequest request);
    /**
     * 启用用户
     * */
    String enableUser(HttpServletRequest request);


}
