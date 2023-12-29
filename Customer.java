package collection.Coreproject;

import java.util.Objects;

public class Customer {
 private int customerId;
 private String customerName;
 private String customerEmail;
 private String customerpassword;
 private int age;
 private String phoneNumber;
 private String city;
 private String state;
//-------------------------------------------------------------------------------------------------//
 public Customer(int customerId, String customerName, String customerEmail, String customerpassword, int age,
		String phoneNumber, String city, String state) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerEmail = customerEmail;
	this.customerpassword = customerpassword;
	this.age = age;
	this.phoneNumber = phoneNumber;
	this.city = city;
	this.state = state;
}
 public Customer() {
	 super();
 }

public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerEmail() {
	return customerEmail;
}
public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}
public String getCustomerpassword() {
	return customerpassword;
}
public void setCustomerpassword(String customerpassword) {
	this.customerpassword = customerpassword;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail=" + customerEmail
			+ ", customerpassword=" + customerpassword + ", age=" + age + ", phoneNumber=" + phoneNumber + ", city="
			+ city + ", state=" + state + "]";
}

}
