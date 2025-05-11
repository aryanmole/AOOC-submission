import java.util.*;

public class Static{
	static int a=10;
	static int b;
	
	static{
		 b=a*4;
	}
 public static void main(String[] args){
    System.out.println("Elements in a="+a);
    System.out.println("Elements in b="+b);
 }
}
