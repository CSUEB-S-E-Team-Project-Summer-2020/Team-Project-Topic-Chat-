package SomethingNew;


import java.io.PrintWriter;

public class Account
{

private String userName, password, securityAnswer;
private String status;
private String[] friendList;
private int friendCount;
private PrintWriter writer;

public Account()
{
this.userName="";
this.password="";
friendList=new String[50];
this.securityAnswer="";
this.status="";
friendCount=0;
this.writer=null;
}
public Account(String username, String password)
{
setUserName(username);
setPassword(password);
}
public void setUserName(String username)
{
this.userName = username;
}

public void setPassword(String password)
{
this.password = password;
}
public void setSecurityAnswer(String answer)
{
this.securityAnswer=answer;

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

public String getUserName()
{
return userName;
}
public String getPassword() {
return password;
}
public String getSecurityAnswer()
{
return securityAnswer;
}
public String getStatus()
{
return status;
}
//public addFriend(String )
public void setWriter(PrintWriter out)
{
this.writer=out;

}
public PrintWriter getWriter() {
return writer;
}
public void addFriend(String friendUsername)
{
System.out.println("I am adding friend: " +friendUsername);
friendList[friendCount]=friendUsername;
friendCount++;
}
public String[] getFriendList()
{

return friendList;
}


}