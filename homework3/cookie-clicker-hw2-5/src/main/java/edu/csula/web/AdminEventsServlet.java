package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

@WebServlet("/admin/events")
public class AdminEventsServlet extends HttpServlet {

    public void init(){
        ArrayList<Event> entries = new ArrayList<>();
        entries.add(new Event(entries.size(), "nuggets are coming", "get ready" ,5));
        entries.add(new Event(entries.size(), "Soo much chicken", "MCNUGGETTSSS" ,10));
        entries.add(new Event(entries.size(), "congrats", "YOU ARE SO RICH" ,15));
        getServletContext().setAttribute("event-entries", entries);
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // TODO: render the events page HTML
        EventsDAO dao = new EventsDAOImpl(getServletContext());
        List<Event> entries = dao.getAll();

        ArrayList<Event> list = (ArrayList<Event>) getServletContext().getAttribute("event-entries");
        request.setAttribute("event-entries", entries);

        request.getRequestDispatcher("/WEB-INF/admin-events.jsp").forward(request, response);


    }


    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: handle upsert transaction

        EventsDAO entry = new EventsDAOImpl(getServletContext());
        List<Event> entries = entry.getAll();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String triggerAt = request.getParameter("triggerAt");
        Event event = new Event(entries.size(), name, description, Integer.parseInt(triggerAt));
        entry.add(event);

        response.sendRedirect("events");



    }
}