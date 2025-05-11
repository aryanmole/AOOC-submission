import java.util.*;
import java.io.*;
import java.net.*;

public class tcpserver1{
	public static void main(String[] args){
		try{
			ServerSocket s1=new ServerSocket(1502);
			System.out.println("Port is started waiting for client");

			Socket s2=s1.accept();

			InputStream is=s2.getInputStream();
			OutputStream os=s2.getOutputStream();

			
			DataInputStream dis=new DataInputStream(is);
			DataOutputStream dos=new DataOutputStream(os);

			Scanner sc=new Scanner(System.in);
			int a,b,sum;
			String choice;

			do{
				a=dis.readInt();
				b=dis.readInt();

				System.out.println("Client says="+a+" "+b);

				System.out.println("Reply to client");
				sum=a+b;
				System.out.println("Sending Sum"+sum);

				
				dos.writeInt(sum);

			choice = dis.readUTF();

		}while(!choice.equalsIgnoreCase("STOP"));
			s2.close();
			s1.close();

	}catch(Exception e){
		System.out.println("Client error="+e.getMessage());

	}
  }
}