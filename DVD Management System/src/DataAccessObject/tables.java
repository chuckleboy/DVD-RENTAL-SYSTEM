/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;



/**
 *
 * @author ASUS-NOTEBOOK
 */
public class tables {
    
    public static void main (String[] args){
        
        final String adminpass;
        adminpass= "1234";
        
        try{    
            String userTable = "create table user(id int not null auto_increment, Name varchar(200), Email varchar(200), Password varchar(200),    type int default 2 ,token varchar(10), Status varchar (200), Unique (email), primary key (id));";
            String adminDetails = "insert into user (Name, Email, Password, type, Token,Status) values('Admin','admin@gmail.com','"+adminpass+"','1','123456','true');";
            DBOperation.setDataOrDelete(userTable, "User Table created Successfully");
            DBOperation.setDataOrDelete(adminDetails, "Admin Details added Successfully");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    
              
}
        
        
    
    

