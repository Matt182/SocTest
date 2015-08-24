import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class client {
	
	public static void main(String args[]){
		try{
			Socket me = new Socket("localhost",1234);
			DataInputStream in = new DataInputStream(me.getInputStream());
			DataOutputStream out = new DataOutputStream(me.getOutputStream());
			
			CliHelper msg = new CliHelper(out);
			msg.start();
			System.out.println(in.readUTF());
			String s = in.readUTF();
			while(!s.equals("end")){
				
				if(!s.equals(null)){
					System.out.println(s);
				}
				s = in.readUTF();
			}
			msg.destroy();
			me.close();
		} catch (IOException e) {
			System.out.println("cant connect to server");
			e.printStackTrace();
		}
		System.out.println("==== good by e====");
	}
	
}
