
package EntityClasses;

import DBConnection.DbConnection;
public class Mission {
    // Private attributes specific to the Mission class
    private String MissionName;     // Name or title of the mission
    private int MissionId;          // Unique identifier for the mission
    private int MissionProgress;    // Progress of the mission
    private String Leader;          // Leader or manager of the mission
    private Float Budget;           // Budget allocated for the mission
    private int ReportID;          // Report object containing information about the mission

    // Constructor for creating a Mission object
    public Mission(String MissionName, int MissionProgress, String Leader, Float Budget, int ReportID) {
        this.MissionName = MissionName;
        this.MissionProgress = MissionProgress;
        this.Leader = Leader;
        this.Budget = Budget;
        this.ReportID = ReportID;
    }

    // Setter methods for updating the values of attributes
    public void setMissionName(String MissionName) {
        this.MissionName = MissionName;
    }

    public void setMissionId(int MissionId) {
        this.MissionId = MissionId;
    }

    public void setMissionProgress(int MissionProgress) {
        this.MissionProgress = MissionProgress;
    }

    public void setLeader(String Leader) {
        this.Leader = Leader;
    }

    public void setBudget(Float Budget) {
        this.Budget = Budget;
    }

    public void setReport(int ReportID) {
        this.ReportID = ReportID;
    }

    // Getter methods for retrieving the values of attributes
    public String getMissionName() {
        return MissionName;
    }

    public int getMissionId() {
        return MissionId;
    }

    public int getMissionProgress() {
        return MissionProgress;
    }

    public String getLeader() {
        return Leader;
    }

    public Float getBudget() {
        return Budget;
    }

    public int getReport() {
        return ReportID;
    }
    
//    insert into mission (Mission_Name,Mission_Leader,Mission_Budget,Mission_Progress,FK_Report_ID) values ("Mars Exploration","Omar",25000.0,0,2);
    public void addMission(){
        if(DbConnection.executeQuery("insert into mission (Mission_Name,Mission_Leader,Mission_Budget,Mission_Progress,FK_Report_ID) values (\""
                +this.MissionName+"\",\""+this.Leader+"\",\""+this.Budget+"\",\""+this.MissionProgress+"\",\""+this.ReportID+"\");")){
            System.out.println("A new Mission added");
        }else{
            System.out.println("Error");
        }
    }
}
