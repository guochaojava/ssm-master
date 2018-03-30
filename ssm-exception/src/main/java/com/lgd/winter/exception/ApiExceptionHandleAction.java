package com.lgd.winter.exception;

import com.lgd.winter.exception.api.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 接口模块全局异常处理类
 *
 * @author GuoChao.
 * @since 1.0.0
 */
public class ApiExceptionHandleAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandleAction.class);

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> handleAndReturnData(HttpServletRequest request, HttpServletResponse response, Exception ex) {

        Map<String, Object> data = new HashMap<String, Object>();
        if (ex instanceof BusinessException) {
            BusinessException e = (BusinessException) ex;
            data.put("code", e.getCode());
        }
        LOGGER.error("【api】", ex);
        data.put("msg", ex.getMessage());
        data.put("success", false);
        return data;
    }
}