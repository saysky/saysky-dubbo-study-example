package com.liuyanzhao.provider.web.listener;

import com.liuyanzhao.provider.impl.service.RoleServiceImpl;
import com.liuyanzhao.provider.impl.service.UserServiceImpl;
import com.liuyanzhao.provider.api.service.RoleService;
import com.liuyanzhao.provider.api.service.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 言曌
 * @date 2021/8/29 1:42 下午
 */

public class DubboProviderListener implements ServletContextListener {

    /**
     * 项目启动时加载
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 定义服务
        ServiceConfig<UserServiceImpl> userService = new ServiceConfig<UserServiceImpl>();
        userService.setInterface(UserService.class);
        userService.setRef(new UserServiceImpl());
        userService.setGroup("provider");
        userService.setId(UUID.randomUUID().toString());

        ServiceConfig<RoleServiceImpl> roleService = new ServiceConfig<RoleServiceImpl>();
        roleService.setInterface(RoleService.class);
        roleService.setRef(new RoleServiceImpl());
        roleService.setGroup("provider");
        roleService.setId(UUID.randomUUID().toString());


        List<ServiceConfig> services = new ArrayList<ServiceConfig>();
        services.add(roleService);
        services.add(userService);

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        // 设置应用名
        bootstrap.application(new ApplicationConfig("provider-demo"))
                // 设置注册中心
                .registry(new RegistryConfig("nacos://127.0.0.1:8848"))
                // 设置需要注册的服务
                .services(services).start();

        System.out.println("========> provider finish register services");
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
