package mypack;

import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = {"/cellphoneinserthttpservlet"})
public class cellphoneinserthttpservlet extends HttpServlet {

	// Cellphone insert called
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	//	out.println("do post called");
		insert(req, resp);
	}
	
	
	void insert(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<br>");
		try {
			String brandname=req.getParameter("brandname"); 
			String modelname=req.getParameter("modelname");
			String ram=req.getParameter("ram");
			String rom=req.getParameter("rom");
			String processor=req.getParameter("processor");
			String buydate=req.getParameter("buydate");
			double purchaseprice=Double.parseDouble(req.getParameter("purchaseprice"));
			Cellphone cellphone=new Cellphone();
			cellphone.setBrandname(brandname);
			cellphone.setModelname(modelname);
			cellphone.setRam(ram);
			cellphone.setRom(rom);
			cellphone.setProcessor(processor);
			cellphone.setBuydate(buydate);
			cellphone.setPurchaseprice(purchaseprice);
			cellphone.setCurrentstatus("Available");
			CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
			String result=dao.insert(cellphone);
			out.println(result);
		}
		catch(Exception e) {
			out.println("<br>"+e.toString());
		}
	}
}
