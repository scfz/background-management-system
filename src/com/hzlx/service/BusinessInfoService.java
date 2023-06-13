package com.hzlx.service;

import javax.servlet.http.HttpServletRequest;

public interface BusinessInfoService {
    /**
     * 调取数据库的数据显示在页面上
     * */
    void getBusinessList(HttpServletRequest request);
    /**
     * 获取用户提交过来的id
     * */
    String getBusiness(HttpServletRequest request);
    /**
     * 新增商家
     * */
    String addBusiness(HttpServletRequest request);
    /**
     * 编辑商家
     * */
    String editBusiness(HttpServletRequest request);
    /**
     * 批量删除商家
     * */
    String batchDeleteBusiness(HttpServletRequest request);
    /**
     * 删除商家
     * */
    String deleteBusiness(HttpServletRequest request);
    /**
     * 点击启用
     * */
    String enableBusiness(HttpServletRequest request);
}
