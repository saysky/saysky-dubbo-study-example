package com.liuyanzhao.provider.impl.dao;

import com.liuyanzhao.provider.api.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author θ¨ζ
 * @date 2021/8/29 9:28 δΈε
 */

public interface RoleMapper {

    @Select("SELECT * FROM role")
    List<Role> findAll();

}
