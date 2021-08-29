package com.liuyanzhao.consumer.impl.service;

import com.liuyanzhao.consumer.impl.dao.UserDao;
import com.liuyanzhao.provider.api.entity.User;
import com.liuyanzhao.provider.api.service.UserService;

import java.util.List;

/**
 * 用户服务实现
 *
 * @author 言曌
 * @date 2021/8/29 11:43 上午
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    @Override
    public List<User> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) throws Exception {
        return userDao.findById(id);
    }
}
