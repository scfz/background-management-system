package com.hzlx.dao;

import com.hzlx.entity.BusinessInfo;

import java.util.List;
import java.util.Map;

public interface BusinessInfoDao {
    /**
     * 获取数据库的数据 显示在页面上
     * */
    List<Map<String,Object>> getBusinessAll(String keyword);
    /**
     * 通过id查找数据
     * */
    BusinessInfo getBusinessInfoById(Integer id);
    /**
     * 添加商家数据
     * */
    int saveBusiness(String accountName, String passWord, String avatar, String shopName, String href, String tel);
    /**
     * 修改商家数据
     * */
    int updateBusinessInfoById(Integer id,String accountName, String passWord, String avatar, String shopName, String href, String tel, Integer status);
    /**
     * 批量删除商家
     * */
    int batchDeleteBusinessInfoById(String[] ids);
    /**
     * 删除商家
     * */
    int deleteBusinessInfoById(Integer id);
    /**
     * 点击启用
     * */
    int batchUpdateBusinessStatus(String[] ids);
}
