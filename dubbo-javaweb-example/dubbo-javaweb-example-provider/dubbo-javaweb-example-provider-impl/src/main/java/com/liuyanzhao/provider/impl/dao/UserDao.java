package com.liuyanzhao.provider.impl.dao;

import com.liuyanzhao.provider.impl.util.DBUtil;
import com.liuyanzhao.provider.api.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户数据访问层，模拟从数据库取数据
 *
 * @author 言曌
 * @date 2021/8/29 11:26 上午
 */

public class UserDao {

    /**
     * 获取所有用户
     *
     * @return
     */
    public List<User> findAll() throws SQLException {
        List<User> userList = new ArrayList<User>();
        DBUtil dbUtil = new DBUtil();
        ResultSet resultSet = dbUtil.query("SELECT * FROM user");
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            userList.add(new User(id, name, sex));
        }
        return userList;
    }

    /**
     * 根据用户id查询用户
     *
     * @return
     */
    public User findById(Integer id) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        ResultSet resultSet = dbUtil.query("SELECT * FROM user where id = " + id);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            return new User(id, name, sex);
        }
        return null;
    }


}
