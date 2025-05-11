package Library;

import java.util.*;
public class Book{
	String title,author,isbn;
	Scanner sc=new Scanner(System.in);
	
	public Book(String t,String a,String i){
		title=t;
		author=a;
		isbn=i;
	}
	
	public void get(){
		System.out.println("Enter Title=");
		title=sc.nextLine();
		System.out.println("Enter author=");
		author=sc.nextLine();
		System.out.println("Enter isbn=");
		isbn=sc.nextLine();
	}
	public void set(){
		System.out.println("Title="+title);
		
		System.out.println("author="+author);
		
		System.out.println("isbn="+isbn);
		
	}
}

