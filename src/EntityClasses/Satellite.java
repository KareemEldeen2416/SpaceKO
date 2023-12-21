package EntityClasses;

import DBConnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Satellite {
    // Private attributes specific to the Satellite class
    
    private int Id;               // Unique identifier for the satellite
    private  String satName;     // Name of the satellite mission     // Duration of the satellite mission
    private  Gpsdata Gpsdata;           // Gpsdata object containing GPS information for the satellite

    // Constructor for creating a Satellite object
    public Satellite(String satName, Gpsdata gpsdata){

        this.satName = satName;
        this.Gpsdata=gpsdata;
    }

    // Setter methods for updating the values of attributes
    
    public void setId(int Id) {
        this.Id = Id;
    }

    public void setSatName(String satName) {
        this.satName = satName;
    }

    
    public void setGpsdata(Gpsdata Gpsdata) {
        this.Gpsdata = Gpsdata;
    }

    
    public int getId() {
        return Id;
    }

    public String getSatName() {
        return satName;
    }


    public Gpsdata getGpsdata() {
        return Gpsdata;
    }
    
    public void add(){
//        insert into satellite (satName,Destination,x,y) VALUES ("Sohail","Earth",30,50);
        if(DbConnection.executeQuery("insert into satellite (satName,Destination,x,y) values (\""
                +this.satName+"\",\""+this.Gpsdata.getDestinationName()+"\","+this.Gpsdata.getX_axis()+","+this.Gpsdata.getY_axis()+");"
        )){
            System.out.println("A New Satellite Added Successfully");
        }else{
            System.out.println("Satellite Addition Failed");
        }
    }
    
    
    public static Satellite fetch(int id) throws SQLException{
        ResultSet rs = DbConnection.executeFetchQuery("select * from satellite where satID = "+id+";");
        if(rs.next()){
            return new Satellite(rs.getString("satName"),new Gpsdata(rs.getString("Destination"),rs.getFloat("x"),rs.getFloat("y")));
        }else{
            return null;
        }
    }
    
    public void edit(int id){
        if(DbConnection.executeQuery("update satellite set satName = \""+this.satName+"\", Destination = \""+this.Gpsdata.getDestinationName()+"\","
                +"x = "+this.Gpsdata.getX_axis()+", y = "+this.Gpsdata.getY_axis()+" where satID = "+id+";"
        )){
            System.out.println("Satellite Edited Successfully");
        }else{
            System.out.println("Satellite Edition Failed");
        }
    }
    
    public static void delete(int id){
        if(DbConnection.executeQuery("delete from satellite where satID = "+id+";")){
            System.out.println("Satellite Deleted Successfully");
        }else{
            System.out.println("Satellite Deletion Failed");
        }
    }
    
    
}
