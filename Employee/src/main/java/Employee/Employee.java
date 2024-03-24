package Employee;
class Employee
{
	int empId;
	String empName;
	double empSalary;
	public Employee(int empId, String empName, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Employee employee=new Employee(101,"mrs.sai",1000);
System.out.println(employee);
	}

}