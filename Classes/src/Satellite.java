public class Satellite {
    // Private attributes specific to the Satellite class
    private boolean OnMission;         // Indicates if the satellite is currently on a mission
    private int Id;               // Unique identifier for the satellite
    private  String MissionName;     // Name of the satellite mission
    private int MissionDuration;      // Duration of the satellite mission
    private  Gpsdata Gpsdata;           // Gpsdata object containing GPS information for the satellite

    // Constructor for creating a Satellite object
    public Satellite(boolean onMission, int id, String missionName, int missionDuration, Gpsdata gpsdata){

        this.OnMission=onMission;
        this.Id=id;
        this.MissionName=missionName;
        this.MissionDuration=missionDuration;
        this.Gpsdata=gpsdata;
    }

    // Setter methods for updating the values of attributes
    public void setOnMission(boolean OnMission) {
        this.OnMission = OnMission;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setMissionName(String MissionName) {
        this.MissionName = MissionName;
    }

    public void setMissionDuration(int MissionDuration) {
        this.MissionDuration = MissionDuration;
    }

    public void setGpsdata(Gpsdata Gpsdata) {
        this.Gpsdata = Gpsdata;
    }

    // Getter methods for retrieving the values of attributes
    public boolean isOnMission() {
        return OnMission;
    }

    public int getId() {
        return Id;
    }

    public String getMissionName() {
        return MissionName;
    }

    public int getMissionDuration() {
        return MissionDuration;
    }

    public Gpsdata getGpsdata() {
        return Gpsdata;
    }
}
