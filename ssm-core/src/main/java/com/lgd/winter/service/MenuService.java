package com.lgd.winter.service;

import com.github.pagehelper.PageInfo;
import com.lgd.winter.dto.query.MenuQuery;
import com.lgd.winter.model.Menu;

import java.util.List;

public interface MenuService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    List<Menu> menuList(MenuQuery query);

    PageInfo<Menu> list(MenuQuery query);

    int deleteByIds(String id);

    int updateStatusByIds(String id);
}
