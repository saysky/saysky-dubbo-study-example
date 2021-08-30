package com.liuyanzhao.provider.web.controller;

import com.liuyanzhao.provider.api.entity.Role;
import com.liuyanzhao.provider.api.entity.User;
import com.liuyanzhao.provider.api.service.RoleService;
import com.liuyanzhao.provider.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 言曌
 * @date 2021/8/29 10:02 下午
 */
@Controller
public class ProviderController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 测试db
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String index() throws Exception {
        List<User> userList = userService.findAll();
        List<Role> roleList = roleService.findAll();
        System.out.println(userList);
        System.out.println(roleList);
        return "生产者启动成功！";
    }
}
