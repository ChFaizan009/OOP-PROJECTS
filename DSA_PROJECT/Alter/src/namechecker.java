import java.util.Scanner;

public class namechecker {// String type

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		chok c = new chok();
		System.out.println("please enter your name : ");
		c.setName(namechecker.validname());
		System.out.println("please enter your father name : ");
		c.setFname(namechecker.validname());
		System.out.println("name  : " + c.getName());
		System.out.println("father name : " + c.getFname());
	}

	public static String validname() {
		String name;
		int space = 0;
		boolean flag;
		do {
			space=0;
			flag = false;
			name = input.nextLine();
			for (int i = 0; i < name.length(); i++) {
				if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')
						|| (name.charAt(i) == ' ' || name.charAt(i) == '-')) {
					if (name.charAt(i) == ' ' || name.charAt(i) == '-') {
						space++;
					}
				} else {
					flag = true;
				}
				if (space == 3) {
					flag = true;
				}
			}
			if (flag == true) {
				System.out.println("Invalid");
				System.out.print("Try Again : ");

			}

		} while (flag == true);
		return name;
	}
}

class chok {
	private String name;
	private String fname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

}

