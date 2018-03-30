package com.lgd.winter.dao;


import com.lgd.winter.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);
}