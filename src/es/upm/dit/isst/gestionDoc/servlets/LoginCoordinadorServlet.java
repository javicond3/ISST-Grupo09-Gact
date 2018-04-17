package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCoordinadorServlet
 */
@WebServlet("/LoginCoordinadorServlet")
public class LoginCoordinadorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("menuCoordinador", 0);
		resp.sendRedirect(req.getContextPath() + "/LoginCoordinador.jsp");
	}

}
