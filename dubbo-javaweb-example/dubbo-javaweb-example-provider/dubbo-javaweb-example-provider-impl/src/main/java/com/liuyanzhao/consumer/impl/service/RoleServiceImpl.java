package com.liuyanzhao.consumer.impl.service;

import com.liuyanzhao.consumer.impl.dao.RoleDao;
import com.liuyanzhao.provider.api.entity.Role;
import com.liuyanzhao.provider.api.service.RoleService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 言曌
 * @date 2021/8/29 2:22 下午
 */

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = new RoleDao();

    @Override
    public List<Role> findAll() throws SQLException {
        return roleDao.findAll();
    }
}
