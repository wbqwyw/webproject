package com.wbq.servlet.test.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Administrator
 * @Description 浏览器禁用cookie时，不能从cookie中的JSESSIONID获取sessionID，此时可以通过此方式通过
 * 生成新的URL重定向到请求的地址，新的URL会携带sessionID
 */
@WebServlet(name = "UnableCookieServlet", value = "/uncookie")
public class UnableCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        String newUrl = response.encodeRedirectURL("/validatecode");
        response.sendRedirect(newUrl);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
