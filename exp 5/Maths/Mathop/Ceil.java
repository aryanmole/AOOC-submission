package Mathop;
import java.util.*;

public class Ceil{
	double num;
	
	Scanner sc=new Scanner(System.in);
	
	public Ceil(double n){
		num=n;	
	}
	
	public void get1(){
		System.out.println("Enter the number=");
		num=sc.nextDouble();
	}
	public void set1(){
		System.out.println("Ceil is="+Math.ceil(num));
		
	}
}
