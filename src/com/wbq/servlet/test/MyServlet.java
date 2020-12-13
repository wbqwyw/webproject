package com.wbq.servlet.test;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName MyServlet
 * @Description ʵ��Servlet�ӿ�
 * @Author wbq
 * @Date 2020/12/12 14:31
 * @Version 1.0
 */
public class MyServlet implements Servlet {
    static {
        System.out.println("MyServlet �����......");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("MyServlet ��ʼ��ʼ��......");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter writer = servletResponse.getWriter();
        writer.println("MY FIRST SERVLET");
        servletResponse.flushBuffer();
        System.out.println("MY FIRST SERVLET......");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("MyServlet Ӧ���˳�����......");
    }
}
