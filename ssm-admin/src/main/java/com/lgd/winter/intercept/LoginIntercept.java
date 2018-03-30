package com.lgd.winter.intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author guochao
 * @since 1.0.0
 */
public class LoginIntercept implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        Cookie[] cookies = request.getCookies();
        try {
            //redis 获取登录信息
            String result = redisTemplate.opsForValue().get("admin:login");
            if (result == null) {
                request.getRequestDispatcher("/check").forward(request, response);
                return false;
            }

            //cookie获取登录信息
            for (Cookie cookie : cookies) {
                if ("login".equals(cookie.getName()) && cookie.getValue() != null && cookie.getValue() != "") {
                    request.setAttribute("userId", cookie.getValue());
                    return true;
                }
            }
            // 不符合条件的，跳转到登录界面
            request.getRequestDispatcher("/check").forward(request, response);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/check").forward(request, response);
            return false;
        }
    }
}
