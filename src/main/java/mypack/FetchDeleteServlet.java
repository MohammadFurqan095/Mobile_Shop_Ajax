package mypack;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns = {"/FetchDeleteServlet"})
public class FetchDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	//	out.println("<br doget called>");
		fetchdelete(req, resp);
	}
/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<br dopost called>");
		fetchdelete(req, resp);
	}
*/
	void fetchdelete(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
	//	out.println("<br> fetchdelete called");
		CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
		String result=dao.fetchdelete();
		out.println(result);
	}
}
