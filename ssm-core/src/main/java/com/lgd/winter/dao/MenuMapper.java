package com.lgd.winter.dao;


import com.lgd.winter.dto.query.MenuQuery;
import com.lgd.winter.model.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    List<Menu> list(MenuQuery query);

    int deleteByIds(String[] tem);

    int updateStatusByIds(String[] tem);
}