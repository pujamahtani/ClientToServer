import java.io.IOException;
import java.net.Socket;


public class ClientChat{
	public static void main(String args[]){
		try{
			Socket socket = new Socket("localhost",8765);
			
			new ChatAppInput(socket).start();
			new ChatAppOutput(socket).start();
           
		}catch(IOException e){
         System.out.println("Issue :" + e);
		}catch(Exception e){
			System.out.println("Issue: "+e);
		}
}
			
}
