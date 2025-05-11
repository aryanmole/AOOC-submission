package Ecomerce;

import java.util.*;

public class Order{

		int price,total,quantity;
		
		Scanner sc=new Scanner(System.in);
		
		public Order(int q,int p,int t){
			quantity=q;
			price=p;
			total=t;
		}
		
		public void get2(){
			System.out.println("Enter order quantity=");
			quantity=sc.nextInt();
			System.out.println("Enter product price=");
			price=sc.nextInt();
			
		}
		public void set2(){
			System.out.println("Order quantity="+quantity);
			
			System.out.println("Product price="+price);
			
			
		}
		
		public void tot(){
			total=price*quantity;
			System.out.println("Total Product price="+total);
		}
	}
