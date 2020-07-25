package ChatSysetm;


public class Account
{
//variables
private String userName, password, securityAnswer;
private String status;
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
public void setStatusOnline() {

this.status="online";
}
public void setStatusOffline() {

this.status="offline";
}
public void setStatusBlocked() {

this.status="blocked";
}
public String getStatus()
{

return status;

}

}


