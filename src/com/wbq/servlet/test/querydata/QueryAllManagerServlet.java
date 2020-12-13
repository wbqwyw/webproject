package com.wbq.servlet.test.querydata;

import com.wbq.servlet.test.dao.impl.ManagerDaoImpl;
import com.wbq.servlet.test.entity.Manager;
import com.wbq.servlet.test.sevice.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * @author wbq
 */
@WebServlet(name = "QueryAllManagerServlet", value = "/qall")
public class QueryAllManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        Manager manager1 = (Manager) session.getAttribute("manager");
        Manager manager = (Manager) manager1;
        if (manager != null) {
            if (manager.getUsername().equalsIgnoreCase(manager1.getUsername())) {
                List<Manager> managers = new ManagerDaoImpl().queryAllManager();
                session.setAttribute("all", managers);
                request.getRequestDispatcher("/showpage").forward(request, response);
            }
        } else {
            response.sendRedirect("/login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
