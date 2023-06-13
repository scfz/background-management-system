package com.hzlx.dao.impl;

import com.hzlx.dao.UserInfoDao;
import com.hzlx.entity.UserInfo;
import com.hzlx.utils.BaseDao;
import com.mysql.cj.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @param
 * @return
 */
public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    @Override
    public UserInfo getUserInfoByUserNameAndPassword(String userName, String password) {
        String sql ="select * from t_user_info where user_name=? and `password`=?";
        return selectOne(sql,UserInfo.class, userName, password);
    }

    @Override
    public List<Map<String, Object>> getUserAll(String keyword) {
        String sql = "select * from t_user_info";
        if (!StringUtils.isNullOrEmpty(keyword)){
            sql += " where nick_name like concat('%',?,'%')";
            return selectListForMap(sql,keyword);
        }
        return selectListForMap(sql);
    }


    @Override
    public UserInfo getUserInfoById(Integer id) {
        String sql = "select * from t_user_info where id=?";
        return selectOne(sql, UserInfo.class, id);
    }

    @Override
    public int saveUser( String accountName,String passWord ,String nickName, String tel, String href, Integer sex, String photo) {
        String sql = "insert into t_user_info values(default,?,?,?,?,?,?,?,now(),0)";
        return executeUpdate(sql,accountName,passWord,nickName,tel,href,sex,photo);
    }

    @Override
    public int updateUserInfoById(Integer id, String accountName, String passWord, String nickName, String tel, String href, Integer sex, String photo) {
        String sql = "update t_user_info set user_name=?,nick_name=?,tel=?,address=?,sex=?,avatar=? where id=?";
        return executeUpdate(sql,accountName,nickName,tel,href,sex,photo,id);
    }

    @Override
    public int batchDeleteUserInfoById(String[] ids) {
        String sql = "update t_user_info set `status`=0 where id in(";
        for (int i = 0; i < ids.length; i++) {
            if (i == ids.length-1){
                sql+=" ?";
            }else {
                sql+=" ?,";
            }
        }
        sql+=")";
        return executeUpdate(sql,ids);
    }

    @Override
    public int deleteUserInfoById(Integer id) {
        String sql = "update t_user_info set `status`=0 where id=?";
        return executeUpdate(sql,id);
    }

    @Override
    public int batchUpdateUserStatus(String[] ids) {
        String sql = "update t_user_info set `status`=1 where id in(";
        for (int i = 0; i < ids.length; i++) {
            if (i == ids.length-1){
                sql+=" ?";
            }else {
                sql+=" ?,";
            }
        }
        sql+=")";
        return executeUpdate(sql,ids);
    }

    @Override
    public List<UserInfo> getUSerInfoBySex() {
        String sql = "select * from t_user_info where sex";
        return selectListForObject(sql, UserInfo.class);
    }
}
