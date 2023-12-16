package EntityClasses;

// Class representing a trainee
public class Trainee {
    // Private member variables to store trainee information
    private  int TraineeId;            // Trainee's id
    private String TraineeName;        // Trainee's name
    private String Track;            // Track or program in which the trainee is enrolled
    private String Status;         // Status of the trainee
    private boolean Passed;        // Indicator if the trainee has passed

    // Constructor to initialize trainee information
    public Trainee(int traineeId,String traineeName,String track,String status,boolean passed){
        this.TraineeId=traineeId;
        this.TraineeName=traineeName;
        this.Track=track;
        this.Status=status;
        this.Passed=passed;
    }

    // Setter methods to update trainee information

    public void setTraineeId(int TraineeId) {
        this.TraineeId = TraineeId;
    }

    public void setTraineeName(String TraineeName) {
        this.TraineeName = TraineeName;
    }

    public void setTrack(String Track) {
        this.Track =    Track;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setPassed(boolean Passed) {
        this.Passed = Passed;
    }

    // Getter methods to retrieve trainee information

    public int getTraineeId() {
        return TraineeId;
    }

    public String getTraineeName() {
        return TraineeName;
    }

    public String getTrack() {
        return Track;
    }

    public String getStatus() {
        return Status;
    }

    public boolean getPassed() {
        return Passed;
    }

}
