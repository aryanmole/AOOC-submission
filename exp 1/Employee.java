import java.util.*;

class emp{
  String fname,lname;
  int salary,ysal;
  double inc,tot;
  
  emp(String f,String l,int s,int y,double i,double t){
    fname=f;
    lname=l;
    salary=s;
    ysal=y;
    inc=i;
    tot=t;
  }
  
  void Ysal(){
    ysal= salary*12;
    System.out.println("Yearly Salary name="+ysal);
  }
  
  void Inc(){
    inc=salary*0.10;
    tot=ysal+salary;
    System.out.println("Incremented Salary="+tot);
  }
  
  void getinfo(){
    Scanner sc=new Scanner(System.in);    
    System.out.println("Enter first name=");
    fname=sc.nextLine();
    System.out.println("Enter last name=");
    lname=sc.nextLine();
    System.out.println("Enter salary=");
    salary=sc.nextInt();
    sc.nextLine();
  }
  void display(){
     System.out.println("first name="+fname);
      System.out.println("last name="+lname);
       System.out.println("Salary name="+salary);
  }
}

class Employee{
public static void main(String[] args){
  emp e=new emp("","",0,0,0,0);
  e.getinfo();
 e.display();
 e.Ysal();
 e.Inc();
}
  
}
