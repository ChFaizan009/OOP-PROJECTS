package cust;

public class Customer 
{

	public static String csvFile = "D:\\OOP Projects\\TimeTableFiles\\Customer.csv";

	private int CUSTOMER_ID;
	
	private String CUSTOMER_NAME;
	
	private String COMPANY_NAME;
	
	private String CUSTOMER_GENDER;
	
	private String CUSTOMER_ADDRESS;
	
	private int CUSTOMER_POSTALCODE;
	
	private int CUSTOMER_PHONE;

	public static String getCsvFile() {
		return csvFile;
	}

	public static void setCsvFile(String csvFile) {
		Customer.csvFile = csvFile;
	}

	public int getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}

	public void setCUSTOMER_ID(int cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}

	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}

	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}

	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}

	public String getCUSTOMER_GENDER() {
		return CUSTOMER_GENDER;
	}

	public void setCUSTOMER_GENDER(String cUSTOMER_GENDER) {
		CUSTOMER_GENDER = cUSTOMER_GENDER;
	}

	public String getCUSTOMER_ADDRESS() {
		return CUSTOMER_ADDRESS;
	}

	public void setCUSTOMER_ADDRESS(String cUSTOMER_ADDRESS) {
		CUSTOMER_ADDRESS = cUSTOMER_ADDRESS;
	}

	public int getCUSTOMER_POSTALCODE() {
		return CUSTOMER_POSTALCODE;
	}

	public void setCUSTOMER_POSTALCODE(int cUSTOMER_POSTALCODE) {
		CUSTOMER_POSTALCODE = cUSTOMER_POSTALCODE;
	}

	public int getCUSTOMER_PHONE() {
		return CUSTOMER_PHONE;
	}

	public void setCUSTOMER_PHONE(int cUSTOMER_PHONE) {
		CUSTOMER_PHONE = cUSTOMER_PHONE;
	}

	
	@Override
	public String toString() {
		return "Customer [CUSTOMER_ID=" + CUSTOMER_ID + ", CUSTOMER_NAME=" + CUSTOMER_NAME + ", COMPANY_NAME="
				+ COMPANY_NAME + ", CUSTOMER_GENDER=" + CUSTOMER_GENDER + ", CUSTOMER_ADDRESS=" + CUSTOMER_ADDRESS
				+ ", CUSTOMER_POSTALCODE=" + CUSTOMER_POSTALCODE + ", CUSTOMER_PHONE=" + CUSTOMER_PHONE + "]";
	}
	
	
	
	
}
