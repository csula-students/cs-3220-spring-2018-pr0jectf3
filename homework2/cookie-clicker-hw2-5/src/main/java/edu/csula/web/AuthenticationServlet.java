package edu.csula.web;

import edu.csula.storage.UsersDAO;
import edu.csula.storage.servlet.UsersDAOImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/auth")
public class AuthenticationServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the authentication page HTML
        doDelete(request, response);
		String html = "<h1>User Login</h1>";
        html +=  "<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/app.css' />";
		html += "<form method = 'POST'>";
        html += "Username:";
        html += "<input name = 'username' type = \"text\" /><br/><br/>";
        html += "</br/>\n" +
                "      Password:";
        html += "<input name = 'password'type = \"password\" />\n" +
                "    </br/>\n" +
                "    <br/>";
        html += "<button>Login</button>";
        html += "</form>";
        html += "";

		out.println(html);
	}

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle login
        UsersDAO dao = new UsersDAOImpl(request.getSession());
        if(dao.authenticate(request.getParameter("username"), request.getParameter("password"))){
            response.sendRedirect("generators");
        } else {
            response.sendRedirect("auth");
        }
	}

    @Override
    public void doDelete( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: handle logout
        UsersDAO dao = new UsersDAOImpl(request.getSession());
        dao.logout();
    }
}
