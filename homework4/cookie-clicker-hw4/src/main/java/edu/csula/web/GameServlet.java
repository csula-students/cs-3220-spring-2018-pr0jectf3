package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;
import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;


@WebServlet("/game")
public class GameServlet extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GeneratorsDAO genDao = new GeneratorsDAOImpl(getServletContext());
        List<Generator> gens = genDao.getAll();
        EventsDAO eventsDao = new EventsDAOImpl(getServletContext());
        List<Event> events = eventsDao.getAll();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String generator = gson.toJson(gens);
        String stories = gson.toJson(events);
        request.setAttribute("generator", generator);
        request.setAttribute("stories", stories);
        request.getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
    }
}
