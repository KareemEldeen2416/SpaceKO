// Class representing a trip
public class Trip {
    // Private member variables to store trip information
    private int TripNumber;        // Trip number
    private String Leader;           // Leader of the trip
    private int Duration;        // Duration of the trip
    private String TripName;       // Name of the trip

    // Constructor to initialize trip information
    public Trip(int tripNumber,String leader,int duration,String tripName){
        this.TripNumber=tripNumber;
        this.Leader=leader;
        this.Duration=duration;
        this.TripName=tripName;
    }

    // Setter methods to update trip information
    public void setTripNumber(int TripNumber) {
        this.TripNumber = TripNumber;
    }

    public void setLeader(String Leader) {
        this.Leader = Leader;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public void setTripName(String TripName) {
        this.TripName = TripName;
    }


    // Getter methods to retrieve trip information
    public int getTripNumber() {
        return TripNumber;
    }

    public String getLeader() {
        return Leader;
    }

    public int getDuration() {
        return Duration;
    }

    public String getTripName() {
        return TripName;
    }
}
