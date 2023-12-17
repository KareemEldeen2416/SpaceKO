/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author KareemEldeen
 */
public class DbConnection {
    
    private static String url = "";
    private static String dbName = "mydata";
    private static Connection connection;
    
    
    private static void seturl(){
        url = "jdbc:mysql://localhost:3306/"+dbName+"?useUnicode=true&characterEncoding=UTF-8";
    }
    
    private static void setConnection() throws SQLException{
        seturl();
        connection = DriverManager.getConnection(url,"root","");
    }
    
    
    public static boolean executeQuery(String stmtQuery){
        try{
            setConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(stmtQuery);
            connection.close();
            return true;
            
        }catch(SQLException e){
          return false;
        }
    }
    
    public static void addUser(int id , String fullName , String jobTitle , String userName, String userPassword){
//        INSERT into systemuser VALUES(9,"Karamela","Teacher","karamela13","13331");
      if(executeQuery("insert into systemuser values ("+id+",\""+fullName+"\",\""+jobTitle+"\",\""+userName+"\",\""+userPassword+"\");")){
          System.out.println("Done operation");
      }else{
          System.out.println("Error");
      }
       
    }
    
}
