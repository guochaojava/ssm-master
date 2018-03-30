package com.lgd.winter.dto.query;

import lombok.Data;

@Data
public class MenuQuery extends BaseQuery {
    private String name;
    private Integer status;
    private Integer userId;
}