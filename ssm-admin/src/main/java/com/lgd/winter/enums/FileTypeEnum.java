package com.lgd.winter.enums;

public enum FileTypeEnum {

    HEAD("head", "头像"), BANNER("banner", "轮播图"), ARTICLE("article", "文章"),COVER("cover","封面"),;

    private String type;
    private String message;

    FileTypeEnum(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
