// Class representing a researcher, extending from the Personnel class
public class Researcher extends Personnel {
    // Private member variables to store researcher-specific information
    private String Topic;     // Research topic
    private String Speciality;     // Researcher's speciality
    private boolean Available;     // Variable to determine if the researcher is currently available

    // Constructor to initialize researcher information, taking information about the researcher and passing it to the superclass constructor (Personnel)
    public Researcher(int id,String name,String jobTitle,String userName,String password,String topic,String speciality,boolean avilable){
        super(id,name,jobTitle,userName,password);
        this.Topic=topic;
        this.Speciality=speciality;
        this.Available=avilable;

    }

    // Setter methods to update researcher information
    public void setTopic(String Topic) {
        this.Topic = Topic;
    }

    public void setSpeciality(String Speciality) {
        this.Speciality = Speciality;
    }

    public void setAvailable(boolean Available) {
        this.Available = Available;
    }

    // Getter methods to retrieve researcher information

    public String getTopic() {
        return Topic;
    }

    public String getSpeciality() {
        return Speciality;
    }

    // Method to check if the researcher is currently available
    public boolean isAvailable() {
        return Available;
    }
}
