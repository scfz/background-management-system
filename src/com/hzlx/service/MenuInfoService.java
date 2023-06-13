package com.hzlx.service;

import javax.servlet.http.HttpServletRequest;

public interface MenuInfoService {
//    List<MenuInfo> showMenu(Integer userId);
    /**
     * 根据用户id,获取用户对应的菜单树
     * @param request 请求对象 用户获取请求中的参数
     * */
    String showMenu(HttpServletRequest request);
/**
 * 查询全部菜单
 * */
    void getMenuList(HttpServletRequest request);

    String getMenu(HttpServletRequest request);

    String editMenu(HttpServletRequest request);

    String batchDeleteMenu(HttpServletRequest request);
/**
 * 新增菜单
 * @param request
 * @return
 * */
    String addMenu(HttpServletRequest request);

    String enableMenu(HttpServletRequest request);

    String deleteMenu(HttpServletRequest request);


    // 自己写的
//    String alterMenu(HttpServletRequest request);
//
//    String newMenu(HttpServletRequest request);
}
