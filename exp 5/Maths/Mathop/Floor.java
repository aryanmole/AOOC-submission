package Mathop;

import java.util.*;

public class Floor{
	double num;
	
	Scanner sc=new Scanner(System.in);
	
	public Floor(double n){
		num=n;	
	}
	
	public void get(){
		System.out.println("Enter the number=");
		num = sc.nextDouble();

	}
	public void set(){
		System.out.println("Floor is="+Math.floor(num));
		
	}
}
