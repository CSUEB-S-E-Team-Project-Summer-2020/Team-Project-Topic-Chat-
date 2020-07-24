import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;



/**
 * A multithreaded chat room server. When a client connects the server requests
 * a screen name by sending the client the text "SUBMITNAME", and keeps
 * requesting a name until a unique one is received. After a client submits a
 * unique name, the server acknowledges with "NAMEACCEPTED". Then all messages
 * from that client will be broadcast to all other clients that have submitted a
 * unique screen name. The broadcast messages are prefixed with "MESSAGE".
 *
 * This is just a teaching example so it can be enhanced in many ways, e.g.,
 * better logging. Another is to accept a lot of fun commands, like Slack.
 */
public class ServerSide {

    // All client names, so we can check for duplicates upon registration.
    private static ArrayList<Account> accountHolders = new ArrayList<Account>();
    private static Account accountObj=new Account();
    
    // The set of all the print writers for all the clients, used for broadcast.
    private static Set<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running...");
        var pool = Executors.newFixedThreadPool(500);
        try (var listener = new ServerSocket(59001)) {
            while (true) {
                pool.execute(new Handler(listener.accept()));
            }
        }
    }

    /**
     * The client handler task.
     */
    private static class Handler implements Runnable {
        private String username;
        private String password;
        private String inputString;
        private Socket socket;
        private Scanner in;
        private PrintWriter out;

        /**
         * Constructs a handler thread, squirreling away the socket. All the interesting
         * work is done in the run method. Remember the constructor is called from the
         * server's main method, so this has to be as short as possible.
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * Services this thread's client by repeatedly requesting a screen name until a
         * unique one has been submitted, then acknowledges the name and registers the
         * output stream for the client in a global set, then repeatedly gets inputs and
         * broadcasts them.
         */
        public void run() {
            try {
                in = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream(), true);
                accountObj.setUserName("me");
                accountObj.setPassword("me");
                accountHolders.add(accountObj);
                Account tempaccountObj=new Account("you","you");
                
               
                accountHolders.add(tempaccountObj);
                
                // Keep requesting a name until we get a unique one.
                while (true) {
                	  out.println("SUBMITNAME");
                    inputString = in.nextLine();
                    if (inputString == null) {
                        return;
                    }
                    System.out.println(inputString);
                   // System.out.println(password);
                 
                    String[] tokens=StringUtils.split(inputString);
                    this.username=tokens[0];
                    this.password=tokens[1];
                   // System.out.println(password);
                    
                    boolean found=varifyLogin(username, password);
                   if(found==true)
                   {
                
                	 System.out.println("found");
                	 break;  
                   }
                   else {
					out.println("Need a new Account");
				}
                 
                       
                 }
           
                // Now that a successful name has been chosen, add the socket's print writer
                // to the set of all writers so this client can receive broadcast messages.
                // But BEFORE THAT, let everyone else know that the new person has joined!
                out.println("NAMEACCEPTED " + username);
                for (PrintWriter writer : writers) {
       
                    writer.println("MESSAGE " + username + " has joined");
                }
                writers.add(out);

                // Accept messages from this client and broadcast them.
                while (true) {
                    String input = in.nextLine();
                    if (input.toLowerCase().startsWith("/quit")) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + username + ": " + input);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (out != null) {
                    writers.remove(out);
                }
            /*    if (username != null) {
                    System.out.println(username + " is leaving");
                    names.remove(name);
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + " has left");
                    }
                }
                */
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }

		private boolean varifyLogin(String username, String password) {
			 for (Account client:accountHolders) {
				// System.out.println("i am ghere ");
				 System.out.println(client.getPassword() +"and "+ client.getUserName());
				 System.out.println();
	       			if((client.getPassword()).equals(password) && client.getUserName().equals(username))
	       			{
	       				
	       				System.out.println("i am ghere inside if");
	       				return true;
	       				
	       			}
	       		}
	       		return false;
		}
    }
}