package Advance;

public class Employees
{
	private int empid;
	private String name;
	private float salary;
//	public Employees(int empid,String name,float salary) {
//	
//		this.empid=empid;
//		this.name=name;
//		this.salary=salary;
//	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getName() 
	{
		return name;
	}
	public float getSalary() 
	{
		return salary;
	}
	
	
	@Override
	public String toString() 
	{
	return "Employees [emp_id=" + empid + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
