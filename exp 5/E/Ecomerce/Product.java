package Ecomerce;

import java.util.*;

public class Product{

		int id,price;
		String name;
		Scanner sc=new Scanner(System.in);
		
		public Product(int i,int p,String n){
			id=i;
			price=p;
			name=n;
		}
		
		public void get(){
			System.out.println("Enter name=");
			name=sc.nextLine();
			System.out.println("Enter id=");
			id=sc.nextInt();
			System.out.println("Enter price=");
			price=sc.nextInt();
		}
		public void set(){
			System.out.println("Name="+name);
			
			System.out.println("Id="+id);
			
			System.out.println("Price="+price);
			
		}
	}

