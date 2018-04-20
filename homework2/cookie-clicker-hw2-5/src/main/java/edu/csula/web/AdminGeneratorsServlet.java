package edu.csula.web;

import edu.csula.models.Generator;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.storage.servlet.GeneratorsDAOImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/generators")
public class AdminGeneratorsServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the generators page HTML
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		List<Generator> entries = dao.getAll();

		out.println("<h1>Hello events servlet!</h1>");
		ArrayList<Generator> list = (ArrayList<Generator>) getServletContext().getAttribute("generator-entries");
		String html = "<h1>Events<h1>";
        html +=  "<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/app.css' />";
		html += "<ul>";
        html += "<a href=\"game-info.html\">Game Information</a></br>";
        html += "<a href=\"generator-meta.html\">Generators</a></br>";
        html += "<a href=\"events-meta.html\">Events</a></br>";
        html += "</ul>";
        html += "<div class=\"container\">";
        html += "<h4>Generator Name:</h4>";
        html += "<form method= 'POST'>";
        html += "<input name = 'name' type=\"text\" id=\"generator name\">";

        html += "<h4>Generator Rate:</h4>";

        html += "<input name = 'rate' type=\"text\" id=\"generator rate\">";

        html += "<h4>Base Cost:</h4>";

        html += "<input name = 'cost' type=\"text\" id=\"base cost\">";

        html += "<h4>Unlock At:</h4>";

        html += "<input name = 'unlockAt' type=\"text\" id=\"unlock at\">";

        html += "<h4>Description:</h4>";

        html += "<input name = 'description' type=\"text\" id=\"description\">";
        html += "<button>Add/Edit</button>";
        html += "</form>";
        html += "</div>";

        html += "<table>";
        html += " <tr>\n" +
                "    <th>Name</th>\n" +
                "    <th>Rate</th>\n" +
                "    <th>Cost</th>\n" +
                "    <th>Unlock At</th>\n" +
                "    <th>Description</th>\n" +
                "    <th>Edit</th>\n" +
                "  </tr>";
        for(Generator entry: entries){
            html += "<tr>";
            html += "<td>" + entry.getName() + "</td><td>" + entry.getRate() + "</td><td>" + entry.getBaseCost() + "</td><td>" + entry.getUnlockAt() + "</td><td>" + entry.getDescription() + "</td><td>edit : delete</td>";
            html += "</tr>";
        }
        html += "</table>";
        out.println(html);


	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
        GeneratorsDAO entry = new GeneratorsDAOImpl(getServletContext());
        List<Generator> entries = entry.getAll();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String unlockAt = request.getParameter("unlockAt");
        String cost = request.getParameter("cost");
        String rate = request.getParameter("rate");

        Generator gen = new Generator(entries.size(), name, description, Integer.parseInt(rate), Integer.parseInt(cost), Integer.parseInt(unlockAt));
        entry.add(gen);
        response.sendRedirect("generators");
	}
}
