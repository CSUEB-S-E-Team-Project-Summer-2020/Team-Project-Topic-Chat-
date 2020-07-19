package ChatSysetm;


public class Account 
{
	//variables 
	private String userName, password, securityAnswer; 
	private Status s;
	//private String id; 
	
	//methods

	public void setUserName(String un)
	{
		this.userName = un; 
	}
	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setPassword(String pw)
	{
		this.password = pw; 
		
	}
	
	public String getPassword() {
		
		return password;
	}

	public boolean setSecurityAnswer(String answer)
	{
		this.securityAnswer=answer;
		return true;
		
	}
	
	public String getSecurityAnswer()
	{
		
		return securityAnswer;
	}

}

	
	
	
	


