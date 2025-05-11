package Mathop;

import java.util.*;

public class Round{
	double num;
	
	Scanner sc=new Scanner(System.in);
	
	public Round(double n){
		num=n;	
	}
	
	public void get2(){
		System.out.println("Enter the number=");
		num = sc.nextDouble();
	}
	public void set2(){
		System.out.println("Round is="+Math.round(num));
		
	}
}
