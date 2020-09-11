
public class Practice1 {

	int value_1;
	int value_2;
	int add,sub,mul;
	float divd;
	Practice1()
	{
		value_1=45;
		value_2=20;
	
	add=value_1+value_2;
	System.out.println("The Addition of Two Numbers is : " +add);
	sub=value_1-value_2;
	System.out.println("The Subtraction of Two Numbers is : " +sub);
	mul=value_1*value_2;
	System.out.println("The Multiplication of Two Numbers is : " +mul);
	divd=value_1%value_2;
	System.out.println("The Dividend of Two Numbers is : " +divd);
}
}