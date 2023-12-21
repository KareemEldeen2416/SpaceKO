
package EntityClasses;

import DBConnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
// Class representing an astronaut, extending from the Personnel class
public class Astronaut {
    // Private member variables to store astronaut-specific information
             // Variable to determine if the astronaut is currently on a trip
          // Current trip number
    
    private String AstroName;        
    private int AstroID;
    private String missionName;
    private int missionID;


    // Constructor to initialize astronaut information, taking information about the astronaut and passing it to the superclass constructor (Personnel)
    public Astronaut(String AstroName){
        
        this.AstroName = AstroName;
    }
    
    public Astronaut(String AstroName ,String missionName,int missionID){
        this.AstroName = AstroName;
        this.missionName = missionName;
        this.missionID = missionID;
    }

    public String getAstroName() {
        return AstroName;
    }

    public void setAstroName(String AstroName) {
        this.AstroName = AstroName;
    }
    public int getAstroID() {
        return AstroID;
    }

    public void setAstroID(int AstroID) {
        this.AstroID = AstroID;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public int getMissionID() {
        return missionID;
    }

    public void setMissionID(int missionID) {
        this.missionID = missionID;
    }
    
    

    
    
    
    public void addAstronaut(){
//        insert into astronaut (astroName) VALUES ("KareemEldeen");
        if(DbConnection.executeQuery("insert into astronaut (astroName) values (\""+this.AstroName+"\");")){
            System.out.println("A New Astronaut Added Successfully");
        }else{
            System.out.println("Astronaut Addition Was A Failure");
        }
    }
    
    public static Astronaut fetch(int id) throws SQLException{
//        select * from astronaut INNER JOIN mission on mission.astroID = astronaut.astroID where astronaut.astroID = 1;
        ResultSet rs = DbConnection.executeFetchQuery("select * from astronaut inner join mission on mission.astroID = astronaut.astroID where astronaut.astroID =  "+id+";");
        if(rs.next()){
            return new Astronaut(rs.getString("astroName"),rs.getString("missionName"),rs.getInt("missionID"));
        }else{
            return null;
        }
    }
    
    public void edit(int id){
        if(DbConnection.executeQuery("update astronaut set astroName = \""+this.AstroName+"\" where astroID = "+id+";")){
            System.out.println("Astronaut Edited Successfully");
        }else{
            System.out.println("Astronaut Edition Failed");
        }
    }
    
    public void delete(int id){
        if(DbConnection.executeQuery("update mission set astroID = 0 where astroID = "+id+";")){
            if(DbConnection.executeQuery("delete from astronaut where astroID = "+id+";")){
                System.out.println("Deletion Is Done");
            }
        }else{
            System.out.println("Astronaut Deletion Failed");
        }
    }
    
    
   


}
