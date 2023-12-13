public class Rocket {
    // Private attributes specific to the Rocket class
    private int RocketId;                    // Unique identifier for the rocket
    private int Payload;                    // Payload capacity of the rocket
    private String Model;                   // Model or type of the rocket
    private Float Cost;                      // Cost of the rocket
    private boolean Availability;            // Availability status of the rocket
    private boolean VisualCommunication;     // Visual communication capability of the rocket
    private int StageSeparation;             // Stage separation capacity of the rocket
    private String FuelType;                 // Type of fuel used by the rocket
    private Gpsdata Gpsdata;                 // Gpsdata object containing GPS information for the rocket

    // Constructor for creating a Rocket object
    public Rocket(int rocketId, int payload, String model, Float cost, boolean availability, boolean visualCommunication, int stageSeparation, String fuelType, Gpsdata gpsdata) {
        this.RocketId = rocketId;
        this.Payload = payload;
        this.Model = model;
        this.Cost = cost;
        this.Availability = availability;
        this.VisualCommunication = visualCommunication;
        this.StageSeparation = stageSeparation;
        this.FuelType = fuelType;
        this.Gpsdata = gpsdata;
    }

    // Setter methods for updating the values of attributes
    public void setRocketId(int RocketId) {
        this.RocketId = RocketId;
    }

    public void setPayload(int Payload) {
        this.Payload = Payload;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setCost(Float Cost) {
        this.Cost = Cost;
    }

    public void setAvailability(boolean Availability) {
        this.Availability = Availability;
    }

    public void setVisualCommunication(boolean VisualCommunication) {
        this.VisualCommunication = VisualCommunication;
    }

    public void setStageSeparation(int StageSeparation) {
        this.StageSeparation = StageSeparation;
    }

    public void setFuelType(String FuelType) {
        this.FuelType = FuelType;
    }

    public void setGpsdata(Gpsdata Gpsdata) {
        this.Gpsdata = Gpsdata;
    }

    // Getter methods for retrieving the values of attributes
    public int getRocketId() {
        return RocketId;
    }

    public int getPayload() {
        return Payload;
    }

    public String getModel() {
        return Model;
    }

    public Float getCost() {
        return Cost;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public boolean isVisualCommunication() {
        return VisualCommunication;
    }

    public int getStageSeparation() {
        return StageSeparation;
    }

    public String getFuelType() {
        return FuelType;
    }

    public Gpsdata getGpsdata() {
        return Gpsdata;
    }
}
