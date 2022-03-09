package com.mycompany.onlinestore.frontend.controller;

import com.mycompany.backend.entity.Catalogue;
import com.mycompany.backend.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "worksDetailsServlet", urlPatterns = "/work-details")
public class WorksDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Long id = Long.parseLong(req.getParameter("id"));

        Work work = null;

        for (Work work1 : Catalogue.listOfWorks) {
            if (id == work1.getId()){
                work = work1;
                break;
            }
        }

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> Description de l'oeuvre</h1>");
        out.println("Titre : " + work.getTitle() + "<br/>");
        out.println("Date de sortie : " + work.getRelease() + "<br/>");
        out.println("genre : "+ work.getGenre() + "<br/>");
        out.println("Artiste principal : " + work.getMainArtist().getName() + "<br/>");
        out.println("Résumé : " + work.getSummary() + "<br/>");
        out.println("</body></html>");

    }

}
