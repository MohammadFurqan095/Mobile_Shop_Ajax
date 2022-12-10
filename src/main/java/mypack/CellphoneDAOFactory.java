package mypack;

public class CellphoneDAOFactory {

	public static CellphoneDAO createCellphone() {
		return (new CellphoneDAOImpl());
	}
	
}
