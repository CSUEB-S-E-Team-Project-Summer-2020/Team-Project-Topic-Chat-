package ChatSysetm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverAcceptConnections extends Thread {

    private final int serverPort;

    public SeverAcceptConnections(int serverPort) {
        this.serverPort = serverPort;
    }

    //creating multi Thread
    @Override
    public void run() {
    	
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);
			while(true) {
        		System.out.println("Accepting the connections now.....");
        		Socket clientSocket = serverSocket.accept();
        		System.out.println("Accepted connection from " + clientSocket);
        		ServerSideClientMenu client=new ServerSideClientMenu(this, clientSocket);
        		client.start();
		} 
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    

    }
}