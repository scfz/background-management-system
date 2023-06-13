package com.hzlx.dao;

import com.hzlx.entity.MenuInfo;

import java.util.List;
import java.util.Map;

/**
 * @param
 * @return
 */
public interface MenuInfoDao {
    /**
     * 根据菜单PId来获取菜单集合
     */
    List<MenuInfo> getMenuInfoListByPid(Integer userId,Integer pId);

    List<Map<String,Object>> getMenuAll(String keyword);

    MenuInfo getMenuInfoById(Integer id);

    int updateMenuInfoById(Integer id,String title,String icon,String href,Integer pId);

    int batchDeleteMenuInfoById(String[] ids);
    /**
     * 删除菜单   sql语句
     * */
    int deleteMenuInfoById(Integer id);

    int saveMenu(String title, String icon, String href, Integer pId);

    List<MenuInfo> getMenuInfoByPid(Integer pId);

    int batchUpdateMenuStatus(String[] ids);




    /*
    int alterMenuInfoById(Integer id);   改变表单

     添加菜单
    int addMenuInfoById(String title,String icon,String href,Integer pId);
    */
}
