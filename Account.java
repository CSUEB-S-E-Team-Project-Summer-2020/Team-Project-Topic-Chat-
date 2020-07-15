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
	public String getName() 
	{
		return name;
	}
	
	public void setUserName(String un)
	{
		userName = un; 
	}
	public String getUserName() 
	{
		return userName;
	}	

	public void setPassword(String p)
	{
		password = p; 
	}
	//public String getPassword() {return password;}

	public void setEmail(String e)
	{
		email = e; 
	}
	public String getEmail() 
	{
		return email;
	}
	
}