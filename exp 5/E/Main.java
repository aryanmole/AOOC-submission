import Ecomerce.Product;
import Ecomerce.Customer;
import Ecomerce.Order;

import java.util.*;

public class Main{
	public static void main(String[] args){
		Product p=new Product(1,2,"ad");
		Customer c=new Customer(1,"ax");
		Order o=new Order(1,2,3);
		
		p.get();
		c.get1();
		o.get2();
		
		System.out.println("---Order Details---");
		p.set();
		c.set1();
		o.set2();
		o.tot();
	}
}
