package mypack;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns = {"/updateidservlet"})
public class updateidservlet extends HttpServlet {
	
	// Update servlet called for update by array
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	//	out.println("doget updateid called");
		updateid(req, resp);
	}
	
	void updateid(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		int mobileid=Integer.parseInt(req.getParameter("mobileid"));
		out.println("<br>");
	//	out.println("updateid called servlet");
		out.println("<br>mobile id= "+mobileid);
		CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
		String[] result=dao.updatebyid(mobileid);
		out.println("<br>"+result[0]+" , "+result[1]+" , "+result[2]+" , "+result[3]+" , "
				+result[4]+" , "+result[5]+" , "+result[6]+" , "+result[7]);
		out.println("<form name='update1' method='post' action='updateservlet'>");
		out.println("<input type='hidden' name='mobileid' value='"+result[0]+"'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Enter Brand Name <input type='text' name='brandname' value='"+result[1]+"'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>");
		out.println("Enter Model Name <input type='text' name='modelname' value='"+result[2]+"'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Enter RAM of mobile <input type='text' name='ram' value='"+result[3]+"'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Enter ROM of mobile <input type='text' name='rom' value='"+result[4]+"'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Enter Processor of mobile <input type='text' name='processor' value='"+result[5]+"'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Enter Buy Date <input type='date' name='buydate' value='"+result[6]+"'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Enter purchase price <input type='text' name='purchaseprice' value='"+result[7]+"'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Update <input type='button' value='Update' onclick='return updateRecored()'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</form>");
 	}
}
