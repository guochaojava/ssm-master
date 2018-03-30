package com.lgd.winter.enums;

public enum CodeMessageEnum {
	
	OK(200, "OK"), ERROR(500, "ERROR"),;
	
	private Integer code;
	private String message;

	CodeMessageEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
