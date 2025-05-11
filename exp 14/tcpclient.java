import java.util.*;
import java.io.*;
import java.net.*;

public class tcpclient{
	public static void main(String[] args){
		try{
			Socket s1=new Socket("127.0.0.1",1502);

			InputStream is=s1.getInputStream();
			OutputStream os=s1.getOutputStream();

			
			DataInputStream dis=new DataInputStream(is);
			DataOutputStream dos=new DataOutputStream(os);

			Scanner sc=new Scanner(System.in);
			String str;

			do{
				System.out.println("Enter the msg=");
				str=sc.nextLine();
				dos.writeUTF(str);

				System.out.println("Waiting for server");
				str=dis.readUTF();
				System.out.println("Server replied="+str);


		}while(!str.equalsIgnoreCase("STOP"));
			s1.close();
	}catch(Exception e){
		System.out.println("Client error="+e.getMessage());

	}
  }
}