package com.wbq.servlet.test.filter;

import com.wbq.servlet.test.entity.Manager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName MyFilter
 * @Description À¹½ØÆ÷²âÊÔÀà
 * @Author Administrator
 * @Date 2020/12/14 14:53
 * @Version 1.0
 */
public class MyFilter implements Filter {

    static {
        System.out.println("MyFilterÀ¹½ØÆ÷Àà¼ÓÔØ.....");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilterÀ¹½ØÆ÷³õÊ¼»¯.....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilterÀ¹½ØÆ÷¿ªÊ¼¹¤×÷.....");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("manager");
        String servletPath = request.getServletPath();

        Set<String> incloudes = new HashSet<>();
        incloudes.add(request.getContextPath() + "/login.html");
        incloudes.add(request.getContextPath() + "/login");
        if (manager != null || incloudes.contains(servletPath)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
    }

    @Override
    public void destroy() {
        System.out.println("MyFilterÀ¹½ØÆ÷Ïú»Ù.....");
    }
}
