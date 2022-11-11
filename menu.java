import java.io.*;
import java.util.*; 
import java.io.*;
import java.lang.String;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.sql.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class menu
{
public static void main(String args[]) throws IOException
{
DataInputStream obj=new DataInputStream(System.in);
int choice=0;

System.out.println("Menu");
System.out.println("1. Register");
System.out.println("2. Login");
System.out.println("3. Forgot Password");
System.out.println("Enter your Choice :");
choice=Integer.parseInt(obj.readLine());
switch(choice)
{
case 1: reg x=new reg();
            x.register();
            break;
case 2: 
log x1=new log();
            x1.login();
            break;
case 3: forg x2=new forg();
            x2.forgot();
            break;
}
}
}
class reg
{
void register()
{
Scanner sc= new Scanner(System.in);
String fname,email,un,pw,contact;

System.out.println("Enter Fullname");
fname=sc.nextLine();  
System.out.println("Enter Email");
email=sc.nextLine(); 
System.out.println("Enter Contact");
contact=sc.nextLine(); 
System.out.println("Enter Username");
un=sc.nextLine(); 
System.out.println("Enter Password");
pw=sc.nextLine(); 

 

 try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3307/tweet","root","root");  

Statement stmt=con.createStatement();  
String sql="insert into register values('" + fname + "','" + email + "','" + contact + "','" + un + "','" + pw + "')";
stmt.executeUpdate(sql);


    
      System.out.println("Record saved successfully");
con.close();  
}catch(Exception e){ System.out.println(e);}  


}
}

class log
{
void login()
{
Scanner sc= new Scanner(System.in);
try
{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3307/tweet","root","root");  

String un1="-",pw1="-",un,pw;
System.out.println("Enter Username");
un=sc.nextLine(); 
System.out.println("Enter Password");
pw=sc.nextLine(); 
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from register");  
while(rs.next())  
{
un1=rs.getString(4);
pw1=rs.getString(5);  
}

if ((un.equals(un1)) && (pw.equals(pw1)))
{
System.out.println("Login Successfull");

System.out.println("*************************");
System.out.println("Menu");
System.out.println("*************************");
System.out.println("1. Post Tweet");
System.out.println("2. View My Tweets");
System.out.println("3. View All Users");
System.out.println("4. View All Tweets");
System.out.println("5. Reset Password");
System.out.println("6. Logout");

String choice1="-";
Scanner sc1= new Scanner(System.in);
System.out.println("Enter your Choice :");
choice1=sc1.nextLine(); 
System.out.println(choice1);
if (choice1.equals("1"))
{

String fname,tdate,ttime,post;
System.out.println("Enter Fullname");
fname=sc1.nextLine();  
System.out.println("Enter Date");
tdate=sc1.nextLine(); 
System.out.println("Enter Time");
ttime=sc1.nextLine(); 
System.out.println("Enter Post");
post=sc1.nextLine(); 



String sql="insert into tweetpost values('" + fname + "','" + tdate + "','" + ttime + "','" + post + "')";
stmt.executeUpdate(sql);


    
      System.out.println("Tweet  Post successfully");
con.close();  

}





if (choice1.equals("2"))
{

String fname,tdate,ttime,post;

String fn="Mahendra";

ResultSet rs1=stmt.executeQuery("select * from tweetpost where fname='" + fn + "'");  
System.out.println("*************************");
System.out.println("My Tweets");
System.out.println("*************************");
while(rs1.next())  
System.out.println(rs1.getString(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3)+"  "+rs1.getString(4));  
con.close();  

}

if (choice1.equals("3"))
{

String fname,tdate,ttime,post;



ResultSet rs2=stmt.executeQuery("select * from register");  
System.out.println("*************************");
System.out.println("All User List");
System.out.println("**********************************************");
System.out.println("UserName     Email     Contact");
System.out.println("**********************************************");
while(rs2.next())  
System.out.println(rs2.getString(1)+"  "+rs2.getString(2)+"  "+rs2.getString(3));  
con.close();  

}

if (choice1.equals("4"))
{

String fname,tdate,ttime,post;



ResultSet rs22=stmt.executeQuery("select * from tweetpost");  
System.out.println("*************************");
System.out.println("All Tweets");
System.out.println("**********************************************");
System.out.println("UserName     Date      Time     TweetPost");
System.out.println("**********************************************");
while(rs22.next())  
System.out.println(rs22.getString(1)+"  "+rs22.getString(2)+"  "+rs22.getString(3)+"  "+rs22.getString(4));  
con.close();  

}


}



}catch(Exception e){ System.out.println(e);}  








}
}

class forg
{
void forgot()
{
Scanner sc1= new Scanner(System.in);
String pw1,pw;
System.out.println("Enter old Password");
pw=sc1.nextLine();  
System.out.println("Enter New Password");
pw1=sc1.nextLine(); 

 try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3307/tweet","root","root");  

Statement stmt=con.createStatement();  
String sql="update register set pw='" + pw1 + "' where pw='" + pw + "'";
stmt.executeUpdate(sql);


    
      System.out.println("Password Changed successfully");
con.close();  
}catch(Exception e){ System.out.println(e);}  

}
}


