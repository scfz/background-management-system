package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.MenuInfoService;
import com.hzlx.service.impl.MenuInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @param
 * @return
 */
@Controller
@RequestMapping("/api/menu")
public class MenuInfoController {

    private MenuInfoService menuInfoService=new MenuInfoServiceImpl();

    @RequestMapping("/showMenuTree")
    public String showMenuTree(HttpServletRequest request, HttpServletResponse response){
        return menuInfoService.showMenu(request);
    }

    @RequestMapping("/menuList")
    public String menuList(HttpServletRequest request,HttpServletResponse response){
        menuInfoService.getMenuList(request);
        return "pages/menu_list";
    }

    @RequestMapping("/getMenu")
    @ResponseBody
    public String getMenu(HttpServletRequest request,HttpServletResponse response){
        return menuInfoService.getMenu(request);
    }
    /**
     * 编辑菜单
     * */
    @RequestMapping("/editMenu")
    @ResponseBody
    public String edit(HttpServletRequest request,HttpServletResponse response){
        return menuInfoService.editMenu(request);
    }
    /**
     * 批量删除菜单
     * */
    @RequestMapping("/batchDeleteMenu")
    @ResponseBody
    public String batchDeleteMenu(HttpServletRequest request,HttpServletResponse response){
        return menuInfoService.batchDeleteMenu(request);
    }
    /**
     * 删除菜单
     * */
    @RequestMapping("/deleteMenu")
    @ResponseBody
    public String deleteMenu(HttpServletRequest request,HttpServletResponse response){
        return menuInfoService.deleteMenu(request);
    }

    /**
     * 添加菜单
     */
    @RequestMapping("/addMenu")
    @ResponseBody
    public String addMenu(HttpServletRequest request, HttpServletResponse response){
        return menuInfoService.addMenu(request);
    }
    /**
     * 启用菜单
     * */
    @RequestMapping("/enableMenu")
    @ResponseBody
    public String enableMenu(HttpServletRequest request,HttpServletResponse response){
        return menuInfoService.enableMenu(request);
    }


//    @RequestMapping("/alterMenu")
//    @ResponseBody
//    public String alterMenu(HttpServletRequest request,HttpServletResponse response){
//        return menuInfoService.alterMenu(request);
//    }
//
//    @RequestMapping("/newMenu")
//    @ResponseBody
//    public String newMenu(HttpServletRequest request,HttpServletResponse response){
//        return menuInfoService.newMenu(request);
//    }
}
