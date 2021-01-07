package edu.atm.main.customer;

public class Customer
{

	public static String CustomerFile = "Customers.csv";
	
	private int CUSTOMER_ID;
	private String CUSTOMER_NAME;
	private int CUSTOMER_AGE;
	private long CUSTOMER_BALANCE;
	private int CUSTOMER_NO_OF_TRANSACTIONS;
	
	
	public Customer() {}
	

	public static String getCustomerFile() {
		return CustomerFile;
	}

	public static void setCustomerFile(String customerFile) {
		CustomerFile = customerFile;
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

	public int getCUSTOMER_AGE() {
		return CUSTOMER_AGE;
	}

	public void setCUSTOMER_AGE(int cUSTOMER_AGE) {
		CUSTOMER_AGE = cUSTOMER_AGE;
	}

	public long getCUSTOMER_BALANCE() {
		return CUSTOMER_BALANCE;
	}

	public void setCUSTOMER_BALANCE(long cUSTOMER_BALANCE) {
		CUSTOMER_BALANCE = cUSTOMER_BALANCE;
	}

	public int getCUSTOMER_NO_OF_TRANSACTIONS() {
		return CUSTOMER_NO_OF_TRANSACTIONS;
	}

	public void setCUSTOMER_NO_OF_TRANSACTIONS(int cUSTOMER_NO_OF_TRANSACTIONS) {
		CUSTOMER_NO_OF_TRANSACTIONS = cUSTOMER_NO_OF_TRANSACTIONS;
	}


	public Customer(int cUSTOMER_ID, String cUSTOMER_NAME, int cUSTOMER_AGE, long cUSTOMER_BALANCE,
			int cUSTOMER_NO_OF_TRANSACTIONS) {
		super();
		CUSTOMER_ID = cUSTOMER_ID;
		CUSTOMER_NAME = cUSTOMER_NAME;
		CUSTOMER_AGE = cUSTOMER_AGE;
		CUSTOMER_BALANCE = cUSTOMER_BALANCE;
		CUSTOMER_NO_OF_TRANSACTIONS = cUSTOMER_NO_OF_TRANSACTIONS;
	}




	@Override
	public String toString() {
		return "Customer [CUSTOMER_ID=" + CUSTOMER_ID + ", CUSTOMER_NAME=" + CUSTOMER_NAME + ", CUSTOMER_AGE="
				+ CUSTOMER_AGE + ", CUSTOMER_BALANCE=" + CUSTOMER_BALANCE + ", CUSTOMER_NO_OF_TRANSACTIONS="
				+ CUSTOMER_NO_OF_TRANSACTIONS + "]";
	}

	public String toStringSave() {
		return CUSTOMER_ID + ","+ CUSTOMER_NAME + ","+ CUSTOMER_AGE+ ","+ CUSTOMER_BALANCE + ","+ CUSTOMER_NO_OF_TRANSACTIONS;
		
	}
}
