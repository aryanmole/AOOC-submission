import java.util.*;

abstract class Shape{
 abstract void calculatearea();
}

class Circle extends Shape{
	double r=5,a;
	
   public double calculate(){
  	return a=3.14*r*r;
  }
   public void calculatearea(){
  	System.out.println("Area="+a);
  }
  
}

class Test1{
	public static void main(String[] args){
		Circle c=new Circle();
		c.calculate();
		c.calculatearea();
		
		}
}
