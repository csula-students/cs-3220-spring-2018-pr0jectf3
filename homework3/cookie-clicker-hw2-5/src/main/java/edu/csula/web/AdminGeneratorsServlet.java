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
		// TODO: render the generators page HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		List<Generator> generators = dao.getAll();

        request.setAttribute("generators", generators);
//        String generatorID = request.getParameter("id");
//		int num = -1;
//
//		if(generatorID != null){
//		    num = getIndex(Integer.parseInt(generatorID));
//        }
//        request.setAttribute("index", num);
//		if(request.getParameter("deleteId") != null){
//		    int num2 = Integer.parseInt(request.getParameter("deleteId"));
//		    Generator g = null;
//		    g = generators.get(getIndex(num2));
//		    dao.remove(g.getId());
//		    response.sendRedirect("generators");
//        }
        request.getRequestDispatcher("/WEB-INF/admin-generator.jsp").forward(request, response);

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

	public int getIndex(int x){
	    final int DEFAULT = -1;
	    GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
	    List<Generator> gen = dao.getAll();
	    for(int i =0; i< gen.size(); i++){
	        if(x == gen.get(i).getId()){
	            return i;
            }
        }
        return DEFAULT;
    }
}
