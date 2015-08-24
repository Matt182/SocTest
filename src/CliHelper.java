import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CliHelper extends Thread {
	DataOutputStream out;
	
	public CliHelper(DataOutputStream out){
		this.out=out;
	}
	
	public void run(){
		
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		try {

			String mymsg = reader.readLine();
			while(!mymsg.equals("end")){
				if(!mymsg.equals(null)){
					out.writeUTF(mymsg);
					mymsg = reader.readLine();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.stop();
	}
}
