package com.example.bank_mangement_jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/employe-create", "/employe-update"})
public class EmployeServlet extends HttpServlet {
    String requestURL;
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.requestURL=request.getServletPath();
        /*resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>"+ this.requestURL +"</h1>");
        out.println("</body></html>");*/
        switch (this.requestURL){
            case "/employe-create" :
                request.getRequestDispatcher("/EmployePages/create.jsp").forward(request, response);
                break;
            case "/employe-update" :
                request.getRequestDispatcher("/EmployePages/update.jsp").forward(request, response);
                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
