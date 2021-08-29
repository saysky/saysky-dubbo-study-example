package com.liuyanzhao.provider.impl.util;

import java.sql.*;

/**
 * 数据库查询工具类 for MySQL
 *
 * @author 言曌
 * @date 2021/8/29 11:34 上午
 */
public class DBUtil {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/dubbo_study_example?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASSWWORD = "123456";


    /**
     * 获得数据库连接
     *
     * @return
     */
    private boolean getConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWWORD);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 执行SQL
     *
     * @param sql
     * @return
     */
    public ResultSet query(String sql) {
        if (getConnection()) {
            try {
                stmt = (Statement) conn.createStatement();
                rs = stmt.executeQuery(sql);
                return rs;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 执行更新SQL
     *
     * @param sql
     * @return
     */
    public int update(String sql) {
        if (getConnection()) {
            try {
                stmt = conn.createStatement();
                int flag = stmt.executeUpdate(sql);
                return flag;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } else {
            return -1;
        }
    }

    /**
     * 关闭连接
     *
     * @return
     */
    public boolean closeAll() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
