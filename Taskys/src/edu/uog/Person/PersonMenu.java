package edu.uog.Person;
import java.util.List;
import java.util.Scanner;


public class PersonMenu {

	@SuppressWarnings("unchecked")
	public static void Menu() {
	
	Scanner sc=new Scanner(System.in);
	int choice=-1;
	choice=-1;
	
	while(choice!=10)
	{
		System.out.println("=====================================================");
		System.out.println("Persons Menu");
		System.out.println("=====================================================");
		System.out.println("1.   Insert The Persons Data");
		System.out.println("2.   Delete The Persons Data");
		System.out.println("3.   Show The Persons Data");
		System.out.println("4.   Search The Persons Data");
		
		System.out.println("10.   Back");
		System.out.print("Enter Your Choice [1-10]: ");
		choice = sc.nextInt();

		switch(choice)

		{
		case 1:
			System.out.println("---------------------------------");
			System.out.println("Add New Person Data");
			System.out.println("---------------------------------");
			Person person = new Person();
			
			System.out.println("Enter Id of Person :");
			int id=sc.nextInt();
			
			person.setPERSON_ID(id);
			
			System.out.println("Enter TITLE of Person :");
			String title=sc.nextLine();
			title+=sc.nextLine();
			person.setTITLE(title);
			
			System.out.println("Enter FORE_NAME of Person : ");
			String f_Name=sc.nextLine();
			f_Name+=sc.nextLine();
			person.setFORE_NAME(f_Name);
			
			System.out.println("Enter SUR_NAME of Person : ");
			String S_Name=sc.nextLine();
			
			person.setSUR_NAME(S_Name);
			
			System.out.println("Enter Age of Person : ");
			int age=sc.nextInt();
			
			person.setAGE(age);
			
			System.out.println("Enter Gender of Person : ");
			String gender=sc.nextLine();
			gender+=sc.nextLine();
			person.setGENDER(gender);
			
			
			System.out.println("Enter Address of Person : ");
			String adress=sc.nextLine();
			person.setADDRESS(adress);
			
			
			person = personData.Save(person);
			System.out.println(person.toString());
			System.out.println("---------------------------------");
			break;
			
			
		case 2:
			System.out.println("---------------------------------");
			System.out.println("Delete person");
			System.out.println("---------------------------------");
			System.out.println("Enter person ID: ");
			int person_ID=sc.nextInt();
			Person persondelete = personData.deleteOne1(person_ID);
			System.out.println(persondelete.toString());
			System.out.println("---------------------------------");
			break;
			
			case 3:
				
				System.out.println("---------------------------------");
				System.out.println("Show All Person Data");
				System.out.println("---------------------------------");
				
				List<Person> Person=personData.findAll();
				for(int i=0;i<Person.size();i++)
				{
					System.out.println(Person.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
				
			case 4 :
				System.out.println("---------------------------------");
				System.out.println("Search Persons Data");
				System.out.println("---------------------------------");
                System.out.println("Enter Person Search");
                String Search=sc.nextLine();
                List<Person> search=personData.search(Search);
                
                for (int j=0; j<search.size(); j++) {
					System.out.println(search.get(j).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println(" Delete All records of Persons");
				String del=personData.DeleteAll();
				System.out.println(del);
				break;
			case 6:
		
				Scanner finone=new Scanner(System.in);
				System.out.println("Enter Person ID to find:-");
				int input=finone.nextInt();
			System.out.println("\n______Found the Matching ID  record in row___________\n");
		    Person=(List<edu.uog.Person.Person>) personData.findOne(input);
			System.out.println(Person.toString());
			
			break;
				
		
			case 10:
				break;
		
		}
		
	}
}}
