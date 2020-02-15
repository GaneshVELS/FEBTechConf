/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_data;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Ganesh
 */
public class Employee_Data {

    /**
     * @param args the command line arguments
     */
   
    
    
    public void add_Employee_Detail() throws ClassNotFoundException, SQLException
    {
        Scanner s=new Scanner(System.in);
  System.out.println("Enter the employee details");
  int id=s.nextInt();
  String ename=s.next();
  String address=s.next();
  
  String status=s.next();
  
         Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Employee_Details","sa","vels@123");
   Statement stmt=con.createStatement();
   
   String sql="insert into EMPLOYEE(eid,ename,address,status) values("+id+",'"+ename+"','"+address+"','"+status+"')";
   
   
   stmt.executeUpdate(sql);
   
    System.out.println("Employee Details Inserted Successfully");
    
    }
    public void modify_Employee_Detail() throws ClassNotFoundException, SQLException
    {
        
        Scanner s=new Scanner(System.in);
  System.out.println("Enter the employee details");
  int id=s.nextInt();
  String ename=s.next();
  
         Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Employee_Details","sa","vels@123");
   Statement stmt=con.createStatement();
   String sql="update employee set ename='"+ename+"' where eid="+id+"";
   
   stmt.executeUpdate(sql);
   
    System.out.println("Employee Details Updated Successfully");
   
    }
    public void delete_Employee_Detail() throws ClassNotFoundException, SQLException
    {
        
        Scanner s=new Scanner(System.in);
  System.out.println("Enter the employee details");
  int id=s.nextInt();
  
  
         Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Employee_Details","sa","vels@123");
   Statement stmt=con.createStatement();
   String sql="delete employee where eid="+id+"";
   
   stmt.executeUpdate(sql);
   
    System.out.println("Employee Details Delete Successfully");
   
    }
    public void view_All_Employee_Detail() throws ClassNotFoundException, SQLException
    {
        

  
         Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Employee_Details","sa","vels@123");
   Statement stmt=con.createStatement();
   String sql="Select * from employee";
   
ResultSet rs=stmt.executeQuery(sql);

while(rs.next())
{
    System.out.println(rs.getInt()+" "+rs.getString()+" "+rs.getString()+""+rs.getString());
}
   
    System.out.println("Employee Details selected Successfully");
   
    }
    public void view_Single_Employee_Detail() throws SQLException, ClassNotFoundException
    {
        Scanner s=new  Scanner(System.in);
        int id=s.nextInt();
  
         Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Employee_Details","sa","vels@123");
   Statement stmt=con.createStatement();
   String sql="select * from employee where eid="+id+";
   
ResultSet rs=stmt.executeQuery(sql);

while(rs.next())
{
    System.out.println(rs.getInt()+" "+rs.getString()+" "+rs.getString()+" "+rs.getString());
}
   
    System.out.println("Employee Details selected Successfully");
   
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        System.out.println("----------Menu------------");
        System.out.println("1.Add the employee detail");
        System.out.println("2.Modify the employee detail");
        System.out.println("3.Delete the employee detail");
        System.out.println("4.View all the employee detail");
        System.out.println("5.View single the employee detail");
        System.out.println("6.Exit");
        Employee_Data ed=new Employee_Data(); 
        Scanner s=new Scanner(System.in);
        int choice=s.nextInt();
        if(choice==1)
        {
         ed.add_Employee_Detail();
        }
        else if(choice==2)
        {
        ed.modify_Employee_Detail();
        }
        else if(choice==3)
        {
        ed.delete_Employee_Detail();
        }
        else if(choice==4)
        {
        ed.view_All_Employee_Detail();
        }
        else if(choice==5)
        {
        ed.view_Single_Employee_Detail();
        }
        else
        {
            System.exit(choice);
        }
        }
    }
    

