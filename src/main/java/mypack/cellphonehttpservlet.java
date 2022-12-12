package mypack;


import java.io.PrintWriter;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/cellphonehttpservlet"})
public class cellphonehttpservlet extends HttpServlet {

	// Fetch all sold called
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	//	out.println("do get called");
		Fetchall(req, resp);
	}

	void Fetchall(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<br>");
//		out.println("servlet called");
		CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
		String result=dao.fetchAll();
		out.println(result);
		
	}

}
