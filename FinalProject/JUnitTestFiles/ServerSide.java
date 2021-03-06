package TestSuiteChatClientSide;
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



public class ServerSide {

    private static ArrayList<Account> accountHolders = new ArrayList<Account>();
  //  private static Set<PrintWriter> writers = new HashSet<>();
    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running...");
        var pool = Executors.newFixedThreadPool(500);
        try (var listener = new ServerSocket(59001)) {
            while (true) {
                pool.execute(new Handler(listener.accept()));
            }
        }
    }


    private static class Handler implements Runnable {
        private String username;
        private String password;
        private String sAnswer;
        private String userloginStatus;
        private String inputString;
        private Socket socket;
        private Scanner in;
        
       // private boolean isNeedAccount=false;
        private PrintWriter out;
        
    
        public Handler(Socket socket) {
            this.socket = socket;
            
        }

        public void run() {
            try {
                this.in = new Scanner(socket.getInputStream());
                
                this.out = new PrintWriter(socket.getOutputStream(), true);
                out.println("SUBMITTED");
               
               Account accountObjAccount=new Account();
               accountObjAccount.setUserName("me");
               accountObjAccount.setPassword("me");
               accountHolders.add(accountObjAccount);
               Account tempaccountObj=new Account("you","you");
               accountHolders.add(tempaccountObj);
                
                
                // Keep requesting a name until we get a unique one.
                while (true) {
                	
                	
                	 
                    inputString = in.nextLine();
                    if (inputString == null) {
                        return;
                    }
                    System.out.println(inputString);
                   
                    //this.userloginStatus=tokens[0];
                   
                    if(inputString.startsWith("login"))
                    {
                    	 String[] tokens=StringUtils.split(inputString);
                    	 this.username=tokens[1];
                         this.password=tokens[2];
                         boolean verifyUsername=verifyUsername(username);
                         boolean verifyPassword=verifyPassword(password);
                         if(verifyUsername==false)
                         {
                        	 out.println("NEWACCOUNT");
                        	 
                        	 
                         }
                         if(verifyUsername==true)
                         {
                        	 if(verifyPassword==false)
                        	 {
                        		 out.println("WRONGPASSWORD");
                        	 }
                        	 
                         }
                        
                    	if(verifyPassword==true && verifyUsername==true) {
                    		
                    		 
                    		doLogin(username, password);
                    		break;
						}
                    
                    }
                   if(inputString.startsWith("newA"))
                    {
                	   boolean verifiyer;
                	   String[] tokens=StringUtils.split(inputString);
                    	this.username=tokens[1];
                        this.password=tokens[2];
                    	this.sAnswer=tokens[3];
                    	System.out.println("I am new accout");
                    	verifiyer=createAccount(username, password, sAnswer);
                    	if(verifiyer==true)
                    	{
                    		verifiyer=doLogin(username, password);
                    		if(verifiyer==true)
                    		{
                    			break;
                    			
                    			
                    		}
                    		
                    	}	
                    }
                }	
                    
                out.println("NAMEACCEPTED " + username);
                while (true) {
                    String input = in.nextLine();
                    if (input.toLowerCase().startsWith("logout")) {
                    	dologout();
                        return;
                    }
                    if(input.startsWith("msg"))
                    {
                    	
                    	String[] tokens=StringUtils.split(input,null,3);
                      	String 	fusername=tokens[1];
                      	String msgString=tokens[2];
                      	System.out.print(fusername);
                    	 for (Account client : accountHolders) {
                    		 if(client.getUserName().equals(fusername))
                    		 {
                    			 out.println("MESSAGE " + username + ": " + msgString);
                    			 client.getWriter().println("MESSAGE " + username + ": " + msgString);  			
                    		 } 
                         }
                    }
                    
                    if(input.startsWith("add"))
					{
                    	boolean varifyer=false;
                    	 String[] tokens=StringUtils.split(input,null,2);
                     	String 	fusername=tokens[1];
                     	varifyer=addFrindtoaccount(fusername);
                     	
					}
                   
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (out != null) {
                	 for (Account client : accountHolders) {
                		 if(client.getUserName().equals(username))
                		 {
                			 client.setStatusOffline();		
                		 } 
                     }
                    
                }
  
               
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }

		private void dologout() {
			
			 for (Account client : accountHolders) {
        		 if(client.getUserName().equals(username) && client.getPassword().equals(password))
        		 {
        			 
        			 client.setStatusOffline();  			
        		 } 
             }
		}

		private boolean addFrindtoaccount(String fusername) {
			
			for (Account client:accountHolders) {
				
	       			if( client.getUserName().equals(username))
	       			{
	       				client.addFriend(fusername);
	       				System.out.println(client.getStatus());
	       				return true;
	       				
	       			}
	       		}
	       		return false;
		}

		private boolean createAccount(String username, String password, String sAnswer) {
			
			Account newAccount=new Account();
			newAccount.setUserName(username);
			newAccount.setPassword(password);
			newAccount.setSecurityAnswer(sAnswer);
			newAccount.setWriter(out);
			newAccount.setStatusOnline();
			accountHolders.add(newAccount);
			System.out.println("The new Account has been Created for the User: "+username);
			return true;
			
		}
		//THIS METHOD WILL VERIFY THE USERNAME		
		private boolean verifyUsername(String username) {
			 for (Account client:accountHolders) {
	       			if(client.getUserName().equals(username))
	       			{
	       				
	       				return true;
	       				
	       			}
	       		}
	       		return false;
		}
    
    
    	//THIS METHOD WILL VERIFY THE PASSWORD
    	private boolean verifyPassword(String password) {
		 for (Account client:accountHolders) {
			
      			if((client.getPassword()).equals(password))
      			{
      				return true;
      			}
      		}
      		return false;
	}
    //THIS METHOD WILL DO LOGIN
    private boolean doLogin(String username, String password) {
		 for (Account client:accountHolders) {
		
      			if((client.getPassword()).equals(password) && client.getUserName().equals(username))
      			{
      				client.setStatusOnline();
      				System.out.println(username+"is logedin with the Status"+client.getStatus());
      				
      				return true;
      				
      			}
      		}
      		return false;
	}
  
}
}