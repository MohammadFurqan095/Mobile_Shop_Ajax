package mypack;

import java.io.*;
import  javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/Soldhttpservlet"})
public class Soldhttpservlet extends HttpServlet {

	// servlet for cellphone sell 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	//	out.println("sold do post called");
		sold(req, resp);
	}
	void sold(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException,IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<br>");
	//	out.println("my servlet sold called");
	//	out.println("<br>");
		try {
			int mobileid=Integer.parseInt(req.getParameter("mobileid"));
			String brandname=req.getParameter("brandname");
			String modelname=req.getParameter("modelname");
			String selldate=req.getParameter("selldate");
			String coustomername=req.getParameter("coustomername");
			String coustomeraddress=req.getParameter("coustomeraddress");
			String coustomermobileno=req.getParameter("coustomermobileno");
			double sellprice=Double.parseDouble(req.getParameter("sellprice"));
			
			Cellphone cellphone=new Cellphone();
			cellphone.setMobileid(mobileid);
			cellphone.setBrandname(brandname);
			cellphone.setModelname(modelname);
			cellphone.setSelldate(selldate);
			cellphone.setCoustomername(coustomername);
			cellphone.setCoustomeraddress(coustomeraddress);
			cellphone.setCoustomermobileno(coustomermobileno);
			cellphone.setSellprice(sellprice);
			
			
			CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
			String result=dao.sold(cellphone);
			out.println("<br>"+result);
			
		}
		catch(Exception e) {
			out.println("<br>"+e.toString());
		}
	}
	
}
