package com.lgd.winter.dto.query;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseQuery implements Serializable {

    private Integer pageNum = 1; // 页码
    private Integer pageSize = 999999999;// 每页显示数量
}
