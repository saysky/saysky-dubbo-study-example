package com.liuyanzhao.provider.impl.dao;

import com.liuyanzhao.provider.api.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 言曌
 * @date 2021/8/29 9:28 下午
 */

public interface RoleMapper {

    @Select("SELECT * FROM role")
    List<Role> findAll();

}
