package com.lgd.winter.model;

import lombok.Data;

@Data
public class Menu {
    /**
     * 对应数据库 menu.id
     * 自增主键
     */
    private Integer id;

    /**
     * 对应数据库 menu.pid
     * 父id 默认0
     */
    private Integer pid;

    /**
     * 对应数据库 menu.name
     * 名称
     */
    private String name;

    /**
     * 对应数据库 menu.iconfont
     * 图标
     */
    private String iconfont;

    /**
     * 对应数据库 menu.url
     * url
     */
    private String url;

    /**
     * 对应数据库 menu.level
     * 级别
     */
    private Integer level;

    /**
     * 对应数据库 menu.sort
     * 排序
     */
    private Integer sort;

    /**
     * 对应数据库 menu.status
     * 状态 默认1
     */
    private Integer status;
}