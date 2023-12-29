package collection.Coreproject;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

import Advance.Connectionprovider;

public class CustomerdaoImpl implements CustomerDao{
 Map<Integer, Customer> data=new HashMap<Integer, Customer>();
 private static Customer customer;
 Scanner sc=new Scanner(System.in);
	@Override
	public void saveCustomer(Customer cus) 
	{
		//data.put(cus.getCustomerId(), cus);
		//System.out.println("Enter how much user you want to put :");
		cus=new Customer();
		//int input=sc.nextInt();
		System.out.println("ENTER THE NEW CUSTOMER DATA");
		System.out.println("enter the id");
		cus.setCustomerId(sc.nextInt());
		System.out.println("enter the name :");
		cus.setCustomerName(sc.next());
		System.out.println("Enter the Email of customer");
		cus.setCustomerEmail(sc.next());
		System.out.println("enter the password :");
		cus.setCustomerpassword(sc.next());
		System.out.println("enter age :");
		cus.setAge(sc.nextInt());
		System.out.println("enter the phoneNO");
		cus.setPhoneNumber(sc.next());
		System.out.println("enter city :");
		cus.setCity(sc.next());
		System.out.println("enter state :");
		cus.setState(sc.next());
		data.put(cus.getCustomerId(), cus);
		try {
			Connection con = Connectionprovider.getConnection();
			PreparedStatement statement = con.prepareStatement("select * from customer where id =?");
			statement.setInt(1, cus.getCustomerId());
			ResultSet executequery = statement.executeQuery();
			if (executequery.next()) {
				System.out.println("id already exist use another ID :" + cus.getCustomerId());
			} else {
				String insertdataSql = "INSERT INTO customer(id,name,email,password,age,phone_no,city,state) VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement preparedstatement = con.prepareStatement(insertdataSql);
				preparedstatement.setInt(1, cus.getCustomerId());
				preparedstatement.setString(2, cus.getCustomerName());
				preparedstatement.setString(3, cus.getCustomerEmail());
				preparedstatement.setString(4, cus.getCustomerpassword());
				preparedstatement.setInt(5, cus.getAge());
				preparedstatement.setString(6, cus.getPhoneNumber());
				preparedstatement.setString(7,cus.getCity());
				preparedstatement.setString(8,cus.getState());
				preparedstatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void FindCustomer() 
	{
		try {
		boolean found=false;
		System.out.println("enter the id you want to find");
		int nextInt = sc.nextInt();
		Connection con=Connectionprovider.getConnection();
		String fetchdataSQL="select * from customer where id=?";
	
			PreparedStatement prepStatement=con.prepareStatement(fetchdataSQL);
			prepStatement.setInt(1, nextInt);
			ResultSet rs=prepStatement.executeQuery();
			if(rs.next()) {
				System.out.println("DATA FOUND");
				customer=new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerEmail(rs.getString(3));
				customer.setCustomerpassword(rs.getString(4));
				customer.setAge(rs.getInt(5));
				customer.setPhoneNumber(rs.getString(6));
				customer.setCity(rs.getString(7));
				customer.setState(rs.getString(8));
				System.out.println(customer.toString());
			}else {
				System.out.println("DATA NOT FOUND");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for (Map.Entry<Integer, Customer> str :data.entrySet()) 
//		{
//			if(str.getKey()==nextInt)
//			{
//				System.out.println(str.getKey()+" "+str.getValue());
//			}
//		}
		
	}
	public void Getalldata() 
	{
		try {
			boolean found=false;
		Connection conn=Connectionprovider.getConnection();
		String fetchALL="select * from customer";
		PreparedStatement statement=conn.prepareStatement(fetchALL);
		ResultSet rs=statement.executeQuery();
		found=true;
		while(rs.next()) 
		{
			if(!found) {
				System.out.println("data not found");
			}else {
				System.out.println("data found");
			}
			customer=new Customer();
			customer.setCustomerId(rs.getInt(1));
			customer.setCustomerName(rs.getString(2));
			customer.setCustomerEmail(rs.getString(3));
			customer.setCustomerpassword(rs.getString(4));
			customer.setAge(rs.getInt(5));
			customer.setPhoneNumber(rs.getString(6));
			customer.setCity(rs.getString(7));
			customer.setState(rs.getString(8));
			System.out.println(customer);
		
		}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
//		for (Map.Entry<Integer, Customer> str :data.entrySet()) 
//		{
//				System.out.println(str.getKey()+" "+str.getValue());
//		 }
	}

}
