package EntityClasses;

import DBConnection.DbConnection;

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

    public void setMissionName(String satName) {
        this.satName = satName;
    }

    
    public void setGpsdata(Gpsdata Gpsdata) {
        this.Gpsdata = Gpsdata;
    }

    
    public int getId() {
        return Id;
    }

    public String getMissionName() {
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
    
    
    public static Satellite fetch(){
        return null;
    }
    
    
}
