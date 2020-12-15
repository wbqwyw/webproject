package com.wbq.servlet.test.querydata;

import com.wbq.servlet.test.dao.impl.ManagerDaoImpl;
import com.wbq.servlet.test.entity.Manager;
import com.wbq.servlet.test.entity.Page;
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
        String pageIndex = request.getParameter("pageIndex");
        int index = pageIndex == null ? 1 : Integer.parseInt(pageIndex);
        session.setAttribute("pageIndex", index);
        Page page = new Page(index);
        Manager manager = (Manager) manager1;
        if (manager != null) {
            if (manager.getUsername().equalsIgnoreCase(manager1.getUsername())) {
                List<Manager> managers = new ManagerDaoImpl().queryAllManager(page);
                int totlePage = (int) new ManagerDaoImpl().selectRowCount();
                page.setPageRows(totlePage);
                session.setAttribute("all", managers);
                session.setAttribute("totlePage", page.getTotlePage());
                request.getRequestDispatcher("/showpage.jsp").forward(request, response);
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
