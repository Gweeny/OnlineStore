package com.mycompany.backend.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String message = "Online Store, votre boutique en ligne ";

        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        out.println(("<a href=\"catalogue\">Catalogue des oeuvres</a>"));
        out.println("</body></html>");

    }


}
