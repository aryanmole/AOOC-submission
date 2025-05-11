import java.util.*;

class Rect{
   double length;
   double width;
   
   void input(){
     Scanner scanner = new Scanner(System.in);
     
     System.out.println("Enter length and width=");
     length=scanner.nextDouble();
     width=scanner.nextDouble();
   }
   
   
   double area(){
      return length*width;   
}
  double perimeter(){
      return 2*(length+width);   
}
}

public class Rectangle{
  public static void main(String[] args){
   Rect ob=new Rect();
   ob.input();
   double area = ob.area();  
        double perimeter = ob.perimeter();  
        
        System.out.println("Area = " + area);
        System.out.println("Perimeter = " + perimeter);
}
}

