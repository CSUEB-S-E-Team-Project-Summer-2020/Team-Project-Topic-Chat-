

import java.util.ArrayList;


public class AccountHolders {
	private ArrayList<Account> accountList=new ArrayList<>();
	private Account accountObject;
	public boolean verifyUsername(String username)
	{
		for (Account client:accountList) {
			if((client.getUserName()).equals(username))
			{
				return true ;
			}
		}
		return false;
		
	}
	
	public boolean verifyPassword(String checkPass)
	{
		for (Account client:accountList) {
			if((client.getPassword()).equals(checkPass))
			{
				return true ;
			}
		}
		return false;
	}
	
	public boolean addUsers(String username,String password,String securityAnswer)
	{
		accountObject.setUserName(username);
		accountObject.setPassword(password);
		accountObject.setSecurityAnswer(securityAnswer);
		accountList.add(accountObject);
		return true;//will notify that user added in the account list
	}	
	
	public void changeStatus(String status)
	{
		if(status.equals("online")) {
			accountObject.setStatusOnline();
		}
		else if(status.equals("blocked")) {
			accountObject.setStatusBlocked();
		}
		else
		{
			accountObject.setStatusOffline();
		}
	
	}


	public boolean resetPassword(String newPass)
	{
		
		accountObject.setPassword(newPass);
		
		return true;
		
	}
	
	
	
	
	
	
	

}


