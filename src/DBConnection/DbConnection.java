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
    private static String dbName = "spaceagencydatabase";
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
            System.out.println(e);
          return false;
        }
    }
    
    public static void addReport(String author , String title ,String content){
        if(executeQuery("insert into report (Report_Author,Report_Title,Report_String) values (\""+author+"\",\""+title+"\",\""+content+"\");")){
            System.out.println("A new report added");
        }else{
            System.out.println("Error");
        }
    }
    
}
