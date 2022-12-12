package mypack;

import java.sql.*;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class CellphoneDAOImpl implements CellphoneDAO {

	private String driver="com.mysql.cj.jdbc.Driver";
	private String username="root", password="";
	private String url="jdbc:mysql://localhost:3306/cellphonedb";
	private Connection con=null;
	
	void openconnection() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
			System.out.println("conncetion established");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	// Fetch Available 
	@Override
	public String fetchAllAvailable() {
		// TODO Auto-generated method stub
		String res="";
		try {
			this.openconnection();
			String query="select * from mobile_shop"+
					" where currentstatus= 'Available'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			res="<div class='mydivf'><table border='1' align='center'>";
			res+="<tr>";
			res+="<th>Mobile ID</th>"+
					"<th>Brand Name</th>"+
					"<th>Model Name</th>"+
					"<th>RAM</th>"+
					"<th>ROM</th>"+
					"<th>Processor</th>"+
					"<th>Buy date</th>"+
					"<th>Purchase Price</th>"+
					"<th>Currentstatus</th>"+
					"<th>Delete</th>"+
					"<th>Sell</th>"+
					"<th>Update</th>";
			
			res+="</tr>";
			while(rs.next()==true) {
				res+="<tr>";
				String mobileid=rs.getString("mobileid");
				String brandname=rs.getString("brandname");
				String modelname=rs.getString("modelname");
				String ram=rs.getString("ram");
				String rom=rs.getString("rom");
				String processor=rs.getString("Processor");
				String buydate=rs.getString("buydate");
				String purchaseprice=rs.getString("purchaseprice");
				String currentstatus=rs.getString("currentstatus");
				res+="<td>"+mobileid+"</td>"+
						"<td>"+brandname+"</td>"+
						"<td>"+modelname+"</td>"+
						"<td>"+ram+"</td>"+
						"<td>"+rom+"</td>"+
						"<td>"+processor+"</td>"+
						"<td>"+buydate+"</td>"+
						"<td>"+purchaseprice+"</td>"+
						"<td>"+currentstatus+"</td>"+
						"<td><a href='#' onclick='return functiondelete("+mobileid+");'>Delete</a></td>"+
						"<td><a href='#' onclick='return Sold("+mobileid+");'>Click to Sell</a></td>"+
						"<td><a href='#' onclick='return updateid("+mobileid+")'>Update</a></td>";
						res+="</tr>";
			}
			
			rs.close();
			stmt.close();
			res+="</table></div>";
		}
		catch(Exception e) {
			res="<br>"+e.toString();
		}
		return res;
	}
	// Fetch sold data
	@Override
	public String fetchAll() {
		// TODO Auto-generated method stub
		String res="";
		try {
			this.openconnection();
			String query="select * from mobile_shop"+
					" where currentstatus= 'Sold'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			res="<div class='mydivf'><table border='1' align='center'>";
			res+="<tr>";
			res+="<th>Mobile ID</th>"+
					"<th>Brand Name</th>"+
					"<th>Model Name</th>"+
					"<th>RAM</th>"+
					"<th>ROM</th>"+
					"<th>Processor</th>"+
					"<th>Buy date</th>"+
					"<th>Purchase Price</th>"+
					"<th>Sell date</th>"+
					"<th>Coustomer name</th>"+
					"<th>Coustomer address</th>"+
					"<th>Coustomer mobileno</th>"+
					"<th>Sell price</th>"+
					"<th>Currentstatus</th>"+
					"<th>Update</th>";
			res+="</tr>";
			while(rs.next()==true) {
				res+="<tr>";
				String mobileid=rs.getString("mobileid");
				String brandname=rs.getString("brandname");
				String modelname=rs.getString("modelname");
				String ram=rs.getString("ram");
				String rom=rs.getString("rom");
				String processor=rs.getString("Processor");
				String buydate=rs.getString("buydate");
				String purchaseprice=rs.getString("purchaseprice");
				String selldate=rs.getString("selldate");
				String coustomername=rs.getString("coustomername");
				String coustomeraddress=rs.getString("coustomeraddress");
				String coustomermobileno=rs.getString("coustomermobileno");
				String sellprice=rs.getString("sellprice");
				String currentstatus=rs.getString("currentstatus");
				res+="<td>"+mobileid+"</td>"+
						"<td>"+brandname+"</td>"+
						"<td>"+modelname+"</td>"+
						"<td>"+ram+"</td>"+
						"<td>"+rom+"</td>"+
						"<td>"+processor+"</td>"+
						"<td>"+buydate+"</td>"+
						"<td>"+purchaseprice+"</td>"+
						"<td>"+selldate+"</td>"+
						"<td>"+coustomername+"</td>"+
						"<td>"+coustomeraddress+"</td>"+
						"<td>"+coustomermobileno+"</td>"+
						"<td>"+sellprice+"</td>"+
						"<td>"+currentstatus+"</td>"+
						"<td><a href='#' onclick='return sellupdateid("+mobileid+")'>Update</a></td>";
						res+="</tr>";
			}
			
			rs.close();
			stmt.close();
			res+="</table></div>";
		}
		catch(Exception e) {
			res=e.toString();
		}
		return res;
	}
	// Insert query 
	@Override
	public String insert(Cellphone cellphone) {
		// TODO Auto-generated method stub
		String res="";
		try {
			this.openconnection();
			String query="insert into mobile_shop (brandname, modelname,ram, rom,"
					+ "processor,buydate,purchaseprice,currentstatus) value(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, cellphone.getBrandname());
			ps.setString(2, cellphone.getModelname());
			ps.setString(3, cellphone.getRam());
			ps.setString(4, cellphone.getRom());
			ps.setString(5, cellphone.getProcessor());
			ps.setString(6, cellphone.getBuydate());
			ps.setDouble(7, cellphone.getPurchaseprice());
			ps.setString(8, "Available");
			int result=ps.executeUpdate();
			res=result+" record/s insert in mobile shop table";
			ps.close();
			con.close();
		}
		catch(Exception e) {
			res=e.toString();
		}
		return res;
	}
	// Fetch by id for sell cellphone 
	@Override
	public String[] fetchbyid(int mobileid) {
		// TODO Auto-generated method stub
		String[] res=new String[8];
		try {
			this.openconnection();
			String query="select * from mobile_shop "+
			" where mobileid=? ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, mobileid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true) {
				res[0]=rs.getString(1);
				res[1]=rs.getString(2);
				res[2]=rs.getString(3);
				res[3]=rs.getString(9);
				res[4]=rs.getString(10);
				res[5]=rs.getString(11);
				res[6]=rs.getString(12);
				res[7]=rs.getString(13);
			}
			ps.close();
		}
		catch(Exception e) {
			res[0]=e.toString();
		}
		return res;
	}
	// Query for sell cellphone 
	@Override
	public String sold(Cellphone cellphone) {
		// TODO Auto-generated method stub
		String res="";
		try {
			this.openconnection();
			String query="update mobile_shop set "+
			"currentstatus='sold' ,"+
					" selldate=?,"+
					" coustomername=?,"+
					" coustomeraddress=?,"+
					" coustomermobileno=?,"+
					" sellprice=?"+
					" where mobileid=?;";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, cellphone.getSelldate());
			ps.setString(2, cellphone.getCoustomername());
			ps.setString(3, cellphone.getCoustomeraddress());
			ps.setString(4, cellphone.getCoustomermobileno());
			ps.setDouble(5, cellphone.getSellprice());
			ps.setInt(6, cellphone.getMobileid());
			
			int result=ps.executeUpdate();
			res=result+" cellphone sell in mobile shop table";
			ps.close();
			con.close();
		}
		catch(Exception e) {
			res=e.toString();
		}
		return res;
	}
	// Available data delete
	@Override
	public String delete(int mobileid) {
		// TODO Auto-generated method stub
		String res="";
		try {
			this.openconnection();
			String query="update mobile_shop set "+
			" currentstatus='Close' "+
			" where mobileid=? ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, mobileid);
			int result=ps.executeUpdate();
			res=result+" Record deleted form Mobile_shop";
			ps.close();
			
		}
		catch(Exception e) {
			res="<br>"+e.toString();
		}
		return res;
	}
	// fetchdelete function
	@Override
	public String fetchdelete() {
		// TODO Auto-generated method stub
		String res="";
		try {
			this.openconnection();
			String query="select * from mobile_shop"+
					" where currentstatus= 'Close'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			res="<div class='mydivf'><table border='1' align='center'>";
			res+="<tr>";
			res+="<th>Mobile ID</th>"+
					"<th>Brand Name</th>"+
					"<th>Model Name</th>"+
					"<th>RAM</th>"+
					"<th>ROM</th>"+
					"<th>Processor</th>"+
					"<th>Buy date</th>"+
					"<th>Purchase Price</th>"+
					"<th>Currentstatus</th>"+
					"<th>Repurchase</th>";
			res+="</tr>";
			while(rs.next()==true) {
				res+="<tr>";
				String mobileid=rs.getString("mobileid");
				String brandname=rs.getString("brandname");
				String modelname=rs.getString("modelname");
				String ram=rs.getString("ram");
				String rom=rs.getString("rom");
				String processor=rs.getString("Processor");
				String buydate=rs.getString("buydate");
				String purchaseprice=rs.getString("purchaseprice");
				String currentstatus=rs.getString("currentstatus");
				res+="<td>"+mobileid+"</td>"+
						"<td>"+brandname+"</td>"+
						"<td>"+modelname+"</td>"+
						"<td>"+ram+"</td>"+
						"<td>"+rom+"</td>"+
						"<td>"+processor+"</td>"+
						"<td>"+buydate+"</td>"+
						"<td>"+purchaseprice+"</td>"+
						"<td>"+currentstatus+"</td>"+
						"<td><a href='#' onclick='return functionrepurchase("+mobileid+")'>Repurchase</a></td>";
						res+="</tr>";
			}
			
			rs.close();
			stmt.close();
			res+="</table></div>";
		}
		catch(Exception e) {
			res="<br>"+e.toString();
		}
		return res;
	}
	// call to repurchase of delete items
	@Override
	public String repurchase(int mobileid) {
		// TODO Auto-generated method stub
		String res=""; 
		try {
			this.openconnection();
		String query="update mobile_shop set "+
		" currentstatus='Available' "+
				" where mobileid=? ";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, mobileid);
		int result=ps.executeUpdate();
		res=result+" Record repurchase form Mobile_shop";
		ps.close();
		}
		catch(Exception e) {
			res="<br>"+e.toString();
		}
		return res;
	}
	// fetch by id for update available data  
	@Override
	public String[] updatebyid(int mobileid) {
		// TODO Auto-generated method stub
		String[] res=new String[8];
		try {
			this.openconnection();
			String query="select * from mobile_shop "+
			" where mobileid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, mobileid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()==true) {
				res[0]=rs.getString(1);
				res[1]=rs.getString(2);
				res[2]=rs.getString(3);
				res[3]=rs.getString(4);
				res[4]=rs.getString(5);
				res[5]=rs.getString(6);
				res[6]=rs.getString(7);
				res[7]=rs.getString(8);
			}
			ps.close();
		}
		catch(Exception e) {
			res[0]="<br>"+e.toString();
		}
		return res;
	}
	// update query for available data
	@Override
	public String updatecellphone(Cellphone cellphone) {
		// TODO Auto-generated method stub
		String res="";
		try {
			this.openconnection();
			String query="update mobile_shop set "+
			" currentstatus='Available' ,"+
					" brandname=?, "+
			" modelname=? ,"+
					" ram=? ,"+
			" rom=? ,"+
					"processor=? ,"+
					"buydate=? ,"+
			" purchaseprice=? "+
					" where mobileid=?;";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, cellphone.getBrandname());
			ps.setString(2, cellphone.getModelname());
			ps.setString(3, cellphone.getRam());
			ps.setString(4, cellphone.getRom());
			ps.setString(5, cellphone.getProcessor());
			ps.setString(6, cellphone.getBuydate());
			ps.setDouble(7, cellphone.getPurchaseprice());
			ps.setInt(8, cellphone.getMobileid());
			int result=ps.executeUpdate();
			res=result+" Record update in mobile shop ";
			ps.close();
			con.close();
		}
		catch(Exception e) {
			res="<br>"+e.toString();
		}
		return res;
	}
	// Fetch by id for update sold data
	@Override
	public String[] updatesoldid(int mobileid) {
		// TODO Auto-generated method stub
		String[] res=new String[13];
		try {
			this.openconnection();
			String query="select * from mobile_shop "+
			" where mobileid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, mobileid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()==true) {
				res[0]=rs.getString(1);
				res[1]=rs.getString(2);
				res[2]=rs.getString(3);
				res[3]=rs.getString(4);
				res[4]=rs.getString(5);
				res[5]=rs.getString(6);
				res[6]=rs.getString(7);
				res[7]=rs.getString(8);
				res[8]=rs.getString(9);
				res[9]=rs.getString(10);
				res[10]=rs.getString(11);
				res[11]=rs.getString(12);
				res[12]=rs.getString(13);
				
			}
			rs.close();
		}
		catch(Exception e) {
			res[0]="<br>"+e.toString();
		}
		return res;
	}
	// Query for update sold data
	@Override
	public String updatesold(Cellphone cellphone) {
		// TODO Auto-generated method stub
		String res="";
		try {
			this.openconnection();
			String query="update mobile_shop set "+
					" currentstatus='Sold' ,"+
					"  brandname=? ,"+
					" modelname=? , "+
					" ram=? ,"+ 
					" rom=? ,"+
					"processor=? ,"+
					"buydate=? ,"+
			" purchaseprice=? ,"+
			" selldate=? ,"+
			" coustomername=?,"+
			" coustomeraddress=?,"+
			" sellprice=? ,"+
			" coustomermobileno=?"+
					" where mobileid=?;";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, cellphone.getBrandname());
			ps.setString(2, cellphone.getModelname());
			ps.setString(3, cellphone.getRam());
			ps.setString(4, cellphone.getRom());
			ps.setString(5, cellphone.getProcessor());
			ps.setString(6, cellphone.getBuydate());
			ps.setDouble(7, cellphone.getPurchaseprice());
			ps.setString(8, cellphone.getSelldate());
			ps.setString(9, cellphone.getCoustomername());
			ps.setString(10, cellphone.getCoustomeraddress());
			ps.setDouble(11, cellphone.getSellprice());
			ps.setString(12, cellphone.getCoustomermobileno());
			ps.setDouble(13, cellphone.getMobileid());
			
			int result=ps.executeUpdate();
			res=result+" Sold record updated in mobile shop";
			ps.close();
			con.close();
		}
		catch(Exception e) {
			res="<br>"+e.toString();
		}
		return res;
	}
	
}
