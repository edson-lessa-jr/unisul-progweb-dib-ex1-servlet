package br.unisul.aula;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormularioServlet", value = "/form")
public class FormularioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            if (session.getAttribute("teste")!=null) {
                if (session.getAttribute("teste")=="logado"){
                    PrintWriter out = response.getWriter();
                    out.println("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Title</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "<h1>Página inicial</h1>\n" +
                            "<form action=\"form\" method=\"post\">\n" +
                            "    Nome: <input type=\"text\" name=\"txtNome\" id=\"nome\"><br>\n" +
                            "    Idade: <input type=\"number\" name=\"nrIdade\" id=\"idade\"><br>\n" +
                            "    <hr>\n" +
                            "    <input type=\"submit\" value=\"Enviar\"><br>\n" +
                            "    <input type=\"reset\" value=\"Limpar\">\n" +
                            "</form>\n" +
                            "</body>\n" +
                            "</html>");
                } else {
                    response.getWriter().println("Não está logado");
                }

            }else {
                response.getWriter().println("Não está logado");
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String nome = request.getParameter("txtNome");
            int idade = Integer.parseInt(request.getParameter("nrIdade"));

            response.getWriter().println("Nome: "+nome);
            response.getWriter().println("Idade: "+idade);
    }
}
