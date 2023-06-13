package com.hzlx.service.impl;

import com.hzlx.component.BgmsConfig;
import com.hzlx.dao.UserInfoDao;
import com.hzlx.dao.impl.UserInfoDaoImpl;
import com.hzlx.entity.MenuInfo;
import com.hzlx.entity.UserInfo;
import com.hzlx.service.UserInfoService;
import com.hzlx.utils.BaseResult;
import com.hzlx.utils.MD5Utils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @param
 * @return
 */
public class UserInfoServiceImpl implements UserInfoService {
    //引入dao层，用户查询数据库
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();

    @Override
    public String login(HttpServletRequest request) {
        //从请求中获取用户名和密码
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //用户名和密码做非空校验
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            return BaseResult.error(10001, "用户名或密码不能为空");
        }
        //给密码加密
        String encryptPwd = MD5Utils.encryptMD5(password, userName);
        //拿加密后的密码和用户名去数据库里查询用户信息
        UserInfo userInfo = userInfoDao.getUserInfoByUserNameAndPassword(userName, encryptPwd);
        //如果查询到的 userInfo为空，则说明用户不存在，判定为账号或密码错误
        if (userInfo == null) {
            return BaseResult.error(10002, "账号或密码错误");
        }
        //用户登录成功之后，把用户信息存放到 session 作用域中，用户后续 使用
        request.getSession().setAttribute(BgmsConfig.SESSION_USER_KEY,userInfo);
        return BaseResult.success();
    }

    @Override
    public void getUserList(HttpServletRequest request) {
        // 搜索框 搜索对应的名字
        String keyword = request.getParameter("keyword");
        request.setAttribute(BgmsConfig.USER_LIST,userInfoDao.getUserAll(keyword));
        request.setAttribute(BgmsConfig.KEYWORD, keyword);
        // 获取数据库中的性别
        request.setAttribute(BgmsConfig.FIRST_USER,userInfoDao.getUSerInfoBySex());
    }

    @Override
    public String getUser(HttpServletRequest request) {
        //获取用户提交过来的 UserId
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (id==null){
            return BaseResult.error(40001,"请求数据异常");
        }
        UserInfo userInfo= userInfoDao.getUserInfoById(id);
        return BaseResult.success(userInfo);
    }

    @Override
    public String addUser(HttpServletRequest request) {
        String accountName = request.getParameter("accountName");
        String passWord = request.getParameter("passWord");
        String nickName = request.getParameter("nickName");
        String tel = request.getParameter("tel");
        String href = request.getParameter("href");
        Integer sex = Integer.parseInt(request.getParameter("sex"));
        String photo = request.getParameter("photo");
        int rows = userInfoDao.saveUser(accountName,passWord,nickName,tel,href,sex,photo);
        if (rows>0){
            return BaseResult.success();
        }
        return BaseResult.error(40003,"新增用户失败");
    }

    @Override
    public String editUser(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String accountName = request.getParameter("accountName");
        String passWord = request.getParameter("passWord");
        String nickName = request.getParameter("nickName");
        String tel = request.getParameter("tel");
        String href = request.getParameter("href");
        Integer sex = Integer.parseInt(request.getParameter("sex"));
        String photo = request.getParameter("photo");
        //TODO 参数校验  如果非空字段为空 给出错误提示
        int rows= userInfoDao.updateUserInfoById(id,accountName,passWord,nickName,tel,href,sex,photo);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(40002,"修改用户失败");
        }
    }

    @Override
    public String batchDeleteUser(HttpServletRequest request) {
        String idStr = request.getParameter("ids");
        String[] ids = idStr.substring(0, idStr.length() - 1).split(",");
        //TODO 判空
        int rows= userInfoDao.batchDeleteUserInfoById(ids);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(40002,"删除用户失败");
        }
    }

    @Override
    public String deleteUser(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        int rows= userInfoDao.deleteUserInfoById(id);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(20002,"删除用户失败");
        }
    }

    @Override
    public String enableUser(HttpServletRequest request) {
        String idsStr = request.getParameter("ids");
        String[] ids = idsStr.substring(0, idsStr.length() - 1).split(",");
        int rows = userInfoDao.batchUpdateUserStatus(ids);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(40004,"启用用户失败");
        }
    }

}