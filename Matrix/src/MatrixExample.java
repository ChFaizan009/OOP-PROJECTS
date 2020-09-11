import java.util.Scanner;
public class MatrixExample {

	double[][] mat;
	int row;
	int column;
	MatrixExample()
	{
		row=0;
		column=0;
	}
	
	MatrixExample(int r, int c)
	{
		row=r;
		column=c;
	}
	
	public void get_data()
	{
		int i=0,j=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the matrix elements(row-wise)");
		for( i=0;i<row;i++)
		{
			for(j=0;j<column;j++)
			{
				mat[i][j] = sc.nextDouble();
			}
		}
	}
	
	public void show_data()
	{
		int i = 0, j = 0;
		System.out.println("The matrix is:>>");
		for (i = 0; i < row; i++)
		{
			System.out.println("");
			for (j = 0; j < column; j++)
			{
				System.out.print("   "+mat[i][j]);
			}

		}
	}
	
	
	public MatrixExample add(MatrixExample m1)
	{
		MatrixExample ans = new MatrixExample(row,column);
		int i=0,j=0;
		if (this.row != m1.row || this.column != m1.column)
		{
		System.out.println("ERROR: The two matrices should have same no. of rows and columns for addition!");
		}
		else
		{
			for (i = 0; i < row; i++)
			{
				for (j = 0; j < column; j++)
				{
					ans.mat[i][j] = this.mat[i][j] + m1.mat[i][j];
				}
			}
		}
		return ans;
	}
	
	
	public MatrixExample sub(MatrixExample m1)
	{
		MatrixExample ans= new MatrixExample(row,column);
	int i=0,j=0;
	if(this.row !=m1.row || this.column !=m1.column)
	{
	System.out.println("ERROR: The two matrices should have same no. of rows and columns for addition!");
	}
	else
	{
		for(i=0;i<row;i++)
		{
			for(j=0;j<column;j++)
			{
				ans.mat[i][j] = this.mat[i][j] - m1.mat[i][j];
			}
		}
	}
	return ans;
	}
	
	public static void main(String [] arsy)
	{
		int matrix ,m2,ans;
		int i = 0, j = 0,r=0,c=0;
		Scanner s = new Scanner(System.in);

		//get the no. of rows and columns of the matrix from the user
		System.out.println("Enter no. of rows:");
		r = s.nextInt();
		System.out.println("Enter no. of columns:");
		c = s.nextInt();

		//accept the first matrix
		System.out.println("Enter the first matrix:>>");
		m1 = new MatrixExample(r,c);
		m1.get_data();

		//accept the second matrix
		System.out.println("Enter the second matrix:>>");
		m2 = new MatrixExample(r,c);
		m2.get_data();

		//Add the 2 matrices and print the result
		ans = m1.add(m2);
		System.out.println("\nAddition of the two matrices is:>>");
		ans.show_data();

		//Suntract the 2 matrices and print the result
		ans = m1.sub(m2);
		System.out.println("\nSubtraction of the two matrices is:>>");
		ans.show_data();
	}

}
