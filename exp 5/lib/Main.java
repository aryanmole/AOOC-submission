import Library.Book;
import Library.Member;

public class Main{
	public static void main(String[] args){
		Book b=new Book("ar","ya","es");
			Member m=new Member("er","yaw",1);
		b.get();
	
		m.gett();
		
		System.out.println("\n--- Book Details ---");
    b.set();

    System.out.println("\n--- Member Details ---");
    m.sett();

	}
}

