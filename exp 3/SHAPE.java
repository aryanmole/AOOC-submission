import java.util.*;

interface Shape{
	public void area();
}

class Circle implements Shape{
	double r=5,a;
	
	public double cir(){
		return a=3.14*r*r;
	}
	public void area(){
			System.out.println("Area of circle is="+a);
		}
}

class Rectangle implements Shape{
	double l=4,b=5,a;
	
	public double rec(){
		return a=l*b;
	}
		public void area(){
			System.out.println("Area of rectangle is="+a);
		}
}

class SHAPE{
	public static void main(String[] args){
		Circle c=new Circle();
		c.cir();
		c.area();
		Rectangle r=new Rectangle();
		r.rec();
		r.area();
	}
}
