import java.util.*;
import java.io.*;
import java.net.*;

public class tcpclient1{
	public static void main(String[] args){
		try{
			Socket s1=new Socket("127.0.0.1",1502);

			InputStream is=s1.getInputStream();
			OutputStream os=s1.getOutputStream();

			
			DataInputStream dis=new DataInputStream(is);
			DataOutputStream dos=new DataOutputStream(os);

			Scanner sc=new Scanner(System.in);
			int a,b,sum;
			String choice;

			do{
				System.out.println("Enter two number=");
				a=sc.nextInt();
				b=sc.nextInt();
				sc.nextLine();

				dos.writeInt(a);
				dos.writeInt(b);

				System.out.println("Waiting for server");
				sum=dis.readInt();
				System.out.println("Server replied="+sum);
				  

				System.out.print("Do you want to continue? (yes/STOP): ");
                choice = sc.nextLine();
                dos.writeUTF(choice);


		}while(!choice.equalsIgnoreCase("STOP"));
			s1.close();
	}catch(Exception e){
		System.out.println("Client error="+e.getMessage());

	}
  }
}