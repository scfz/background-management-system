package com.hzlx.dao;

import com.hzlx.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoDao {
    /**
     * 根据用户名和密码 查询用户信息
     * @param userName 用户名
     * @param password 密码
     * */
    UserInfo getUserInfoByUserNameAndPassword(String userName, String password);
    /**
     * 获取数据库的数据 显示在页面上
     * */
    List<Map<String,Object>> getUserAll(String keyword);
    /**
     * 通过id查找数据
     * */
    UserInfo getUserInfoById(Integer id);
    /**
     * 添加用户数据
     * */
    int saveUser( String accountName,String passWord ,String nickName, String tel, String href, Integer sex, String photo);
    /**
     * 修改用户数据
     * */
    int updateUserInfoById(Integer id, String accountName, String passWord, String nickName, String tel, String href, Integer sex, String photo);

    /**
     * 批量删除用户
     * */
    int batchDeleteUserInfoById(String[] ids);
    /**
     * 删除用户
     * */
    int deleteUserInfoById(Integer id);
    /**
     * 启用用户
     * */
    int batchUpdateUserStatus(String[] ids);


    List<UserInfo> getUSerInfoBySex();
}
