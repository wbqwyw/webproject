package com.wbq.servlet.test.showpage;

import com.wbq.servlet.test.entity.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author wbq
 */
@WebServlet(name = "ShowPageServlet", value = "/showpage")
public class ShowPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        List<Manager> all = (List<Manager>) session.getAttribute("all");
        PrintWriter writer = response.getWriter();
        writer.println("<html lang=\"en\">");
        writer.println("<head>\n" +
                "    <meta charset=\"GBK\">\n" +
                "    <title>管理员信息</title>\n" +
                "</head>");
        writer.println("<body>");
        writer.println("<table border=\"1px solid #f0f;\" cellspacing=\"0\">\n" +
                "    <tr>\n" +
                "        <th>用户编码</th>\n" +
                "        <th>用户名称</th>\n" +
                "    </tr>");

        if (all != null && all.size() > 0) {
            for (Manager vo : all) {
                writer.println("<tr>\n" +
                        "    <td>" + vo.getUsercode() + "</td>\n" +
                        "    <td>" + vo.getUsername() + "</td>\n" +
                        "</tr>");
            }
        }
        writer.println("</table>" +
                "   </body>");
        writer.println("</body>\n" +
                "</html>");
        response.flushBuffer();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
