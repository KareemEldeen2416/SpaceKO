
package EntityClasses;

import DBConnection.DbConnection;
public class Mission {
    // Private attributes specific to the Mission class
    private String MissionName;     // Name or title of the mission
    private int MissionId;          // Unique identifier for the mission
    private int MissionProgress;    // Progress of the mission
    private Float Budget;           // Budget allocated for the mission
    private int leaderID;          // Report object containing information about the mission

    // Constructor for creating a Mission object
    public Mission(String MissionName, int MissionProgress,int leaderID, Float Budget) {
        this.MissionName = MissionName;
        this.MissionProgress = MissionProgress;
        this.leaderID = leaderID;
        this.Budget = Budget;
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

    

    public void setBudget(Float Budget) {
        this.Budget = Budget;
    }

    public int getLeaderID() {
        return leaderID;
    }

    public void setLeaderID(int leaderID) {
        this.leaderID = leaderID;
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

    

    public Float getBudget() {
        return Budget;
    }

    
    
//    insert into mission (Mission_Name,Mission_Leader,Mission_Budget,Mission_Progress,FK_Report_ID) values ("Mars Exploration","Omar",25000.0,0,2);
    
//    insert into mission (missionName,missionBudget,missionProgress,astroID) VALUES ("Mars Exploration",2000.0.,0,1);
    public void addMission(){
        if(DbConnection.executeQuery("insert into mission (missionName,missionBudget,missionProgress,astroID) values (\""
                +this.MissionName+"\",\""+this.Budget+"\","+0+","+this.leaderID+");"
        )){
            System.out.println("A New Mission Added Successfully");
        }else{
            System.out.println("Adding A Mission Was A Failure");
        }
    }
}
