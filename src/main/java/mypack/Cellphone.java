package mypack;

public class Cellphone {

	private int mobileid;
	private String brandname, modelname, ram, rom, processor, buydate, selldate, 
	coustomername,coustomeraddress, currentstatus, coustomermobileno;
	private double purchaseprice, sellprice;
	public int getMobileid() {
		return mobileid;
	}
	public void setMobileid(int mobileid) {
		this.mobileid = mobileid;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getBuydate() {
		return buydate;
	}
	public void setBuydate(String buydate) {
		this.buydate = buydate;
	}
	public String getSelldate() {
		return selldate;
	}
	public void setSelldate(String selldate) {
		this.selldate = selldate;
	}
	public String getCoustomername() {
		return coustomername;
	}
	public void setCoustomername(String coustomername) {
		this.coustomername = coustomername;
	}
	public String getCoustomeraddress() {
		return coustomeraddress;
	}
	public void setCoustomeraddress(String coustomeraddress) {
		this.coustomeraddress = coustomeraddress;
	}
	public double getPurchaseprice() {
		return purchaseprice;
	}
	public void setPurchaseprice(double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}
	public double getSellprice() {
		return sellprice;
	}
	public void setSellprice(double sellprice) {
		this.sellprice = sellprice;
	}
	public String getCoustomermobileno() {
		return coustomermobileno;
	}
	public void setCoustomermobileno(String coustomermobileno) {
		this.coustomermobileno = coustomermobileno;
	}
	
	public String getCurrentstatus() {
		return currentstatus;
	}
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}
	public Cellphone() { }
	public Cellphone(String brandname, String modelname, String ram, String rom, String processor, String buydate,
			String selldate, String coustomername, String coustomeraddress, double purchaseprice, double sellprice,
			String coustomermobileno, String currentstatus) {
		super();
		this.brandname = brandname;
		this.modelname = modelname;
		this.ram = ram;
		this.rom = rom;
		this.processor = processor;
		this.buydate = buydate;
		this.selldate = selldate;
		this.coustomername = coustomername;
		this.coustomeraddress = coustomeraddress;
		this.purchaseprice = purchaseprice;
		this.sellprice = sellprice;
		this.coustomermobileno = coustomermobileno;
		this.currentstatus = currentstatus;
	}
	
}
