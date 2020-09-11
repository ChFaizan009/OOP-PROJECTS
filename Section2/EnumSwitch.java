

public class EnumSwitch {

	  public enum Days {  Mon, Tue, Wed, Thu, Fri, Sat , Sun  }    
      public static void main(String args[])    
      {    
        Days[] DayNow = Days.values();    
          for (Days Now : DayNow)    
          {    
               switch (Now)    
               {    
                   case Mon:    
                       System.out.println("Monday");    
                       break;    
                   case Tue:    
                       System.out.println("Tuesday");    
                       break;         
                   case Wed:    
                       System.out.println("Wednesday");    
                       break;    
                   case Thu:    
                       System.out.println("Thursday");    
                       break;    
                   case Fri:    
                       System.out.println("Friday");    
                       break;    
                   case Sat:    
                       System.out.println("Saturday");    
                    break;

                   case Sun:    
                       System.out.println("Sunday");    
                       break;    
               }    
           }    
       }    	
}
