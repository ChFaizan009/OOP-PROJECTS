package Stacks;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        System.out.println("****Your Bucket Is Here ****\n");
        System.out.println("\n------------------------------------------------\n");
        System.out.println("Your Trouli Number is " + s.top*-1);

        System.out.println("                  _");
        System.out.println("                 /    ");
        System.out.println(" ______/   --");
        System.out.println(" |_/_ /_/|     ");
        System.out.println(" |_/_/_/_|     ");
        System.out.println(" |/_/_/__|     ");
        System.out.println("    ___/         ");
        System.out.println("     O   O           ");
        while (choice != 4) {
            System.out.println("\nChose one from the below options...\n");
            System.out.println("\n1.Insert into bucket\n2.Withdraw from bucket\n3.Display The elemnts in Bucket\n4.Exit");
            System.out.println("\n Enter your choice \n");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    s.push(sc);
                    break;
                }
                case 2: {
                    s.pop();
                    break;
                }
                case 3: {
                    s.display();
                    break;
                }
                case 4: {
                    System.out.println("Exiting....");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Please Enter valid choice ");
                }
            }
            ;
        }
    }

}
