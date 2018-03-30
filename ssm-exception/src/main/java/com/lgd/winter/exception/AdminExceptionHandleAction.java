package com.lgd.winter.exception;

import com.lgd.winter.exception.admin.AdminException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理模块全局异常处理类
 *
 * @author GuoChao.
 * @since 1.0.0
 */
public class AdminExceptionHandleAction implements HandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminExceptionHandleAction.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        LOGGER.error("【admin】", ex);

        //向前台返回错误信息
        ModelAndView modelAndView = new ModelAndView();

        //如果抛出的是系统自定义的异常则直接转换
        if (ex instanceof AdminException) {
            AdminException adminException = (AdminException) ex;
            modelAndView.addObject("message", adminException.getMessage());
        } else {
            modelAndView.addObject("message", "未知错误,请查看日志");
        }
        modelAndView.setViewName("error");

        return modelAndView;
    }
}