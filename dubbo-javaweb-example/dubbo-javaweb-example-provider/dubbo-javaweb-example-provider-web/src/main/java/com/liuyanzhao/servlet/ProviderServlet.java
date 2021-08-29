package com.liuyanzhao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 言曌
 * @date 2021/8/29 11:55 上午
 */

public class ProviderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = "生产者服务已经启动成功，快来消费吧！QAQ";
        resp.setContentType("application/json;charset=UTF-8");
        content = "dubbo-javaweb-example-provider-web:\n" + content;
        resp.getWriter().write(content);
    }
}
