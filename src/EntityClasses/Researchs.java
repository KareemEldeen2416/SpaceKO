
package EntityClasses;
// Class representing a research project

import DBConnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Researchs {
    // Private member variables to store research project information
    private  int ResearchID;      // Research project number
    private  String ResearchName;       // Research project name
    private  int ResearcherID;  
    private String ResearcherName;
    // Department associated with the project

    // Constructor to initialize research project information
    public Researchs(String ResearchName, int ResearcherID){
        this.ResearcherID = ResearcherID;
        this.ResearchName = ResearchName;
    }
    
    public Researchs(String ResearchName ,String ResearcherName,int ResearcherID){
        this.ResearcherID = ResearcherID;
        this.ResearchName = ResearchName;
        this.ResearcherName = ResearcherName;
    }


    // Setter methods to update research project information

    public int getResearchID() {
        return ResearchID;
    }

    public void setResearchID(int ResearchID) {
        this.ResearchID = ResearchID;
    }

    public String getResearchName() {
        return ResearchName;
    }

    public void setResearchName(String ResearchName) {
        this.ResearchName = ResearchName;
    }

    public int getResearcherID() {
        return ResearcherID;
    }

    public void setResearcherID(int ResearcherID) {
        this.ResearcherID = ResearcherID;
    }

    public String getResearcherName() {
        return ResearcherName;
    }

    public void setResearcherName(String ResearcherName) {
        this.ResearcherName = ResearcherName;
    }

    
   
    
    public static Researchs fetch(int id) throws SQLException{
//SELECT * from research 
//inner join researcher on researcher.researcherID = research.researcherID where researchID=1;        

        ResultSet rs = DbConnection.executeFetchQuery("select * from research inner join researcher on researcher.researcherID = research.researcherID where researchID = "+id+";");
        if(rs.next()){
            return new Researchs(rs.getString("researchTitle"),rs.getString("researcherName"),rs.getInt("research.researcherID"));
        }else{
            return null;
        }
    }
    
    public void add(){
        if(DbConnection.executeQuery("insert into research (researchTitle,researcherID) values (\""+this.ResearchName+"\","+this.ResearcherID+");")){
            System.out.println("A New Research Added Successfully");
        }else{
            System.out.println("Research Addition Failed");
        }
    }
    
    public void edit(int id){
        if(DbConnection.executeQuery("update research set researchTitle = \""+this.ResearchName+"\",researcherID = "+this.ResearcherID+" where researchID = "+id+";")){
            System.out.println("Research Edited Successfully");
        }else{
            System.out.println("Research Edition Failed");
        }
    }
    
    public static void delete(int id){
        if(DbConnection.executeQuery("delete from research where researchID = "+id+";")){
            System.out.println("Research Deleted Successfully");
        }else{
            System.out.println("Research Deletion Failed");
        }
    }
}
