
public class BankAgression1 {

	String Off_Name;
	String off_Card;
	int Rank;
	BankAgression agrs;
	public BankAgression1(String name, String card, int rank, BankAgression agrs) {
		super();
		Off_Name = name;
		this.off_Card = card;
		Rank = rank;
		this.agrs = agrs;
	}
	void disp()
	{
	System.out.println("The Name is : "+Off_Name+" The Card is : "+off_Card);
	System.out.println("The Rank is : "+Rank+" The City is : "+agrs.City);
	System.out.println("The State is : "+agrs.State+" The Street is : "+agrs.Street);
	}


	public static void main(String[] args) {
	BankAgression ob=new BankAgression("Gujrat","Pakistan","Strret1");
	BankAgression1 obj=new BankAgression1("Faizan","45784",17,ob);
	obj.disp();

	}

}
