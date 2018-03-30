package com.lgd.winter.model;

import lombok.Data;

@Data
public class Role {
    /**
     * 对应数据库 role.id
     * 自增主键
     */
    private Integer id;

    /**
     * 对应数据库 role.name
     * 角色名称
     */
    private String name;
}