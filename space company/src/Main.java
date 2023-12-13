import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {


        Personnel p;
        p = new Personnel(123654789, "sara", "enginner", "k125", "54687k");
        p.setUserName("Karim");
        p.setJobTitle("manger");
        p.setPassword("kemo123654");
        System.out.println(p.getPassword());
        System.out.println(p.getJobTitle());
        System.out.println(p.getUserName());
        System.out.println(p.getId());

        // Create a Astronaut object
        Astronaut a = new Astronaut(123, "John Doe", "Astronaut", "johndoe", "password123", true, 25, "Mission Mars");
        a.addTripHistory("push12");
        a.addTripHistory("kldf66");
        System.out.println(a.getMissionName());
        System.out.println(a.getPassword());
        System.out.println(a.isOnTrip());
        System.out.println(a.getTripHistory());

        // Create a Gpsdata object
        Gpsdata gpsData = new Gpsdata("Destination1", 10.5f, 20.7f);

        // Create a Satellite object using the constructor
        Satellite satellite = new Satellite(true, 123, "MissionXYZ", 30 , gpsData);

        // Accessing and printing some attributes
        System.out.println("Satellite ID: " + satellite.getId());
        System.out.println("Mission Name: " + satellite.getMissionName());
        System.out.println("Mission Duration: " + satellite.getMissionDuration());

        // Accessing and printing GPS data
        Gpsdata gpsDataFromSatellite = satellite.getGpsdata();
        System.out.println("Destination Name: " + gpsDataFromSatellite.getDestinationName());
        System.out.println("X Axis: " + gpsDataFromSatellite.getX_axis());
        System.out.println("Y Axis: " + gpsDataFromSatellite.getY_axis());
    }



}