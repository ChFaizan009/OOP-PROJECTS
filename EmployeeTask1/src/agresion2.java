
public class agresion2 {

	  
		int id;  
		String name;  
		agresion1 address;  
		  
		public agresion2(int id, String name,agresion1 address) {  
		    this.id = id;  
		    this.name = name;  
		    this.address=address;  
		}  
		  
		void display(){  
		System.out.println(id+" "+name);  
		System.out.println(address.city+" "+address.state+" "+address.country);  
		}  
		  
		public static void main(String[] args) {  
		agresion1 address1=new agresion1("gzb","UP","india");  
		agresion1 address2=new agresion1("gno","UP","india");  
		  
		agresion2 e=new agresion2(111,"varun",address1);  
		agresion2 e2=new agresion2(112,"arun",address2);  
		      
		e.display();  
		e2.display();  
/* System.out.println(obj.rollNum);
       System.out.println(obj.studentName);
       System.out.println(obj.studentAddr.streetNum);
       System.out.println(obj.studentAddr.city);
       System.out.println(obj.studentAddr.state);
       System.out.println(obj.studentAddr.country);*/		      
		}  
		}  

