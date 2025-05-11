import java.util.*;
import java.io.*;
import java.net.*;

public class tcpserver{
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
			String str;

			do{
				str=dis.readUTF();
				System.out.println("Client says="+str);

				System.out.println("Reply to client");
				str=sc.nextLine();
				dos.writeUTF(str);

								


		}while(!str.equalsIgnoreCase("STOP"));
			s2.close();
			s1.close();

	}catch(Exception e){
		System.out.println("Client error="+e.getMessage());

	}
  }
}