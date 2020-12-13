package com.wbq.servlet.test;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @ClassName GenricServlet
 * @Description ¼Ì³ÐGenericServlet
 * @Author wbq
 * @Date 2020/12/12 15:22
 * @Version 1.0
 */
public class GenricServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setCharacterEncoding("GBK");
        servletResponse.getWriter().println("¼Ì³ÐGenericServlet");
    }
}
