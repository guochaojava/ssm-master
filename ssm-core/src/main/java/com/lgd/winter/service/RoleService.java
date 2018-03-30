package com.lgd.winter.service;


import com.lgd.winter.model.Role;

public interface RoleService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);
}
