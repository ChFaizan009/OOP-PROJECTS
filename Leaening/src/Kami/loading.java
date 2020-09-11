package Kami;

public class loading {

	double width;
	double length;
	double height;
	public loading() {
		width=-1;
		length=-1;
		height=-1;
	}
	public loading(double w,double l,double h)
	{
		width=w;
		length=l;
		height=h;
	}
	public loading(double low)
	{
		width=length=height=low;
	}
	
	
	double volume() {
		
		return width * height * length;
		}
	
	public static void main(String [] arys)
	{
		loading obj=new loading();
		loading obj1=new loading(5,10,12);
		loading obj2=new loading(10);
		double vol;
		vol = obj.volume();
		System.out.println("Volume of obj is " + vol);
		// get volume of second box
		vol = obj1.volume();
		System.out.println("Volume of Obj1 is " + vol);
	
		// get volume of cube
		vol = obj2.volume();
		System.out.println("Volume of Obj2 is " + vol);
	
	
	
	}
}
