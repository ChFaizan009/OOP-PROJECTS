package hospitalsystem;


import java.util.Scanner;



public class inttypechecker {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		chokk c = new chokk();
		System.out.println("please enter your rate : ");
		c.setName((int) inttypechecker.validname());
		System.out.println("please enter your father rate : ");
		c.setFname((int)inttypechecker.validname());
		System.out.println("name  : " + c.getName());
		System.out.println("father name : " + c.getFname());
	}

	public static double validname() {
		double n = 0;
		boolean flag = true;
		do {
			try {
				flag = false;
				n = input.nextDouble();

			} catch (Exception e) {
				flag = true;
				System.out.println("YOU CANNOT DO IT BRO...!   TRY AGAIN");
				input.nextLine();
			}
		} while (flag == true);

		return n;
	}
}

class chokk {
	private int name;
	private double fname;

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public double getFname() {
		return fname;
	}

	public void setFname(double fname) {
		this.fname = fname;
	}

}
