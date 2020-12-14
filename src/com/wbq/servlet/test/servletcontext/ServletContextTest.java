package com.wbq.servlet.test.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * @description ����servletContext��,servletContext ��ÿ��Ӧ�ö�һ������Ӧ�����ʱ�򴴽����˳���ʱ�����٣�������
 */
@WebServlet(name = "ServletContextTest", value = "/servletcontext")
public class ServletContextTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        servletContext.setAttribute("servletContext", "my create servletContext");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
