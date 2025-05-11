package Library;

import java.util.*;

public class Member{
	String name,book;
	int id;
	Scanner sc=new Scanner(System.in);
	
	public Member(String n,String b,int i){
		name=n;
		book=b;
		id=i;
	}
	
	public void gett(){
		System.out.println("Enter Name=");
		name=sc.nextLine();
		System.out.println("Enter Book borrowed=");
		book=sc.nextLine();
		System.out.println("Enter id=");
		id=sc.nextInt();
	}
	public void sett(){
		System.out.println("Name="+name);
		
		System.out.println("Book borrowed="+book);
		
		System.out.println("ID="+id);
		
	}
}

