package Advance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class CrudDaoImpl implements CrudDao {
	private static Scanner sc = new Scanner(System.in);
	private static Employees employees;

	private static List<Employees> list = new ArrayList<Employees>();

	public void Insert(Employees employees) {
		employees = new Employees();
		System.out.println("--------------------------------");
		System.out.print("enter the empid:-");
		employees.setEmpid(sc.nextInt());
		System.out.print("enter the name :-");
		employees.setName(sc.next());
		System.out.print("enter the salary:-");
		employees.setSalary(sc.nextFloat());
		list.add(employees);

		try {
			Connection con = Connectionprovider.getConnection();
			PreparedStatement statement = con.prepareStatement("select * from crud where id =?");
			statement.setInt(1, employees.getEmpid());
			ResultSet executequery = statement.executeQuery();
			if (executequery.next()) {
				System.out.println("id already exist use another ID :" + employees.getEmpid());
			} else {
				String insertdataSql = "INSERT INTO crud(id,name,salary) VALUES (?,?,?)";
				PreparedStatement preparedstatement = con.prepareStatement(insertdataSql);
				preparedstatement.setInt(1, employees.getEmpid());
				preparedstatement.setString(2, employees.getName());
				preparedstatement.setFloat(3, employees.getSalary());
				preparedstatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Display() {
		System.out.println("--------------------------------");

		try {
			Connection con = Connectionprovider.getConnection();
			String fetch = "select * from crud";
			PreparedStatement statement = con.prepareStatement(fetch);
			ResultSet rs = statement.executeQuery();
		//	ArrayList<Employees> list = new ArrayList<Employees>();
			while (rs.next()) {
				employees = new Employees();	
				employees.setEmpid(rs.getInt(1));
				employees.setName(rs.getString(2));
				employees.setSalary(rs.getFloat(3));
			//	list.add(employees);
				System.out.println(employees);
			//	list.forEach(System.out::println);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Search() {
		System.out.println("-----------------------------------------------");
		try {
			boolean found = false;
			System.out.println("enter the empid to search");
			int empid = sc.nextInt();
			Connection con = Connectionprovider.getConnection();
			String fetch = "select * from crud where id=?";
			PreparedStatement statement = con.prepareStatement(fetch);
			statement.setInt(1, empid);
			ResultSet rs = statement.executeQuery();
			System.out.println("---------------------------------------------");
			if(rs.next()) 
			{
				System.out.println("Data Found");
				employees = new Employees();	
				employees.setEmpid(rs.getInt(1));
				employees.setName(rs.getString(2));
				employees.setSalary(rs.getFloat(3));
				System.out.println("ID = "+employees.getEmpid());
				System.out.println("Name = "+employees.getName());
				System.out.println("Salary = "+employees.getSalary());
			}else 
			{				
				System.out.println("Data not found");
			}
			System.out.println("---------------------------------------------");
		}catch( SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	public void Delete() {
		try {
			boolean found = false;
			System.out.println("enter the empid to search");
			int empid = sc.nextInt();
			Connection con = Connectionprovider.getConnection();
			String fetch = " Delete  from crud where id=?";
			PreparedStatement statement = con.prepareStatement(fetch);
			statement.setInt(1, empid);
			statement.execute();
			found=true;
			if(!found) {
				System.out.println("Record not found ");
			}else {
				System.out.println("Record deleted successfully");
			}
			System.out.println("---------------------------------------------");
		}catch( SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void Update() {
		System.out.println("--------------------------------");
		try {
			  	boolean found = false;
				System.out.println("enter the empid to search");
				int empid = sc.nextInt();
				Connection con = Connectionprovider.getConnection();
				employees=new Employees();
				System.out.println("enter the new name");
				employees.setName(sc.next());
				System.out.println("enter the new salary");
				employees.setSalary(sc.nextFloat());
				employees.setEmpid(empid);
				String insertdataSql = "Update crud set name = ? ,salary = ? where id=?";
				PreparedStatement preparedstatement = con.prepareStatement(insertdataSql);
				preparedstatement.setString(1, employees.getName());
				preparedstatement.setFloat(2, employees.getSalary());
				preparedstatement.setFloat(3, employees.getEmpid());				
				preparedstatement.executeUpdate();
				found = true;
				if(!found) {
					System.out.println("record not found");
				}else 
				{
					System.out.println("Record update successfully");
				}
		}catch( SQLException e)
		{
			e.printStackTrace();
		}
//		ListIterator<Employees> li = list.listIterator();
//		while (li.hasNext())
//			employees = li.next();
//		if (employees.getEmpid() == empid) {
//			System.out.println("enter the new name");
//			String name = sc.next();
//			System.out.println("enter the new salary");
//			float salary = sc.nextFloat();
//			li.set(new Employees());
//			found = true;
//		}
//		System.out.println("--------------------------------");
//		if (!found) {
//			System.out.println("RECORD OF EMPLOYEE NOT FOUND ");
//		} else {
//			System.out.println("RECORD UPDATED SUCCESSFULLY");
//		}
	}

}
