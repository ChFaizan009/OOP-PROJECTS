
public class basic {

	 int PRODUCT_ID;
	 String PRODUCT_NAME;
	 String PRODUCT_QUALITY;
	 String PRODUCT_PRICE;
	 String PRODUCT_EXPERIEDDATE;
	
	
	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(int pRODUCT_ID) {
	PRODUCT_ID = pRODUCT_ID;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public String getPRODUCT_QUALITY() {
		return PRODUCT_QUALITY;
	}
	public void setPRODUCT_QUALITY(String pRODUCT_QUALITY) {
		PRODUCT_QUALITY = pRODUCT_QUALITY;
	}
	public String getPRODUCT_PRICE() {
		return PRODUCT_PRICE;
	}
	public void setPRODUCT_PRICE(String pRODUCT_PRICE) {
		PRODUCT_PRICE = pRODUCT_PRICE;
	}
	public String getPRODUCT_EXPERIEDDATE() {
		return PRODUCT_EXPERIEDDATE;
	}
	public void setPRODUCT_EXPERIEDDATE(String pRODUCT_EXPERIEDDATE) {
		PRODUCT_EXPERIEDDATE = pRODUCT_EXPERIEDDATE;
	}
		  public basic(int pRODUCT_ID, String pRODUCT_NAME, String pRODUCT_QUALITY,
		  String pRODUCT_PRICE, String pRODUCT_EXPERIEDDATE)  { 
		  this.PRODUCT_ID=pRODUCT_ID; 
		  this.PRODUCT_NAME=pRODUCT_NAME; 
		  this.PRODUCT_PRICE=pRODUCT_PRICE; 
		  this.PRODUCT_QUALITY=pRODUCT_QUALITY; 
		  this.PRODUCT_EXPERIEDDATE=pRODUCT_EXPERIEDDATE;  }
		
		  
		  basic()
	{
		PRODUCT_ID=12;
		PRODUCT_NAME="CREAM";
		PRODUCT_QUALITY="High";
		PRODUCT_PRICE="2000";
		PRODUCT_EXPERIEDDATE="20 June 2020";
	}
	void display(){
		System.out.println(PRODUCT_ID+" "+PRODUCT_NAME+" "+PRODUCT_PRICE+" "+PRODUCT_QUALITY+" "+PRODUCT_EXPERIEDDATE);}  
		   	  
		  
	public static void main(String[] arg) {
	
	basic obj=new basic(12,"BODYSPRAY","HIGH","4000","2012");
	basic obj1=new basic();
	
	obj.display();
	obj1.display();
	
	}
	
	}


