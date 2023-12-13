// Track class represents a training track
public class Track {
    // Private attributes specific to the Track class
    private int NumberOfTrack;        // Number assigned to the track
    private String Name;             // Name of the track
    private String Duration;       // Duration of the track

    // Constructor to initialize a Track object
    public Track(int numberOfTrack,String name,String duration){
        this.NumberOfTrack=numberOfTrack;
        this.Name=name;
        this.Duration=duration;
    }

    // Setter method for the NumberOfTrack attribute
    public void setNumberOfTrack(int NumberOfTrack){
        this.NumberOfTrack=NumberOfTrack;
    }
    public void setName(String Name){
        this.Name=Name;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    // Getter method for the NumberOfTrack attribute
    public int getNumberOfTrack() {
        return NumberOfTrack;
    }

    public String getName() {
        return Name;
    }

    public String getDuration() {
        return Duration;
    }
}
