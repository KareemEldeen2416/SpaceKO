package EntityClasses;

// Class representing a researcher, extending from the Personnel class

import DBConnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Researcher  {
    // Private member variables to store researcher-specific information
    private String name;
    private int researcherID;
    
    // Constructor to initialize researcher information, taking information about the researcher and passing it to the superclass constructor (Personnel)
    public Researcher(String name ){
        this.name =name;
        
    }

    // Setter methods to update researcher information

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResearcherID() {
        return researcherID;
    }

    public void setResearcherID(int researcherID) {
        this.researcherID = researcherID;
    }
    
    public void add(){
//        insert into researcher (researcherName) VALUES ("Osama");
        if(DbConnection.executeQuery("insert into researcher (researcherName) values (\""+this.name+"\");")){
            System.out.println("A New Researcher Added Successfully");
        }else{
            System.out.println("Researcher Addition Failed");
        }
    }
    
    public static Researcher fetch(int id) throws SQLException{
        ResultSet rs = DbConnection.executeFetchQuery("select * from researcher where researcherID = "+id+";");
        if(rs.next()){
            return new Researcher(rs.getString("researcherName"));
        }else{
            return null;
        }
    }
    
    public void edit(int id){
        if(DbConnection.executeQuery("update researcher set researcherName = \""+this.name+"\" where researcherID = "+id+";")){
            System.out.println("Researcher Edited Successfully");
        }else{
            System.out.println("Researcher Edition Failed");
        }
    }
    
    public static void delete(int id){
        if(DbConnection.executeQuery("update research set researcherID = 0 where researcherID = "+id+";")){
            if(DbConnection.executeQuery("delete from researcher where researcherID = "+id+";")){
                System.out.println("Researcher Deleted Successfully");
            }
        }else{
            System.out.println("Researcher Deletion Failed");
        }
    }
}
