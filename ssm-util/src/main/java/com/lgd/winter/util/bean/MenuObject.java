package com.lgd.winter.util.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单对象
 * @author guochao
 * @since 1.0.0
 */
@Data
public class MenuObject {

    private Integer id;

    private String url;

    private String name;

    private String iconfont;

    private Integer pid;

    private List<MenuObject> sub = new ArrayList<MenuObject>();
}
