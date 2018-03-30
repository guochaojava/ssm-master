package com.lgd.winter.exception.admin;

import lombok.Data;

/**
 * 管理模块自定义异常
 *
 * @author GuoChao.
 * @since 1.0.0
 */
@Data
public class AdminException extends RuntimeException {
    private Integer code;

    public AdminException(String msg) {
        super(msg);
    }

    public AdminException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public AdminException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }
}