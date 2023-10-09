package com.example.bank_mangement_jee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "CLientServlet", value = "/client-create")
@WebServlet(name ="CLientServlet", urlPatterns = {"/client-create", "/client-update","/test"})
public class ClientServlet extends HttpServlet {
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
            case "/client-create" :
                request.getRequestDispatcher("/ClientPages/create.jsp").forward(request, response);
                break;
            case "/client-update" :
                request.getRequestDispatcher("/ClientPages/update.jsp").forward(request, response);
                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String bday = req.getParameter("bday");
        String tele = req.getParameter("tele");
        String adresse = req.getParameter("adresse");

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
