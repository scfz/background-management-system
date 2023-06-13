package com.hzlx.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @param
 * @return
 */
public interface EasyCaptchaService {
    /**
     * 获取验证码
     * @param request
     * @param response
     */
    void captcha(HttpServletRequest request, HttpServletResponse response);

    /**
     * 校验验证码
     * @param request
     * @return
     */
    String check(HttpServletRequest request);
}
