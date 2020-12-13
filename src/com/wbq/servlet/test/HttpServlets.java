package com.wbq.servlet.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName HttpServlets
 * @Description ¼Ì³ÐHttpServlet
 * @Author wbq
 * @Date 2020/12/12 15:23
 * @Version 1.0
 */
public class HttpServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("GBK");
        resp.getWriter().println("HttpServlet doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("HttpServlet doPost");
    }
}
