package com.example.bank_mangement_jee;

import DAO.ImpClient;
import DTO.Client;
import Services.ClientService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//@WebServlet(name = "CLientServlet", value = "/client-create")
@WebServlet(name ="CLientServlet", urlPatterns = {"/client-create", "/client-update","/client-display"})
public class ClientServlet extends HttpServlet {
    String requestURL;
    ClientService service;
    @Override
    public void init() throws ServletException {
        service= new ClientService(new ImpClient());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.requestURL=request.getServletPath();
        switch (this.requestURL){
            case "/client-display" :
                request.setAttribute("clients",service.getAll());
                request.getRequestDispatcher("/ClientPages/display.jsp").forward(request, response);
                break;
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
        String code;
        String fname;
        String lname;
        String bday;
        String tele;
        String adresse;
        LocalDate localDate=null;
        DateTimeFormatter formatter=null;
        Client cl;
        switch (this.requestURL){
            case "/client-create" :
                code = req.getParameter("code");
                fname = req.getParameter("fname");
                lname = req.getParameter("lname");
                bday = req.getParameter("bday");
                tele = req.getParameter("tele");
                adresse = req.getParameter("adresse");
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                localDate = LocalDate.parse(bday, formatter);
                cl= new Client(code,fname,lname,localDate,tele,adresse);
                boolean added=this.service.add(cl);
                if(added){
                    req.getRequestDispatcher("/ClientPages/create.jsp").forward(req, resp);
                }
                break;
            case "/client-update" :
                code = req.getParameter("code");
                fname = req.getParameter("fname");
                lname = req.getParameter("lname");
                bday = req.getParameter("bday");
                tele = req.getParameter("tele");
                adresse = req.getParameter("adresse");
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                localDate = LocalDate.parse(bday, formatter);
                cl= new Client(code,fname,lname,localDate,tele,adresse);
                boolean updated=this.service.update(cl);
                if(updated){
                    req.getRequestDispatcher("/ClientPages/update.jsp").forward(req, resp);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}