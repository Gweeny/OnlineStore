package com.mycompany.onlinestore.frontend.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = "/somme")
public class SommeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String nombre1 =req.getParameter("nombre1");
        String nombre2 = req.getParameter("nombre2");


        int somme = Integer.parseInt(nombre1) + Integer.parseInt(nombre2);

        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h1>" + "La somme des 2 nombres est :" + somme + "</h1>");
        out.println("</body></html>");
    }
}
