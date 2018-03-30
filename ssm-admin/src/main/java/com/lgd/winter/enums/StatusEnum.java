package com.lgd.winter.enums;

public enum StatusEnum {

    NORMAL(1, "正常"), FORBIDDEN(2, "禁用"),;

    private Integer code;
    private String description;

    StatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
