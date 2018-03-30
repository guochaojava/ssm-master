package com.lgd.winter.api.bean;

import com.lgd.winter.api.enums.ResponseErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author GuoChao.
 * @since 1.0.0
 */
public class Result {

    private static final Logger LOGGER = LoggerFactory.getLogger(Result.class);

    /**
     * 生成响应成功的(不带正文)的结果
     *
     * @param message 成功提示信息
     * @return ResponseResult
     */
    public static ResponseResult ok(String message) {

        ResponseResult responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(true);
        responseResult.setMessage(message);

        return responseResult;
    }

    /**
     * 生成响应成功(带正文)的结果
     *
     * @param data    结果正文
     * @param message 成功提示信息
     * @return ResponseResult<T>
     */
    public static <T> ResponseResult<T> ok(T data, String message) {

        ResponseResult<T> result = ResponseResult.newInstance();
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(message);

        return result;
    }

    /**
     * 生成响应失败的结果
     *
     * @param message 自定义错误信息
     * @return ResponseResult
     */
    public static ResponseResult error(String message) {

        ResponseResult result = ResponseResult.newInstance();
        result.setSuccess(false);
        result.setMessage(message);

        return result;
    }

    /**
     * 生成响应失败(带code)的结果
     *
     * @param responseErrorEnum 失败信息
     * @return ResponseResult
     */
    public static ResponseResult error(ResponseErrorEnum responseErrorEnum) {

        ResponseResult result = ResponseResult.newInstance();
        result.setSuccess(false);
        result.setErrorInfo(responseErrorEnum);

        return result;
    }
}