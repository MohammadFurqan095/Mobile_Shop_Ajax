package mypack;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns = {"/UpdateSoldservlet"})
public class UpdateSoldservlet extends HttpServlet {

	// Update servlet called for sold data  

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	//	out.println("dopost update sold servlet called");
		soldupdate(req, resp);
	}

	void soldupdate(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
	//	out.println("<br>sold update called");
		try {
			int mobileid=Integer.parseInt(req.getParameter("mobileid"));
			String brandname=req.getParameter("brandname");
			String modelname=req.getParameter("modelname");
			String ram=req.getParameter("ram");
			String rom=req.getParameter("rom");
			String processor=req.getParameter("processor");
			String buydate=req.getParameter("buydate");
			double purchaseprice=Double.parseDouble(req.getParameter("purchaseprice"));
			String selldate=req.getParameter("selldate");
			String coustomername=req.getParameter("coustomername");
			String coustomeraddress=req.getParameter("coustomeraddress");
			String coustomermobileno=req.getParameter("coustomermobileno");
			double sellprice=Double.parseDouble(req.getParameter("sellprice"));
			
			Cellphone cellphone=new Cellphone();
			cellphone.setMobileid(mobileid);
			cellphone.setBrandname(brandname);
			cellphone.setModelname(modelname);
			cellphone.setRam(ram);
			cellphone.setRom(rom);
			cellphone.setProcessor(processor);
			cellphone.setBuydate(buydate);
			cellphone.setPurchaseprice(purchaseprice);
			cellphone.setSelldate(selldate);
			cellphone.setCoustomername(coustomername);
			cellphone.setCoustomeraddress(coustomeraddress);
			cellphone.setCoustomermobileno(coustomermobileno);
			cellphone.setSellprice(sellprice);
			
			CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
			String result=dao.updatesold(cellphone);
			out.println("<br>"+result);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}			
}