/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityClasses;

import DBConnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KareemEldeen
 */
public class User {
    
    private String fullName;
    private String userName;
    private String password;
    
    public User(String fullName,String userName, String password){
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }
    
    public User(String userName , String password){
        this.userName = userName;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean checkUser() throws SQLException{
        ResultSet rs = DbConnection.executeFetchQuery("select * from login");
        boolean result = false;
        while(rs.next()){
            if(rs.getString("userName").equals(this.userName) && rs.getString("pass").equals(this.password)){
                result =true;
            }
        }
        
        return result;
    }
    
    public void addUser(){
//        insert into login ("KareemEldeen","2416");
        if(DbConnection.executeQuery("insert into login (fullname,username,pass) values (\""+this.fullName+"\",\""+this.userName+"\",\""+this.password+"\");")){
            System.out.println("A New User Added Successfully");
        }else{
            System.out.println("Error In Addition");
        }
    }
    
    public static User fetchUser(int id) throws SQLException{
        ResultSet rs = DbConnection.executeFetchQuery("select * from login where id = "+id+";");
        if(rs.next()){
            return new User(rs.getString("fullname"),rs.getString("username"),rs.getString("pass"));
        }else{
            return null;
        }
        
    }
    
    public void editUser(int id){
        if(DbConnection.executeQuery("update login set fullname = \""+this.fullName+"\",username = \""+this.userName+"\",pass = \""+this.password+"\" where id = "+id)){
            System.out.println("User Edited Successfully");
        }else{
            System.out.println("Edition was a failure");
        }
    }
    
    public static void deleteUser(int id){
        if(DbConnection.executeQuery("delete from login where id = "+id)){
            System.out.println("User Deleted Successfully");
        }else{
            System.out.println("Deletion Was A Failure");
        }
    }
}
