package com.uog.pk;

public class Book {
	 private String BOOKNAME;
	 private int BOOK_ID;
	 private String PUBLISHER_NAME;
	 private String WRITER_NAME;
	
	 	 public String getBOOKNAME() {
		return BOOKNAME;
	}
	public void setBOOKNAME(String bOOKNAME) {
		BOOKNAME = bOOKNAME;
	}
	public int getBOOK_ID() {
		return BOOK_ID;
	}
	public void setBOOK_ID(int bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}
	public String getPUBLISHER_NAME() {
		return PUBLISHER_NAME;
	}
	
	
	
	public void setPUBLISHER_NAME(String pUBLISHER_NAME) {
		PUBLISHER_NAME = pUBLISHER_NAME;
	}
	public String getWRITER_NAME() {
		return WRITER_NAME;
	}
	public void setWRITER_NAME(String wRITER_NAME) {
		WRITER_NAME = wRITER_NAME;
	}
	public Book(String bOOKNAME, int bOOK_ID, String pUBLISHER_NAME, String wRITER_NAME) {
		super();
		BOOKNAME = bOOKNAME;
		BOOK_ID = bOOK_ID;
		PUBLISHER_NAME = pUBLISHER_NAME;
		WRITER_NAME = wRITER_NAME;
	
	}
	public static  void main(String[] arys)
	{
		Book obj = new Book("Ali ",  1054, " Ali", " Usman" );
		
	}
}
