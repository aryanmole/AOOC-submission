package Ecomerce;

import java.util.*;

public class Customer{

		int cid;
		String name;
		Scanner sc=new Scanner(System.in);
		
		public Customer(int c,String n){
			cid=c;
			
			name=n;
		}
		
		public void get1(){
			System.out.println("Enter customer name=");
			name=sc.nextLine();
			System.out.println("Enter customer id=");
			cid=sc.nextInt();
			
		}
		public void set1(){
			System.out.println("Customer name="+name);
			
			System.out.println("Customer Id="+cid);
			
			
		}
	}
