package Advance;

import java.util.Scanner;
public class CrudController {
	private static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) 
	{
		CrudDao cd=new CrudDaoImpl();
		Employees employees= new Employees();
		int button;
		do 
		{
			System.out.println("WELCOME TO CRUD OPERATION");
			System.out.println("ENTER 1 INSERT");
			System.out.println("ENTER 2 DISPLAY");
			System.out.println("ENTER 3 SEARCH");
			System.out.println("ENTER 4 DELETE");
			System.out.println("ENTER 5 UPDATE");
			System.out.println("ENTER 0 to EXIT");
			System.out.println("ENTER YOUR CHOICE:-");
			button=sc.nextInt();
			switch(button) 
			{
			case 1:
				cd.Insert(employees);
				break;
			case 2:
				cd.Display();
				break;
			case 3:
				cd.Search();
				break;
			case 4:
				cd.Delete();
				break;
			case 5:
				cd.Update();
				break;
			}
		}while(button!=0);

	}
	
}
