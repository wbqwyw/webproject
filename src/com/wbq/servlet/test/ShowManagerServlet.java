package com.wbq.servlet.test;

import com.wbq.servlet.test.entity.Manager;
import com.wbq.servlet.test.sevice.ManagerService;
import com.wbq.servlet.test.sevice.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet(name = "ShowManagerServlet", value = "/showManager")
public class ShowManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usercode = request.getParameter("usercode");
        HttpSession session = request.getSession();
        if (usercode == null) {
            response.getWriter().println("该用户不存在！");
        } else {
            ManagerService managerService = new ManagerServiceImpl();
            Manager manager = managerService.queryManager(Integer.parseInt(usercode));
            session.setAttribute("manager", manager);
            request.getRequestDispatcher("/managerCard.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
