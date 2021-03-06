package com.liuyanzhao.provider.impl.dao;

import com.liuyanzhao.provider.api.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author θ¨ζ
 * @date 2021/8/29 9:24 δΈε
 */
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(@Param("id") Integer id);
}
