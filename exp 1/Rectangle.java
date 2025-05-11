import java.util.*;

class Area{
  double length,width,area;
  
  Area(double l,double w,double a){
    length=l;
    width=w;
    area=a;
  }
  void setDim(){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter length=");
    length=sc.nextDouble();
    System.out.println("Enter width=");
    width=sc.nextDouble();
  }
  void getArea(){
    area=length*width;
    System.out.println("Area of rectangle="+area);
  }
}

public class Rectangle{
 public static void main(String[] args){
    Area a=new Area(0.0,0.0,0.0);
    a.setDim();
    a.getArea();
  }
}
