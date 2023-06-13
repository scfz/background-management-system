package com.hzlx.dao.impl;

import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.entity.UserInfo;
import com.hzlx.utils.BaseDao;
import com.mysql.cj.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @param
 * @return
 */
public class BusinessInfoDaoImpl extends BaseDao<BusinessInfo> implements BusinessInfoDao {
    @Override
    public List<Map<String, Object>> getBusinessAll(String keyword) {
        String sql = "select * from t_business_info";
        if (!StringUtils.isNullOrEmpty(keyword)){
            sql += " where shop_name like concat('%',?,'%')";
            return selectListForMap(sql,keyword);
        }
        return selectListForMap(sql);
    }

    @Override
    public BusinessInfo getBusinessInfoById(Integer id) {
        String sql = "select * from t_business_info where id=?";
        return selectOne(sql, BusinessInfo.class, id);
    }

    @Override
    public int saveBusiness(String accountName, String passWord, String avatar, String shopName, String href, String tel) {
        String sql = "insert into t_business_info values(default,?,?,?,?,?,?,now(),default)";
        return executeUpdate(sql,accountName,passWord,avatar,shopName,href,tel);
    }

    @Override
    public int updateBusinessInfoById(Integer id,String accountName, String passWord, String avatar, String shopName, String href, String tel, Integer status) {
        String sql = "update t_business_info set user_name=?,avatar=?,shop_name=?,address=?,tel=?,status=? where id=?";
        return executeUpdate(sql,accountName,avatar,shopName,href,tel,status,id);
    }

    @Override
    public int batchDeleteBusinessInfoById(String[] ids) {
        String sql = "update t_business_info set `status`=0 where id in(";
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
    public int deleteBusinessInfoById(Integer id) {
        String sql = "update t_business_info set `status`=0 where id=?";
        return executeUpdate(sql,id);
    }

    @Override
    public int batchUpdateBusinessStatus(String[] ids) {
        String sql = "update t_business_info set `status`=1 where id in(";
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
}
