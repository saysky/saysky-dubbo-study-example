package com.liuyanzhao.consumer.web.listener;

import com.liuyanzhao.provider.api.service.RoleService;
import com.liuyanzhao.provider.api.service.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 消费者发现服务
 *
 * @author 言曌
 * @date 2021/8/29 1:42 下午
 */

public class DubboConsumerListener implements ServletContextListener {

    /**
     * 项目启动时加载
     *
     * @param sce
     */
    public void contextInitialized(ServletContextEvent sce) {
        // 定义reference
        ReferenceConfig<UserService> userReference = new ReferenceConfig();
        userReference.setInterface(UserService.class);
        userReference.setGroup("provider");

        ReferenceConfig<RoleService> roleReference = new ReferenceConfig();
        roleReference.setInterface(RoleService.class);
        roleReference.setGroup("provider");


        List<ReferenceConfig> references = new ArrayList<ReferenceConfig>();
        references.add(userReference);
        references.add(roleReference);

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        // 设置应用名
        bootstrap.application(new ApplicationConfig("consumer-demo"))
                // 设置注册中心
                .registry(new RegistryConfig("nacos://127.0.0.1:8848"))
                // 设置需要引用的dubbo服务
                .references(references).start();

        System.out.println("========> consumer finish discover services");
    }


    public void contextDestroyed(ServletContextEvent sce) {

    }
}
