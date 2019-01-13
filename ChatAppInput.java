import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class ChatAppInput extends Thread{
	private Socket socket;
	ChatAppInput(Socket socket){
		this.socket=socket;
	}
	public void run(){
		try{
          BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          while(true){
          	String in = input.readLine();
          	if(in.equals("exit")){
          		break;
          	}
          	System.out.println("\t\t" + in);
          }
      }catch(IOException e){
      	System.out.println("Issue:" +e);
      }catch(Exception e){
			System.out.println("Issue :" + e);
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