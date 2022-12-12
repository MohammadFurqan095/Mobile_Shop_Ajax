package mypack;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/SoldHttpservlet1"})
public class SoldHttpservlet1 extends HttpServlet {

	// Servlet for cellphone sell by array
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	//	out.println("doget called of sold httpservlet1");
		fetchsoldid(req, resp);
	}
	
	void fetchsoldid(HttpServletRequest req, HttpServletResponse res) 
			throws  ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		int mobileid=Integer.parseInt(req.getParameter("mobileid"));
		out.println("<br>");
	//	out.println("fetchsoldid called");
		out.println("<br>mobileid= "+mobileid);
		CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
		String[] result=dao.fetchbyid(mobileid);
		out.println("<br>"+result[0]
				+","+result[1]+", "+result[2]+", "
				+result[3]+", "+result[4]+", "+result[5]+", "+result[6]+", "+result[7]);
		out.println("<form name='soldservlet' method='post' action='Soldhttpservlet'>");
		out.println("<input type='hidden' name='mobileid' value='"+result[0]+"'>");
		out.println("<input type='hidden' name='brandname' value='"+result[1]+"'>");
		out.println("<input type='hidden' name='modelname' value='"+result[2]+"'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>Sell Date  <input type='date' name='selldate' placeholder='sell date (yyyy-mm-dd)' value='"+result[3]+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Coustomer Name  <input type='text' name='coustomername' placeholder='coustomer name' value='"+result[4]+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Coustomer Address  <input type='text' name='coustomeraddress' placeholder='coustomer address' value='"+result[5]+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Coustomer Mobile Number  <input type='text' name='coustomermobileno' placeholder='coustomer mobile number' value='"+result[6]+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Sell price  <input type='text' name='sellprice' placeholder='enter sell price' value='"+result[7]+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Sell  <input type='button' value='sell mobile' onclick='return SoldRecored()'><td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</form>");	
	}
}