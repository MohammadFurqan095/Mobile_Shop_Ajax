package mypack;

public interface CellphoneDAO {
	
	String fetchAllAvailable();
	String fetchAll();
	
	String insert(Cellphone cellphone);
	

	String[] fetchbyid(int mobileid);	
	String sold(Cellphone cellphone);
	
	String delete(int mobileid);
	
	String[] updatebyid(int mobileid);
	String updatecellphone(Cellphone cellphone);
	
	String[] updatesoldid(int mobileid);
	String updatesold(Cellphone cellphone);
	
}
