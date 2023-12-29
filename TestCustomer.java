package collection.Coreproject;
import java.util.Scanner;
public class TestCustomer 
{
	private static Scanner sc=new Scanner(System.in);
	private static Customer cus=new Customer();
	private static CustomerDao cusdao=new CustomerdaoImpl();
	public static void main(String[] args)
	{
		Customer cus=new Customer();
		int button;
		TestCustomer tc=new TestCustomer();
		System.out.println("SELECT BUTTON :");
		do 
		{
			System.out.println("Press 1 to create customer");
			System.out.println("Press 2 to find customer");
			System.out.println("Press 3 to get all customer data");
			System.out.println("Press 0 to EXIT ");
		 button=sc.nextInt();
		 switch(button) 
		 	{
			case 1:
			cusdao.saveCustomer(cus);
			break;
			case 2:
			cusdao.FindCustomer();
			break;
			case 3:
			cusdao.Getalldata();
			break;
		 	}
		}while(button!=0);
	}
	  
	
}
