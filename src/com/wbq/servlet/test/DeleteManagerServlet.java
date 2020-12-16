package com.wbq.servlet.test;

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
@WebServlet(name = "DeleteManagerServlet", value = "/deleteManager")
public class DeleteManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usercode = request.getParameter("usercode");
        ManagerService managerService = new ManagerServiceImpl();
        if (usercode == null) {
            response.getWriter().println("该用户不存在！");
        } else {
            managerService.deleteManager(Integer.parseInt(usercode));
            response.sendRedirect("/qall");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
