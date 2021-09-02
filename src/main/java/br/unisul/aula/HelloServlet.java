package br.unisul.aula;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", value = "/HelloServlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("teste", "logado");
        out.println("<html>");
        out.println("<body>");
        out.println("Agora em html");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hello Post");
    }
}
