package com.liuyanzhao.provider.api.entity;

import java.io.Serializable;

/**
 * 角色实体类，用于演示
 * @author 言曌
 * @date 2021/8/29 2:19 下午
 */

public class Role implements Serializable {

    private Integer id;
    private String name;
    private String code;

    public Role() {
    }

    public Role(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
