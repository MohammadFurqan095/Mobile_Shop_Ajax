package mypack;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns = {"/updateservlet"})
public class updateservlet extends HttpServlet {

	// Update servlet called for available
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	//	out.println("dopost update called");
		update(req, resp);
	}

	void update(HttpServletRequest req, HttpServletResponse res)
	    	throws ServletException, IOException  {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
	//	out.println("<br>update called");
		try {
			int mobileid=Integer.parseInt(req.getParameter("mobileid"));
			String brandname=req.getParameter("brandname");
			String modelname=req.getParameter("modelname");
			String ram=req.getParameter("ram");
			String rom=req.getParameter("rom");
			String processor=req.getParameter("processor");
			String buydate=req.getParameter("buydate");
			double purchaseprice=Double.parseDouble(req.getParameter("purchaseprice"));
			
			Cellphone cellphone=new Cellphone();
			cellphone.setMobileid(mobileid);
			cellphone.setBrandname(brandname);
			cellphone.setModelname(modelname);
			cellphone.setRam(ram);
			cellphone.setRom(rom);
			cellphone.setProcessor(processor);
			cellphone.setBuydate(buydate);
			cellphone.setPurchaseprice(purchaseprice);
			
			CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
			String result=dao.updatecellphone(cellphone);
			out.println(result);
		}
		catch(Exception e) {
			out.println("<br>"+e.toString());
		}
	}
}
