import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ChatAppOutput extends Thread{
private Socket socket;
	ChatAppOutput(Socket socket){
		this.socket=socket;
	}
	public void run(){
		        BufferedReader br = null;
		try{
           PrintWriter output=new PrintWriter(socket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(System.in));
           //Scanner scanner = new Scanner(System.in);
          
           while(true){
           //System.out.println("type something");
           //String str = scanner.nextLine();
           String str = br.readLine();
           output.println(str);

       }
		}catch(IOException e){
          System.out.println("Issue:" + e);
		}catch(Exception e){
          System.out.println("Issue:" + e);
		}
		finally{
			try{
				socket.close();
			}catch(IOException e){
                System.out.println("Issue :" +e);
			}
		}
	}
}