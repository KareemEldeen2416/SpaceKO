
package EntityClasses;
import DBConnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
//        insert into project (Project_Name,Project_Budget,Project_Target) VALUES ("SAT Launch",12000.0,"DEV");
        if(DbConnection.executeQuery("insert into project (Project_Name,Project_Budget,Project_Target) VALUES (\""
                +this.ProjectName+"\","+this.Budget+",\""+this.Target+"\");"
        )){
            System.out.println("A New Report Added Successfully");
        }else{
            System.out.println("Project Addition Was Failure");
        }
    }
    
    
    public static Project fetchProject(int id) throws SQLException{
        ResultSet rs = DbConnection.executeFetchQuery("select * from project where Project_ID = "+id+";");
        if(rs.next()){
            return new Project(rs.getString("Project_Name"),rs.getString("Project_Target"),rs.getFloat("Project_Budget"));
        }else{
            return null;
        }
    }
    
    public void edit(int id){
        if(DbConnection.executeQuery("update project set Project_Name = \""+this.ProjectName+"\",Project_Target = \""+this.Target+"\",Project_Budget = "+this.Budget+"where Project_ID = "+id+";")){
            System.out.println("The Project Edited Successfully");
        }else{
            System.out.println("Edition Failure");
        }
    }
    
    public void delete(int id){
        if(DbConnection.executeQuery("delete from project where Project_ID = "+id+";")){
            System.out.println("Project Deleted Successfully");
        }else{
            System.out.println("Deletion Has Failed");
        }
    }
}
