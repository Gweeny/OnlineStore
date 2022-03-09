package com.mycompany.onlinestore.frontend.controller;

import com.mycompany.backend.entity.Artist;
import com.mycompany.backend.entity.Catalogue;
import com.mycompany.backend.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "CatalogueServlet", urlPatterns = "/catalogue")
public class CatalogueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if (Catalogue.listOfWorks.isEmpty()) {
            Artist tomCruise = new Artist("Tom Cruise");
            Artist tillLindeman = new Artist("Till Lindeman");
            Artist louisDeFunes = new Artist("Louis de Funes");

            Work minorityReport = new Work("Minority Report");
            Work deutschland = new Work("Deutschland");
            Work laSoupeAuxChoux = new Work("La soupe aux choux");

        minorityReport.setId(1);
        deutschland.setId(2);
        laSoupeAuxChoux.setId(3);

            minorityReport.setMainArtist(tomCruise);
            deutschland.setMainArtist(tillLindeman);
            laSoupeAuxChoux.setMainArtist(louisDeFunes);

            minorityReport.setRelease(2002);
            deutschland.setRelease(2020);
            laSoupeAuxChoux.setRelease(1964);

            minorityReport.setSummary("Le film place le spectateur dans un futur proche cyberpunk," +
                    " une dystopie dont le cadre se situe en 2054 à Washington D.C (États-Unis), où " +
                    "trois êtres humains mutants, les précogs, peuvent prédire les crimes à venir grâce" +
                    " à leur don de précognition. Grâce à ces visions du futur, la ville a réussi à éradiquer" +
                    " la criminalité et les agents de l'organisation gouvernementale Précrime peuvent " +
                    "arrêter les criminels juste avant qu’ils ne commettent leurs méfaits. Mais un jour, " +
                    "le chef de l'unité John Anderton reçoit des précogs une vision le concernant : " +
                    "dans moins de 36 heures, il aura assassiné un homme qu’il ne connaît pas encore et " +
                    "pour une raison qu’il ignore. Choqué, il prend la fuite, poursuivi par ses coéquipiers " +
                    "qui ont pour mission de l’arrêter conformément au système. ");
            deutschland.setSummary("Deutschland est un single du groupe de metal industriel allemand Rammstein" +
                    " tiré de leur septième album, Rammstein. Il sort le 29 mars 2019.\n" +
                    "\n" +
                    "Sur la pochette du single figure Germania, allégorie de la Germanie et de l'Allemagne." +
                    "Deutschland et son clip de neuf minutes revisitent les dérives de l'Allemagne depuis ses origines," +
                    " à travers plusieurs événements forts : après la défaite romaine en Germania magna, en passant" +
                    " par les chevaliers médiévaux, la chasse aux sorcières, la révolution de novembre 1918," +
                    " l'hyperinflation de la république de Weimar, les autodafés de 1933, l'incendie du dirigeable" +
                    " Hindenburg, la Seconde Guerre mondiale, la Shoah, l'histoire de la République démocratique" +
                    " allemande, la bande à Baader2, jusqu'aux manifestations du Premier mai à Berlin-Kreuzberg." +
                    " En fin de compte, l'issue de toutes ces différentes périodes est toujours la violence, " +
                    "le fil rouge de l'histoire allemande à travers les siècles. Les membres du groupe endossent" +
                    " à chaque fois des rôles différents au cours des différentes époques. ");
            laSoupeAuxChoux.setSummary("Comédie mêlée de science-fiction, adaptation du roman du même nom de René Fallet paru en 1980, le film rassemble les acteurs Louis de Funès (dont c'est l'avant-dernier film), Jean Carmet et Jacques Villeret.\n" +
                    "\n" +
                    "À sa sortie, le film est un succès commercial modéré — en comparaison des habituels" +
                    " succès de Louis de Funès — et reçoit des critiques majoritairement négatives" +
                    " de la part des professionnels. Cependant, il est considéré comme un film culte" +
                    " par le public et réalise toujours de bonnes audiences à la télévision. ");

            minorityReport.setGenre("Science fiction");
            deutschland.setGenre("Métal");
            laSoupeAuxChoux.setGenre("Comédie");

            Catalogue.listOfWorks.add(minorityReport);
            Catalogue.listOfWorks.add(deutschland);
            Catalogue.listOfWorks.add(laSoupeAuxChoux);

        }


        out.println("<html><body>");
        out.println("<h1> Oeuvres au catalogue </h1>");

        for (Work work : Catalogue.listOfWorks) {
            out.println("<a href=\"work-details?id=" + work.getId() + "\">" + work.getTitle() + " (" + work.getRelease() + ")</a><BR/>");
        }


        out.println("</body></html>");


    }
}
