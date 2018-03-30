package com.lgd.winter.service.impl;

import com.lgd.winter.dao.RoleMapper;
import com.lgd.winter.model.Role;
import com.lgd.winter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色相关实现类
 *
 * @author GuoChao.
 * @since 1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper dao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Role record) {
        return dao.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return dao.updateByPrimaryKeySelective(record);
    }
}