
package EntityClasses;

import DBConnection.DbConnection;
// Class representing an astronaut, extending from the Personnel class
public class Astronaut {
    // Private member variables to store astronaut-specific information
             // Variable to determine if the astronaut is currently on a trip
          // Current trip number
    
    private String AstroName;    
    private int MissionID;     
    private int AstroID;


    // Constructor to initialize astronaut information, taking information about the astronaut and passing it to the superclass constructor (Personnel)
    public Astronaut(String AstroName,int MissionID){
        
        this.AstroName = AstroName;
        this.MissionID = MissionID;
    }

    public String getAstroName() {
        return AstroName;
    }

    public void setAstroName(String AstroName) {
        this.AstroName = AstroName;
    }

    public int getMissionID() {
        return MissionID;
    }

    public void setMissionID(int MissionID) {
        this.MissionID = MissionID;
    }

    public int getAstroID() {
        return AstroID;
    }

    public void setAstroID(int AstroID) {
        this.AstroID = AstroID;
    }

    
    
    
    public void addAstronaut(){
         if(DbConnection.executeQuery("insert into astronaut (Astronaut_Name,Astro_Mission_id) values (\""+this.AstroName+"\",\""+this.MissionID+"\");")){
            System.out.println("A new Astronaut added");
        }else{
            System.out.println("Error");
        }
    }
   


}
