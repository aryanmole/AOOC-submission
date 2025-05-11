import java.util.*;

class test{
  static int a=10,b;
  
  static{
    System.out.println("Static block called");
    b=a*2;
  }
}

public class Static{
  public static void main(String[] args){
    System.out.println("from main");
    System.out.println("A="+test.a);
    System.out.println("B="+test.b);
  }
}
