package mypack;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns = {"/UpdateSoldidServlet"})
public class UpdateSoldidServlet extends HttpServlet {

	// Update servlet called for sold data by array
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	//	out.println("<br>doget updatesoldid servlet called");
		soldidupdate(req, resp);
	}
	
		void soldidupdate(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException {
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
		//	out.println("<br>sold id update called");
			int mobileid=Integer.parseInt(req.getParameter("mobileid"));
			out.println("<br>mobile id= "+mobileid);
			CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
			String[] result=dao.updatesoldid(mobileid);
			out.println("<br>"+result[0]+" , "+result[1]+" , "+result[2]+" , "+result[3]+" , "
					+result[4]+" , "+result[5]+" , "+result[6]+" , "+result[7]+" , "+
					result[8]+" , "+result[9]+" , "+result[10]+" , "+result[11]+
					" , "+result[12]);
			out.println("<form name='soldupdate1' method='post' action='UpdateSoldservlet'>");
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
			out.println("Enter sell date <input type='date' name='selldate' value='"+result[8]+"'>");
			out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>");
			out.println("Enter coustomer name <input type='text' name='coustomername' value='"+result[9]+"'>");
			out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>");
			out.println("Enter coustomer address <input type='text' name='coustomeraddress' value='"+result[10]+"'>");
			out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>");
			out.println("Enter sell price number <input type='text' name='sellprice' value='"+result[11]+"'>");
			out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>");
			out.println("Enter coustomer mobile number <input type='text' name='coustomermobileno' value='"+result[12]+"'>");
			out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>");
			out.println("Update sell record <input type='button' value='Updates' onclick='return sellupdate()'>");
			out.println("</td>");
			out.println("</tr>");
			
			out.println("</table>");
			out.println("</form>");
		}
}
