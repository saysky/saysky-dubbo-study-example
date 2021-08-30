package com.liuyanzhao.provider.impl.service;

import com.liuyanzhao.provider.api.entity.User;
import com.liuyanzhao.provider.api.service.UserService;
import com.liuyanzhao.provider.impl.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 言曌
 * @date 2021/8/29 9:48 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() throws Exception {
        return userMapper.findAll();
    }

    @Override
    public User findById(Integer id) throws Exception {
        return userMapper.findById(id);
    }
}
