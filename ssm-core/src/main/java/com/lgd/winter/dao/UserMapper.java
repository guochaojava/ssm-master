package com.lgd.winter.dao;


import com.lgd.winter.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    User loginCheck(User user);
}