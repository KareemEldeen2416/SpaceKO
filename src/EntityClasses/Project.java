
package EntityClasses;
import DBConnection.DbConnection;
public class Project {
    // Private attributes specific to the Project class
    private int ProjectNumber;    // Unique identifier for the project
    private String ProjectName;   // Name or title of the project       // Number of crew members in the project        // Leader or manager of the project
    private String Target;        // Target or objective of the project
    private Float Budget;         // Budget allocated for the project

    // Constructor for creating a Project object
    public  Project(String ProjectName,String Target,Float Budget){
        
        this.ProjectName=ProjectName;
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

    

    public void setTarget(String Target) {
        this.Target = Target;
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


    public String getTarget() {
        return Target;
    }

    public Float getBudget() {
        return Budget;
    }
    
    public void addProject(){
         if(DbConnection.executeQuery("insert into project (Project_Name,Project_Leader,Project_Target,Project_Budget) VALUES (\""
                 +this.ProjectName+"\",\""+this.Leader+"\",\""+this.Target+"\",\""+this.Budget+"\");")){
            System.out.println("A new Project added");
        }else{
            System.out.println("Error");
        }
    }
    
}
