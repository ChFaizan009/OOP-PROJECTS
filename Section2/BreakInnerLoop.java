

public class BreakInnerLoop {

	public static void main(String[] args) {  
           
        for(int j=1;j<=3;j++){    
                 
                for(int k=1;k<=3;k++){    
                    if(j==2&&k==2){    
                        
                        break;    
                    }    
                    System.out.println(j+" "+k);    
                }    
        }    
}  
}
