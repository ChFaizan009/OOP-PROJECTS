package WebSite;

public class Area extends Triangle {

	public Area(float l, float w, float h) {
		super(l, w, h);
		
		
		// TODO Auto-generated constructor stub
	}
	public static void getArea()
	{
		
		float Area=Lenght*width;
		System.out.println("The Area of Triangle is : "+ Area);
	}
	

	public static void getParameter()
	{
		
		float Para=Lenght*width*height;
		System.out.println("The Parameter of Triangle is : "+ Para);
	}
	
	public static void main(String [] ar)
	{
		Area ary= new Area(2,4,8);
		getArea();
		getParameter();
		
	}
	
}
