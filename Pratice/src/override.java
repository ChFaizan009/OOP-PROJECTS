
public class override {

	public void over()

{
	System.out.println("this is class of first override");	
}
	public static class over extends override
	{
		public void over()
		{
		this.over();
		System.out.println("This is second class : ");
		}
		public static void main(String[] arys)
		{
			over ov=new over();
			ov.over();
		}
		}
}
