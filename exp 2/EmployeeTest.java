import java.util.*;

class Employee{
	double sal;
	String fname,lname;
	Scanner sc=new Scanner(System.in);
	
	public Employee(double s,String f,String l){
		sal=s;
		fname=f;
		lname=l;
	}
	
	public void get(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the first name=");
		fname=sc.nextLine();
		System.out.println("Enter the last name=");
		lname=sc.nextLine();
		System.out.println("Enter the salary=");
		sal=sc.nextDouble();
	}
	
	
		public void set(){
		System.out.println("First name="+fname);
		System.out.println("Last name="+lname);
		System.out.println("Salary="+sal);
	}
	
	public void set1(){
		if(sal>0){
		  System.out.println("Salary="+sal);
		}else{
	  	sal=0;
		  System.out.println("Salary="+sal);
		}
	}

  public void inc(){
      sal=sal+(sal*0.10);
       System.out.println("Incremented Salary="+sal);
  }

}

class EmployeeTest{
	public static void main(String[] args){
		Employee e=new Employee(50000, "fname"," lname");
		e.get();
		e.set();
		e.set1();
		e.inc();
	}
}

