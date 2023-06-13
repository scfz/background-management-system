package com.hzlx.filter;

import com.hzlx.component.BgmsConfig;
import com.hzlx.entity.UserInfo;
import com.hzlx.utils.PropertiesUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @param
 * @return
 */
@WebFilter(urlPatterns = {"/api/*"})
public class Filter_A_CheckSession implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将 servletRequest 转为 HttpServletRequest对象，方便获取session对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (filterRequests(request)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            UserInfo userInfo = (UserInfo) request.getSession().getAttribute(BgmsConfig.SESSION_USER_KEY);
            if (userInfo==null){
                //用户没有登录，重定向到登录页
                response.sendRedirect("/bgms/");
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    private boolean filterRequests(HttpServletRequest request) {
        PropertiesUtil.load("config");
        String excludeUrls = PropertiesUtil.getValue("exclude.urls");
        String[] urls = excludeUrls.split(",");

        for (String url : urls) {
            if (request.getRequestURI().equals(request.getContextPath()+url)) {
                return true;
            }
        }
        return false;
    }
}
