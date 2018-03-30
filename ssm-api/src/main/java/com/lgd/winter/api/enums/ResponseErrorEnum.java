package com.lgd.winter.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应错误枚举类
 *
 * @author guochao
 * @since 1.0.0
 */
public enum ResponseErrorEnum {
    ERROR_PARAM(202, "参数错误"),
    ERROR_INTERNAL(500, "内部错误");

    private ResponseErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @JsonValue
    private Map<String, Object> serialize() {
        Map<String, Object> valueMap = new HashMap<>(2);
        valueMap.put("code", this.code);
        valueMap.put("message", this.message);
        return valueMap;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
