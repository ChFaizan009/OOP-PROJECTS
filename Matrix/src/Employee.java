import java.util.Scanner;
public class Employee {
	
        int Id;
        String Name;
        int Age;
        long Salary;

        Employee(int i,String nm,int a,long s)           // Parameterize Constructor
        {
            Id = i;
            Name = nm;
            Age = a;
            Salary = s;
        }

        void PutData()
        {
            System.out.print("\n\tEmployee Id     : "+Id);
            System.out.print("\n\tEmployee Name   : "+Name);
            System.out.print("\n\tEmployee Age    : "+Age);
            System.out.print("\n\tEmployee Salary : "+Salary);
        }

        public static void main(String args[])
        {

            Employee E = new Employee(2,"Sumit",31,35000);
            // Creating object and passing values to constructor.

            E.PutData();          // Calling PutData()

        }
    }


