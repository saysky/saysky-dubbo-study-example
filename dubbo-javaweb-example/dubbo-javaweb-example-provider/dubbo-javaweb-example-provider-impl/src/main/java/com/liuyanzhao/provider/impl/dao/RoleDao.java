package com.liuyanzhao.provider.impl.dao;

import com.liuyanzhao.provider.impl.util.DBUtil;
import com.liuyanzhao.provider.api.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 言曌
 * @date 2021/8/29 2:21 下午
 */

public class RoleDao {

    public List<Role> findAll() throws SQLException {
        List<Role> roleList = new ArrayList<Role>();
        DBUtil dbUtil = new DBUtil();
        ResultSet resultSet = dbUtil.query("SELECT * FROM role");
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String code = resultSet.getString("code");
            roleList.add(new Role(id, name, code));
        }
        return roleList;
    }
}
