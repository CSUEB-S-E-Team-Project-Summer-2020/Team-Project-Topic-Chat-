package ChatSysetm;

import java.util.ArrayList;


public class AccountHolders {
	private ArrayList<Account> accountList;
	private Account accountObject;
	public AccountHolders()
	{
		accountList=new ArrayList<Account>() ;
		
	}
	
	public boolean verifyUsername(String username)
	{
		//System.out.println("i am here chechking out");
		if(accountList.size()!=0)
		{
		for (Account client:accountList) {
			if((client.getUserName()).equals(username))
			{
				return true ;
			}
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
	
	boolean getStatusofPerson(String username)
{
		if(accountList.size()!=0)
	{
		for (Account client:accountList)
		{
			if((client.getUserName()).equals(username))
			{
				if(client.getStatus().equals("online"))
					return true ;
			}
		}
	}
		return false;
		
}

}




