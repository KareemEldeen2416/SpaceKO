// Define the SpaceShuttle class to represent the SpaceShuttle table in the database
public class SpaceShuttle {
    // Private fields to represent each column in the SpaceShuttle table
    private int ShuttleID;
    private int ShuttleThrust;
    private int ShuttleCrewCapacity;
    private int ShuttlePayloadCapacity;
    private int ShuttleOrbitVelocity;
    private Gpsdata Gpsdata;  // Assuming Gpsdata is another class representing GPS information

    // Constructor to initialize the SpaceShuttle object with values for each column
    public SpaceShuttle(int shuttleID, int shuttleThrust, int shuttleCrewCapacity, int shuttlePayloadCapacity, int shuttleOrbitVelocity, Gpsdata gpsdata) {
        this.ShuttleID = shuttleID;
        this.ShuttleThrust = shuttleThrust;
        this.ShuttleCrewCapacity = shuttleCrewCapacity;
        this.ShuttlePayloadCapacity = shuttlePayloadCapacity;
        this.ShuttleOrbitVelocity = shuttleOrbitVelocity;
        this.Gpsdata = gpsdata;
    }

    // Setter methods to set values for each column
    public void setShuttleID(int ShuttleID) {
        this.ShuttleID = ShuttleID;
    }

    public void setShuttleThrust(int ShuttleThrust) {
        this.ShuttleThrust = ShuttleThrust;
    }

    public void setShuttleCrewCapacity(int ShuttleCrewCapacity) {
        this.ShuttleCrewCapacity = ShuttleCrewCapacity;
    }

    public void setShuttlePayloadCapacity(int ShuttlePayloadCapacity) {
        this.ShuttlePayloadCapacity = ShuttlePayloadCapacity;
    }

    public void setShuttleOrbitVelocity(int ShuttleOrbitVelocity) {
        this.ShuttleOrbitVelocity = ShuttleOrbitVelocity;
    }

    // Setter method to set GPS data for the shuttle
    public void setFkGpsShuttle(Gpsdata Gpsdata) {
        this.Gpsdata = Gpsdata;
    }

    // Getter methods to retrieve values for each column
    public int getShuttleID() {
        return ShuttleID;
    }

    public int getShuttleThrust() {
        return ShuttleThrust;
    }

    public int getShuttleCrewCapacity() {
        return ShuttleCrewCapacity;
    }

    public int getShuttlePayloadCapacity() {
        return ShuttlePayloadCapacity;
    }

    public int getShuttleOrbitVelocity() {
        return ShuttleOrbitVelocity;
    }

    // Getter method to retrieve GPS data for the shuttle
    public Gpsdata getGpsShuttle() {
        return Gpsdata;
    }
}
