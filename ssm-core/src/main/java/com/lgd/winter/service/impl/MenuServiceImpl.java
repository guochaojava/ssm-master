package com.lgd.winter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgd.winter.dao.MenuMapper;
import com.lgd.winter.dto.query.MenuQuery;
import com.lgd.winter.model.Menu;
import com.lgd.winter.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单相关实现类
 *
 * @author GuoChao.
 * @since 1.0.0
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper dao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Menu record) {
        return dao.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Menu> menuList(MenuQuery query) {
        return dao.list(query);
    }

    @Override
    public PageInfo<Menu> list(MenuQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Menu> list = dao.list(query);
        PageInfo<Menu> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteByIds(String id) {
        String[] tem = id.split(",");
        return dao.deleteByIds(tem);
    }

    @Override
    public int updateStatusByIds(String id) {
        String[] tem = id.split(",");
        return dao.updateStatusByIds(tem);
    }
}