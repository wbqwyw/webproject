package com.wbq.servlet.test.login;

import com.wbq.servlet.test.entity.Manager;
import com.wbq.servlet.test.sevice.ManagerService;
import com.wbq.servlet.test.sevice.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ClassName LoginServlet
 * @Description ��¼servlet
 * @Author wbq
 * @Date 2020/12/13 22:09
 * @Version 1.0
 */
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        String usercode = (String) req.getParameter("usercode");
        String username = (String) req.getParameter("username");
        String validatecode = (String) req.getParameter("validatecode");
        Cookie[] cookies = req.getCookies();
        String cookiecode = null;
        if (cookies != null && cookies.length > 0) {
            for (Cookie co : cookies) {
                if ("validatecode".equals(co.getName())) {
                    cookiecode = co.getValue();
                }
            }
        }
        ManagerService managerService = new ManagerServiceImpl();
        Manager manager = managerService.login(Integer.parseInt(usercode));
        if (manager != null) {
            if (manager.getUsername().equalsIgnoreCase(username) && validatecode.equalsIgnoreCase(cookiecode)) {
                resp.getWriter().println("��¼�ɹ���");
                Cookie cookie = new Cookie("isLogin", manager.getUsername());
                cookie.setMaxAge(60);
                resp.addCookie(cookie);
                session.setAttribute("manager", manager);
            } else if (!validatecode.equalsIgnoreCase(cookiecode)) {
                resp.getWriter().println("��֤�����");
            } else {
                resp.getWriter().println("��¼ʧ�ܣ��û���Ϣ����");
            }
        } else {
            resp.getWriter().println("���û���δע�ᣡ");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
