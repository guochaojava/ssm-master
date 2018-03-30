package com.lgd.winter.api.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgd.winter.api.enums.ResponseErrorEnum;
import lombok.Data;

/**
 * @author GuoChao.
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class ResponseResult<T> {
    private boolean success;

    private String message;

    private T data;

    private Integer code;

    private ResponseResult() {
    }

    public static <T> ResponseResult<T> newInstance() {
        return new ResponseResult<>();
    }

    public boolean isSuccess() {
        return success;
    }

    // 设置错误信息
    public void setErrorInfo(ResponseErrorEnum responseErrorEnum) {
        this.code = responseErrorEnum.getCode();
        this.message = responseErrorEnum.getMessage();
    }
}