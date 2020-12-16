package com.wbq.servlet.test.validatecode;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet(name = "ValiDateCodeServlet", value = "/validatecode")
public class ValiDateCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidateCode validateCode = new ValidateCode(200, 50, 5, 30);
        HttpSession session = request.getSession();
        Cookie cookie = new Cookie("validatecode", validateCode.getCode());
        response.addCookie(cookie);
        session.setAttribute("validatecode", validateCode.getCode());
        //一定要设置session和cookie之后再回写输出流
        validateCode.write(response.getOutputStream());
        System.out.println(session.getId());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
