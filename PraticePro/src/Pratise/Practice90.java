package Pratise;


public class Practice90
{

	String Name;
	int R_No;
	Adress addr;
public Practice90(String n,int r, Adress adrr)
{
	this.Name=n;
	this.R_No=r;
	this.addr=addr;
}

void display(){  
System.out.println(R_No+" "+Name);  
System.out.println(addr.Country_Name+" "+addr.State_Name+" "+addr.District_Name);  
}  

public static void main(String [] ary)
{
	Adress ob= new Adress("Pakistan", "Pakistani","Gujrat");
	Practice90 obj= new Practice90("Faizan", 9,ob);
	 obj.display();
}





}
