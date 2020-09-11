
public class Book {
	private String Title;
	private String Auther_Name;
	private String Publisher;
	
	public Book(String title, String auther_Name, String publisher )
	{
		Title=title;
		Auther_Name=auther_Name;
		Publisher=publisher;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuther_Name() {
		return Auther_Name;
	}

	public void setAuther_Name(String auther_Name) {
		Auther_Name = auther_Name;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String toString()
	{
		return "Title "+ Title       
				+ "Auther_Name " + Auther_Name +     " Publishers" + Publisher ;
		
	}
	
	
	
}
