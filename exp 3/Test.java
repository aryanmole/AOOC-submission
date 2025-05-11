import java.util.*;

class Bank{
int balance=400000;
 
 public void getbalance(){
 	System.out.println("Enter balance="+balance);
 }
 
 public void setbalance(){
 	System.out.println("Balance="+balance);
 }
 
  public void display(){
  	System.out.println("Money is deposited");
  }
  
   public void withdraw(){
  	System.out.println("Money is withdrawed");
  }
}

class Saving extends Bank{
	double interest;
	
   public double Interest(){
  	return interest=balance+(balance*0.8);
  }
  
   public void inc(){
  	System.out.println("Interest Money="+interest);
  }
  
}

class Test{
	public static void main(String[] args){
		Saving s=new Saving();
		//s.getbalance();
		s.setbalance();
		s.display();
		s.withdraw();
		s.Interest();
		s.inc();
		
		}
}
