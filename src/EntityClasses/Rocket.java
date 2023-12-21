package EntityClasses;

import DBConnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rocket {
    // Private attributes specific to the Rocket class
    private int RocketId;                    // Unique identifier for the rocket                    // Payload capacity of the rocket
    private String Model;                   // Model or type of the rocket
    private String RocketName;
    private boolean Availability;            // Availability status of the rocket
    private boolean VisualCommunication;     // Visual communication capability of the rocket            // Stage separation capacity of the rocket
                     // Gpsdata object containing GPS information for the rocket

    // Constructor for creating a Rocket object
    public Rocket(String RocketName,String model,boolean availability, boolean VisualCommunication) {

        this.Model = model;
        this.RocketName = RocketName;
        this.Availability = availability;
        this.VisualCommunication = VisualCommunication;
       
    }

    // Setter methods for updating the values of attributes
    public void setRocketId(int RocketId) {
        this.RocketId = RocketId;
    }

    

    public void setModel(String Model) {
        this.Model = Model;
    }

    

    public void setAvailability(boolean Availability) {
        this.Availability = Availability;
    }

    public void setVisualCommunication(boolean VisualCommunication) {
        this.VisualCommunication = VisualCommunication;
    }

    

    // Getter methods for retrieving the values of attributes
    public int getRocketId() {
        return RocketId;
    }

    

    public String getModel() {
        return Model;
    }

    

    public boolean isAvailability() {
        return Availability;
    }

    public boolean isVisualCommunication() {
        return VisualCommunication;
    }

    public String getRocketName() {
        return RocketName;
    }

    public void setRocketName(String RocketName) {
        this.RocketName = RocketName;
    }
    
    

    
    public void add(){
//        insert into rocket (rocketName,rocketModel,rocketAv,rocketVC) VALUES ("R17","c88",true,true);
        if(DbConnection.executeQuery("insert into rocket (rocketName,rocketModel,rocketAv,rocketVC) VALUES (\""
                +this.RocketName+"\",\""+this.Model+"\","+this.Availability+","+this.VisualCommunication+");"
        )){
            System.out.println("A New Rocket Added Successfully");
        }else{
            System.out.println("Rocket Addition Failed");
        }
    }
    
    public static Rocket fetch(int id) throws SQLException{
        ResultSet rs = DbConnection.executeFetchQuery("select * from rocket where Rocket_ID = "+id+";");
        if(rs.next()){
            return new Rocket(rs.getString("rocketName"),rs.getString("rocketModel"), rs.getBoolean("rocketAv"),rs.getBoolean("rocketVC"));
        }else{
            return null;
        }
    }
    
    public void edit(int id){
        if(DbConnection.executeQuery("update rocket set rocketName = \""+this.RocketName+"\",rocketModel = \""+this.Model+"\","
                +"rocketAv = "+this.Availability+", rocketVC = "+this.VisualCommunication+" where Rocket_ID = "+id+";"
        )){
            System.out.println("Rocket Edited Successfully");
        }else{
            System.out.println("Rocket Edition Failed");
        }
    }
    
    public static void delete(int id){
        if(DbConnection.executeQuery("delete from rocket where Rocket_ID = "+id+";")){
            System.out.println("Rocket Deleted Successfully");
        }else{
            System.out.println("Rocket Deletion Failed");
        }
    }
}
