import java.util.*;

public class Static1{
	static int age;
	static String name;
	
	static void disp(){
		  System.out.println("Name="+name);
		    System.out.println("Age="+age);
	}
 public static void main(String[] args){
   age=19;
   name="Aryan";
   disp();
 }
}
