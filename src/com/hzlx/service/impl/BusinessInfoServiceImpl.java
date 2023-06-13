package com.hzlx.service.impl;

import com.hzlx.component.BgmsConfig;
import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.dao.impl.BusinessInfoDaoImpl;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.entity.UserInfo;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.utils.BaseResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @param
 * @return
 */
public class BusinessInfoServiceImpl implements BusinessInfoService {

    private BusinessInfoDao businessInfoDao = new BusinessInfoDaoImpl();
    @Override
    public void getBusinessList(HttpServletRequest request) {
        // 搜索框 搜索对应的名字
        String keyword = request.getParameter("keyword");
        request.setAttribute(BgmsConfig.BUSINESS_LIST,businessInfoDao.getBusinessAll(keyword));
        request.setAttribute(BgmsConfig.KEYWORD, keyword);
    }

    @Override
    public String getBusiness(HttpServletRequest request) {
        //获取用户提交过来的 BusinessId
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (id==null){
            return BaseResult.error(50001,"请求数据异常");
        }
        BusinessInfo businessInfo= businessInfoDao.getBusinessInfoById(id);
        return BaseResult.success(businessInfo);
    }

    @Override
    public String addBusiness(HttpServletRequest request) {
        String accountName = request.getParameter("accountName");
        String passWord = request.getParameter("passWord");
        String avatar = request.getParameter("avatar");
        String shopName = request.getParameter("shopName");
        String href = request.getParameter("href");
        String tel = request.getParameter("tel");
        int rows = businessInfoDao.saveBusiness(accountName,passWord,avatar,shopName,href,tel);
        if (rows>0){
            return BaseResult.success();
        }
        return BaseResult.error(50003,"新增商家失败");
    }

    @Override
    public String editBusiness(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String accountName = request.getParameter("accountName");
        String passWord = request.getParameter("passWord");
        String avatar = request.getParameter("avatar");
        String shopName = request.getParameter("shopName");
        String href = request.getParameter("href");
        String tel = request.getParameter("tel");
        Integer status = Integer.parseInt(request.getParameter("status"));
        //TODO 参数校验  如果非空字段为空 给出错误提示
        int rows= businessInfoDao.updateBusinessInfoById(id,accountName,passWord,avatar,shopName,href,tel,status);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(50002,"修改商家失败");
        }
    }

    @Override
    public String batchDeleteBusiness(HttpServletRequest request) {
        String idStr = request.getParameter("ids");
        String[] ids = idStr.substring(0, idStr.length() - 1).split(",");
        //TODO 判空
        int rows= businessInfoDao.batchDeleteBusinessInfoById(ids);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(50002,"删除商家失败");
        }
    }

    @Override
    public String deleteBusiness(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        int rows= businessInfoDao.deleteBusinessInfoById(id);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(50002,"删除商家失败");
        }
    }

    @Override
    public String enableBusiness(HttpServletRequest request) {
        String idsStr = request.getParameter("ids");
        String[] ids = idsStr.substring(0, idsStr.length() - 1).split(",");
        int rows = businessInfoDao.batchUpdateBusinessStatus(ids);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(40004,"启用商家失败");
        }
    }
}
