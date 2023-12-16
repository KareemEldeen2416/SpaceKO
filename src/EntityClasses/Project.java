
package EntityClasses;
public class Project {
    // Private attributes specific to the Project class
    private int ProjectNumber;    // Unique identifier for the project
    private String ProjectName;   // Name or title of the project
    private int CrewNumber;       // Number of crew members in the project
    private String Leader;        // Leader or manager of the project
    private String Target;        // Target or objective of the project
    private Float Budget;         // Budget allocated for the project

    // Constructor for creating a Project object
    public  Project( int ProjectNumber,String ProjectName,int CrewNumber,String Leader,String Target,Float Budget){
        this.ProjectNumber=ProjectNumber;
        this.ProjectName=ProjectName;
        this.CrewNumber=CrewNumber;
        this.Leader=Leader;
        this.Target=Target;
        this.Budget=Budget;
    }

    // Setter methods for updating the values of attributes
    public void setProjectNumber(int ProjectNumber) {
        this.ProjectNumber = ProjectNumber;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public void setCrewNumber(int CrewNumber) {
        this.CrewNumber = CrewNumber;
    }

    public void setTarget(String Target) {
        this.Target = Target;
    }

    public void setLeader(String Leader) {
        this.Leader = Leader;
    }

    public void setBudget(Float Budget) {
        this.Budget = Budget;
    }

    // Getter methods for retrieving the values of attributes
    public int getProjectNumber() {
        return ProjectNumber;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public int getCrewNumber() {
        return CrewNumber;
    }

    public String getLeader() {
        return Leader;
    }

    public String getTarget() {
        return Target;
    }

    public Float getBudget() {
        return Budget;
    }
}
