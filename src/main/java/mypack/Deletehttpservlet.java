package mypack;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns = {"/Deletehttpservlet"})
public class Deletehttpservlet extends HttpServlet {

	// Delete servlet called
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	//	out.println("doget delete called");
		Delete(req, resp);
	}
	void Delete(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<br>");
	//	out.println("delete servlet called");
		int mobileid=Integer.parseInt(req.getParameter("mobileid"));
		out.println("<br> Mobile ID= "+mobileid);
		CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
		String result=dao.delete(mobileid);
		out.println("<br>"+result);
	}
}
