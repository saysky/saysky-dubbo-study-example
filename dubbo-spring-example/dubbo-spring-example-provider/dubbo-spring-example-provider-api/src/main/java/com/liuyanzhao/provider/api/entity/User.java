package com.liuyanzhao.provider.api.entity;

import java.io.Serializable;

/**
 * 用户实体类，用于演示
 * @author 言曌
 * @date 2021/8/29 11:23 上午
 */
public class User implements Serializable {

    private Integer id;
    private String name;
    private String sex;

    public User() {
    }

    public User(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
