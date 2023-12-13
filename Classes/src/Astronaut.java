import java.util.ArrayList;
import java.util.List;
// Class representing an astronaut, extending from the Personnel class
public class Astronaut extends Personnel{
    // Private member variables to store astronaut-specific information
    private boolean OnTrip;          // Variable to determine if the astronaut is currently on a trip
    private int TripNumber;      // Current trip number
    private String MissionName;    // Current mission name
    private List<String>TripHistory;       // List to store the history of trips


    // Constructor to initialize astronaut information, taking information about the astronaut and passing it to the superclass constructor (Personnel)
    public Astronaut(int id,String name,String jobTitle,String userName,String password,boolean onTrip,int tripNumber,String missionName){
        super(id,name,jobTitle,userName,password);
        this.OnTrip=onTrip;
        this.TripNumber=tripNumber;
        this.MissionName=missionName;
        TripHistory=new ArrayList<>();

    }

    // Setter methods to update astronaut information
    public void setMissionName(String MissionName) {
        this.MissionName = MissionName;
    }

    public void setOnTrip(boolean OnTrip) {
       this.OnTrip = OnTrip;
    }

    public void setTripNumber(int TripNumber) {
        this.TripNumber = TripNumber;
    }

    public void setTripHistory(List<String> TripHistory) {
        // Using a new ArrayList to avoid direct modification of the provided list
        this.TripHistory = new ArrayList<>(TripHistory);
    }

    // Getter methods to retrieve astronaut information
    public String getMissionName() {
        return MissionName;
    }

    // Method to check if the astronaut is currently on a trip
    public boolean isOnTrip() {
        return OnTrip;
    }

    public int getTripNumber() {
        return TripNumber;
    }
    public List<String> getTripHistory() {
        // Using a new ArrayList to avoid exposing the internal list directly
        return new ArrayList<>(this.TripHistory);
    }

    // Method to add a new entry to the trip history
    public void addTripHistory(String tripHistory) {
        TripHistory.add(tripHistory);
    }


}
