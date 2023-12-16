
package EntityClasses;
// Class representing a research project
public class Research {
    // Private member variables to store research project information
    private  int ResearchNumber;      // Research project number
    private  String ResearchName;       // Research project name
    private  String Researcher;       // Researcher associated with the project
    private  String Department;      // Department associated with the project

    // Constructor to initialize research project information
    public Research(int researchNumber,String researchName,String researcher ,String department){
        this.ResearchNumber=researchNumber;
        this.ResearchName=researchName;
        this.Researcher=researcher;
        this.Department=department;
    }


    // Setter methods to update research project information
    public void setResearchNumber(int ResearchNumber) {
        this.ResearchNumber = ResearchNumber;
    }

    public void setResearchName(String ResearchName) {
        this.ResearchName = ResearchName;
    }

    public void setResearcher(String Researcher) {
        this.Researcher = Researcher;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    // Getter methods to retrieve research project information
    public int getResearchNumber() {
        return ResearchNumber;
    }

    public String getResearchName() {
        return ResearchName;
    }

    public String getResearcher() {
        return Researcher;
    }

    public String getDepartment() {
        return Department;
    }
}
