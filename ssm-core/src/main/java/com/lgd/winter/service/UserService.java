package com.lgd.winter.service;


import com.lgd.winter.model.User;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    User loginCheck(User user);
}
