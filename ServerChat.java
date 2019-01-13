import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat{
	public static void main(String args[]){
		try(ServerSocket server = new ServerSocket(8765)){
			while(true){
			Socket soc = server.accept();

			new ChatAppInput(soc).start();
			new ChatAppOutput(soc).start();
            }
		}catch(IOException e){
         System.out.println("Issue :" + e);
		}
	}
}