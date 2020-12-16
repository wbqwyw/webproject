package com.wbq.servlet.test;

import com.wbq.servlet.test.entity.Manager;
import com.wbq.servlet.test.sevice.ManagerService;
import com.wbq.servlet.test.sevice.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet(name = "UpdateManagerServlet", value = "/updateManager")
public class UpdateManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String usercode = request.getParameter("usercode");
        String username = request.getParameter("username");
        Manager manager = new Manager(Integer.parseInt(usercode), username);
        ManagerService managerService = new ManagerServiceImpl();
        managerService.updateManager(manager);
        response.sendRedirect("/qall");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
