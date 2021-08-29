package com.liuyanzhao.provider.api.service;

import com.liuyanzhao.provider.api.entity.Role;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 言曌
 * @date 2021/8/29 2:20 下午
 */

public interface RoleService {

    /**
     * 查询所有角色
     *
     * @return
     */
    List<Role> findAll() throws SQLException;
}
