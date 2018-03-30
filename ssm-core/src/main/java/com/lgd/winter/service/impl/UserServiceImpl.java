package com.lgd.winter.service.impl;

import com.lgd.winter.dao.UserMapper;
import com.lgd.winter.model.User;
import com.lgd.winter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户相关实现
 *
 * @author GuoChao.
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper dao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(User record) {
        return dao.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public User loginCheck(User user) {
        return dao.loginCheck(user);
    }
}