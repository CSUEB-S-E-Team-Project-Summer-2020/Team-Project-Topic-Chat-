
import.
public class Account 
{
	//variables 
	private String name, userName, password, email, securityAnswer; 
	//private String id; 
	
	//methods
	
	public void setName(String n)
	{
		name = n; 
	}
	public String getName() {return name;}
	
	
	public void setUserName(String un)
	{
		userName = un; 
	}
	public String getName() {return userName;}
	
	
	public void setPassword(String p)
	{
		password = p; 
	}
	//public String getPassword() {return password;}

	
	public void setEmail(String e)
	{
		email = e; 
	}
	public String getEmail() {return email;}
	
	
	public boolean verfiyEmail(String e)
	{
	    if (email == e)
	//	if(getEmail() == e)
		{
			return true;
		}
		else 
		{
			System.out.println("Invalid email!");
		}
		
	}
	
	
	public boolean checkUserName(String checkUName)
	{
		if(userName == checkUName)
		{
			return true; 
		}
		
		else 
		{
			System.out.println("Invalid username"); 
		}
		
	}
	
	

	public boolean checkPassword(String checkPass)
	{
		if(password == checkPass)
		{
			return true; 
		}
		
		else 
		{
			System.out.println("Invalid password"); 
			//ask in menu user if they want to reset their password and then call the reset method 
			/* ask if want to set 
			 resetPassword() 
			 
		     else
			 give them another 3 chances to enter it in then block their acc send an email 
			 */
			
		}
		
	}
	
	
	public boolean resetPassword(String newPass)
	{
		System.out.println("Reset password");
		
		//delete the old password in the server and replace it with the new one 
		setPassword(String newPass); 
			
		
	}
	
}







