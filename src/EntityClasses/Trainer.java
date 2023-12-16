package EntityClasses;

// Trainer class extends the Personnel class
public class Trainer extends Personnel{
    // Private attributes specific to the Trainer class
    private String Track;            // Track associated with the trainer
    private int NumberofTraninees;              // Number of trainees under the trainer

    // Constructor to initialize the Trainer object
    public  Trainer(int id,String name,String jobTitle,String userName,String password,String track,int numberofTraninees){
        // Call the constructor of the superclass (Personnel) using super()
        super(id,name,jobTitle,userName,password);
        // Initialize Trainer-specific attributes
        this.NumberofTraninees=numberofTraninees;
        this.Track=track;

    }

    // Setter method for the Track attribute
    public void setTrack(String Track) {
        this.Track = Track;
    }

    public void setNumberofTraninees(int NumberofTraninees) {
        this.NumberofTraninees = NumberofTraninees;
    }

    // Getter method for the Track attribute
    public String getTrack() {
        return Track;
    }

    public int getNumberofTraninees() {
        return NumberofTraninees;
    }
}
