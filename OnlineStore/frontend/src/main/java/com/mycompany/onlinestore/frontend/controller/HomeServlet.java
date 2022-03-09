package com.mycompany.onlinestore.frontend.controller;

import com.mycompany.backend.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HelloServlet", urlPatterns = ("/hello"))
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person durand = new Person("David", "Dupond");

        PrintWriter out = resp.getWriter(); // ouverture flux en écriture

        String message = "Hello " + durand.getFirstname() + " " + durand.getLastname();

        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
}
