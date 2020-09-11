
	


class Movie()
{
	String title;
	String rating;
	double cost;
	int numOfAward;
	static int numMovies;
	static double minCost = 1.5;
	
	static 
	{
		System.out.println("Static Block ");
		minCost=1;
		}
	Movie (String ntitle)
	{
		numMovies++;
		title=ntitle;
	}
	String getTitle()
	{
		return title;
	}
	void printDetail()
	{
		System.out.println("The Tiltle Of 	Movies is :  " +title);
		System.out.println("The Rating Of 	Movies is :  " +rating);
		
	}
	void setDetail(String ntitle,String nrating,double ncost )
	
	{
	title=ntitle;
	rating=nrating;
	cost=ncost;
	}
	static void printTotalMovies()
	{
		System.out.println("The Total Number  Of 	Movies is :  " +Movie.numMovies);
	}
	public static void main (String [] arys)
	{
		Movie m1= new Movie("Throne");
		Movie m= new Movie("Indian");
		Movie.printTotalMovies();
		String t=m1.getTitle();
		System.out.println("Title of m1 is "
				+ "");
	
	}
}