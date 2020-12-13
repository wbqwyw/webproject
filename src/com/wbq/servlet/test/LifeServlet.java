package com.wbq.servlet.test;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @ClassName LifeServlet
 * @Description servlet生命周期测试
 * @Author wbq
 * @Date 2020/12/13 19:31
 * @Version 1.0
 */
public class LifeServlet  implements Servlet {

    static {
        System.out.println("lifeServlet 类加载......");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("lifeServlet 开始初始化......");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=utf-8");
        servletResponse.getWriter().println("lifeservlet 开始服务了.....");
        System.out.println("lifeservlet 开始服务了.....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("lifeServlet 应用退出销毁......");
    }
}
