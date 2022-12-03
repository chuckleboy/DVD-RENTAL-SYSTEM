/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;
import javax.swing.JOptionPane;



import model.*;
import java.sql.*;
import java.util.Properties;
import java.util.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS-NOTEBOOK
 */
public class Userdao{
  /*  
  public static void main(String[] args){
      Mail mail = new Mail();
      mail.setupSeverProperties();
      mail.draftEmail();
      mail.sendEmail();
      
      
  }
  
  private void sendEmail(){
      
  }
  
  private void draftEmail(){
      
  }
  
  private void setupServerProperties(){
      Properties.put
  }
    */
  
    
    
 
    
    public static void save(User user){
        
        /*otp o = new otp();
        int l = 6; //max lenght of otp
        String token = String.valueOf(o.method(l));*/
        
    
        
        String query = "insert into user (Name, Email, Password,Token, Status) values ('"+user.getName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getToken()+"','false')";
        DBOperation.setDataOrDelete(query,"Your account is now registered. Verify your account.");
        
        
        
    }
    
    public static User getEmail (String email){
        
        User user = null;
        try{
            ResultSet rs = DBOperation.getData("Select * from user where email = '" + email + "'");
            while(rs.next()){
                user = new User();
                user.setEmail(rs.getString("email"));
                
                
                
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
        
    }
    
    public static User getverify (String email){
        
        
        User user = null;
        try{
            ResultSet rs = DBOperation.getData("Select * from user where email = '" + email + "'");
            while(rs.next()){
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setToken(rs.getString("token"));
                
                
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;        
    }
    
    public static User login(String email, String password){
            
        User user = null;
        try{
            ResultSet rs = DBOperation.getData("select * from user where email ='"+email+"' and password='"+password+"'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
                user.setType(rs.getInt(1));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    
    
    public static User getType(String email){
        User user = null;
        try{
            ResultSet rs = DBOperation.getData("Select * from user where email = '" + email + "'");
            while(rs.next()){
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setType(rs.getInt("type"));
                
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    
    
    
    public static User getToken(String email){
        User user = null;
        try{
            ResultSet rs = DBOperation.getData("Select * from user where email = '" + email + "'");
            while(rs.next()){
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setToken(rs.getString("token"));
                
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    
    
    
   public static void update(String email, String newPassword){
       String query = "update user set password='"+newPassword+"' where email = '"+email+"'";
       DBOperation.setDataOrDelete(query, "Password Changed Successfully!");
       
   }
   
   public static void updateStatus(String email, String status){
   String query = "update user set status ='true' where email = '"+email+"'";
   DBOperation.setDataOrDelete(query, "Your Account is now Verified!");
       
   }
   
   public static void updateToken(String email, String newToken){
   String query = "update user set token ='"+newToken+"' where email = '"+email+"'";
   DBOperation.setDataOrDelete(query, "");
       
   }
   
   
   
    
}
