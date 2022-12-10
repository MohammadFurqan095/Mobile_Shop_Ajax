package mypack;

import java.io.PrintWriter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(urlPatterns = {"/CellphonefetchAvailableservlet"})
public class CellphonefetchAvailableservlet extends HttpServlet {
	
	// Fetch available called
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
//		out.println("doget fetch Available called");
		fetchAvailable(req, resp);
	}

	void fetchAvailable(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<br>");
	//	out.println("fetch Available called");
		CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
		String result=dao.fetchAllAvailable();
		out.println(result);
	}

}
