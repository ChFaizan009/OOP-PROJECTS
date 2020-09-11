

public class Triangle{

		private int l;
		
		private int h;
		Triangle(int x, int y)
		{
			l =x;
			h= y;
			
		}
		void hypot()
		{
			
			 double hypo=Math.hypot(l, h);
			 System.out.println("The length of hypotenuse is: "+hypo);
		}
		void area()
		{
			int area= l*h;
			System.out.println("The area is: "+area);
		}
		public static void main(String [] arus)
		{
			Triangle obj= new Triangle(10,20);
			obj.hypot();
			obj.area();
		}
		
	}

