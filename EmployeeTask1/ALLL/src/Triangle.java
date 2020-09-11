
public class Triangle {
	  int a,b,c;
	  Triangle()
	  {
	  a=2;
	  b=5;
	  c=6;
	  }
	  public double getArea(){
	    double s = (a+b+c)/2.0;
	    return Math.pow((s*(s-a)*(s-b)*(s-c)),.5);
	  }
	  public double getPerimeter(){
	    return (a+b+c)/2.0;
	  }
	

	
	  public static void main(String[] args){
	    Triangle t = new Triangle();
	    System.out.println(t.getArea());
	    System.out.println(t.getPerimeter());
	  }
	}								


