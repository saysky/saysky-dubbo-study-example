package com.liuyanzhao.provider.impl.service;

import com.liuyanzhao.provider.impl.dao.RoleDao;
import com.liuyanzhao.provider.api.entity.Role;
import com.liuyanzhao.provider.api.service.RoleService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author θ¨ζ
 * @date 2021/8/29 2:22 δΈε
 */

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = new RoleDao();

    @Override
    public List<Role> findAll() throws SQLException {
        return roleDao.findAll();
    }
}
