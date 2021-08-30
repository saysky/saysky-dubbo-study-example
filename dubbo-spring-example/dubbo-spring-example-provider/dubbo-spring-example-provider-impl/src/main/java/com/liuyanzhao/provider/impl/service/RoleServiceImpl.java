package com.liuyanzhao.provider.impl.service;

import com.liuyanzhao.provider.api.entity.Role;
import com.liuyanzhao.provider.api.service.RoleService;
import com.liuyanzhao.provider.impl.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 言曌
 * @date 2021/8/29 9:48 下午
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> findAll() throws SQLException {
        return roleMapper.findAll();
    }
}
