package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @param
 * @return
 */
@Controller
@RequestMapping("/api/business")
public class BusinessInfoController {

    private BusinessInfoService businessInfoService = new BusinessInfoServiceImpl();

    /**
     * 调取数据库的数据显示在页面上
     * */
    @RequestMapping("/businessList")
    public String businessList(HttpServletRequest request, HttpServletResponse response) {
        businessInfoService.getBusinessList(request);
        return "pages/business_page";
    }
    /**
     * 获取商家提交的id
     * */
    @RequestMapping("/getBusiness")
    @ResponseBody
    public String getBusiness(HttpServletRequest request,HttpServletResponse response){
        return businessInfoService.getBusiness(request);
    }
    /**
     * 新增商家
     * */
    @RequestMapping("/addBusiness")
    @ResponseBody
    public String addBusiness(HttpServletRequest request, HttpServletResponse response){
        return businessInfoService.addBusiness(request);
    }
    /**
     * 编辑商家
     * */
    @RequestMapping("/editBusiness")
    @ResponseBody
    public String editBusiness(HttpServletRequest request,HttpServletResponse response){
        return businessInfoService.editBusiness(request);
    }
    /**
     * 批量删除商家
     * */
    @RequestMapping("/batchDeleteBusiness")
    @ResponseBody
    public String batchDeleteBusiness(HttpServletRequest request, HttpServletResponse response){
        return businessInfoService.batchDeleteBusiness(request);
    }
    /**
     * 删除商家
     * */
    @RequestMapping("/deleteBusiness")
    @ResponseBody
    public String deleteBusiness(HttpServletRequest request,HttpServletResponse response){
        return businessInfoService.deleteBusiness(request);
    }
    /**
     * 启用商家
     * */
    @RequestMapping("/enableBusiness")
    @ResponseBody
    public String enableBusiness(HttpServletRequest request,HttpServletResponse response){
        return businessInfoService.enableBusiness(request);
    }
}
