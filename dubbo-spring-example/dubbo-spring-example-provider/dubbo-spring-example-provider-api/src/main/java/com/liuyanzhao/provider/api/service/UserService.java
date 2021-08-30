package com.liuyanzhao.provider.api.service;

import com.liuyanzhao.provider.api.entity.User;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author 言曌
 * @date 2021/8/29 11:24 上午
 */

public interface UserService {

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll() throws Exception;

    /**
     * 根据id查询
     *
     * @return
     */
    User findById(Integer id) throws Exception;
}
