
package EntityClasses;

import DBConnection.DbConnection;
// Class representing an astronaut, extending from the Personnel class
public class Astronaut {
    // Private member variables to store astronaut-specific information
             // Variable to determine if the astronaut is currently on a trip
          // Current trip number
    
    private String AstroName;        
    private int AstroID;


    // Constructor to initialize astronaut information, taking information about the astronaut and passing it to the superclass constructor (Personnel)
    public Astronaut(String AstroName){
        
        this.AstroName = AstroName;
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

    
    
    
    public void addAstronaut(){
//        insert into astronaut (astroName) VALUES ("KareemEldeen");
        if(DbConnection.executeQuery("insert into astronaut (astroName) values (\""+this.AstroName+"\");")){
            System.out.println("A New Astronaut Added Successfully");
        }else{
            System.out.println("Astronaut Addition Was A Failure");
        }
    }
   


}
