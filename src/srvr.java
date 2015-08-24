import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class srvr {

	public static void main(String[] args) {
		ArrayList<Socket> clients = new ArrayList<>();
		try{	
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("server is online");

			Socket guest = ss.accept();
			System.out.println("someone online");
			DataOutputStream out = new DataOutputStream(guest.getOutputStream());
			DataInputStream in = new DataInputStream(guest.getInputStream());
			clients.add(guest);
			
			out.writeUTF("hello " + guest.getRemoteSocketAddress().toString());
			out.flush();
			
			BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
			
			String s = in.readUTF();
			while(!s.equals("end")){
				if(!s.equals(null)){
					System.out.println(s);
					s = in.readUTF();
				}
			}
			out.writeUTF("end");
			guest.close();
			ss.close();
			
		} catch (IOException e) {
			System.out.println("something wrong with server");
			e.printStackTrace();
		}
		System.out.println("==== good by e====");
	}

}
