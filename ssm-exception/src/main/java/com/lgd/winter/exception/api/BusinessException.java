package com.lgd.winter.exception.api;

import lombok.Data;

/**
 * 接口模块自定义异常
 *
 * @author GuoChao.
 * @since 1.0.0
 */
@Data
public class BusinessException extends RuntimeException {
    private Integer code;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }
}