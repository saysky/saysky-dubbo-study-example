package com.liuyanzhao.servlet;

import com.alibaba.fastjson.JSON;
import com.liuyanzhao.provider.api.entity.Role;
import com.liuyanzhao.provider.api.entity.User;
import com.liuyanzhao.provider.api.service.RoleService;
import com.liuyanzhao.provider.api.service.UserService;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.ReferenceConfigBase;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.utils.ReferenceConfigCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ConsumerServlet
 *
 * @author 言曌
 * @date 2021/8/29 11:06 上午
 */
public class ConsumerServlet extends HttpServlet {


    /**
     * 响应一句话
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder content = new StringBuilder("dubbo-javaweb-example-consumer:\n");
        resp.setContentType("application/json;charset=UTF-8");


        // 调用 UserService
        try {
            ReferenceConfig<UserService> userReference = new ReferenceConfig();
            userReference.setInterface(UserService.class);
            userReference.setGroup("provider");
            UserService userService = ReferenceConfigCache.getCache().get(userReference);
            List<User> userList = userService.findAll();
            content.append(JSON.toJSONString(userList)).append("\n");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("userService连接失败\n" + e.getMessage() + "\n");
        }

        // 调用 RoleService
        try {

            ReferenceConfig<RoleService> roleReference = new ReferenceConfig();
            roleReference.setInterface(RoleService.class);
            roleReference.setGroup("provider");

            RoleService roleService = ReferenceConfigCache.getCache().get(roleReference);
            List<Role> roleList = roleService.findAll();
            content.append(JSON.toJSONString(roleList)).append("\n");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("roleService连接失败\n" + e.getMessage() + "\n");
        }


        resp.getWriter().write(content.toString());
    }


}
