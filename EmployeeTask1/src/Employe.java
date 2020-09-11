import java.util.Scanner;
public class Employe {
	private  String FIRSTNAME;
	 private String LASTNAME;
	 private Double SALARY;

	
	
	public Employe(String f, String l, Double s) {
		
		FIRSTNAME = f;
		LASTNAME = l;
		SALARY = s;
	
	if(s<0)
	{
		SALARY=0.0;
	}
	else
	{
		SALARY =s;
	}
	
	}
	
	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}

	public String getLASTNAME() {
		return LASTNAME;
	}
	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}
	public Double getSALARY() {
		return SALARY;
	}
	public void setSALARY(Double sALARY) {
		SALARY = sALARY;
	}
}