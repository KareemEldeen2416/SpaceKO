
package EntityClasses;

import DBConnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Mission {
    // Private attributes specific to the Mission class
    private String MissionName;     // Name or title of the mission
    private int MissionId;          // Unique identifier for the mission
    private int MissionProgress;    // Progress of the mission
    private Float Budget;           // Budget allocated for the mission
    private int leaderID;          // Report object containing information about the mission
    private String reportContent;

    // Constructor for creating a Mission object
    public Mission(String MissionName, int MissionProgress,int leaderID, Float Budget) {
        this.MissionName = MissionName;
        this.MissionProgress = MissionProgress;
        this.leaderID = leaderID;
        this.Budget = Budget;
    }
    
    public Mission(String reportContent){
        this.reportContent = reportContent;
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

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
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
    
    public static Mission fetch(int id) throws SQLException{
//        SELECT * from mission inner join astronaut on mission.astroID = astronaut.astroID where missionID = 2;
      ResultSet rs = DbConnection.executeFetchQuery("select * from mission inner join astronaut on mission.astroID = astronaut.astroID where missionID = "+id+";");
      if(rs.next()){
          return new Mission(rs.getString("missionName"),rs.getInt("missionProgress"),rs.getInt("astroID"),rs.getFloat("missionBudget"));
      }else{
          return null;
      }
    }
    
    public static Mission helperFetch(int id) throws SQLException{
        ResultSet rs = DbConnection.executeFetchQuery("select * from mission inner join report on report.missionID = mission.missionID where mission.missionID = "+id+";");
        if(rs.next()){
            return new Mission(rs.getString("reportContent"));
        }else{return null;}
    }
    
    public void edit(int id){
        if(DbConnection.executeQuery("update mission set missionName = \""+this.MissionName+"\", missionProgress = "+this.MissionProgress+",missionBudget = "+this.Budget+",astroID = "+this.leaderID+" where missionID = "+id+";")){
            System.out.println("Mission Edited Successfully");
        }else{
            System.out.println("Mission Edition Failed");
        }
    }
    
    public static void delete(int id){
        if(DbConnection.executeQuery("delete from report where missionID = "+id+";")){
            if(DbConnection.executeQuery("update crewmember set missionID = 0 where missionID = "+id+";")){
                if(DbConnection.executeQuery("delete from mission where missionID = "+id+";")){
                    System.out.println("Mission Deleted Successfully");
                }
            }else{
                System.out.println("Mission Deletion Failed");
            }
        }
    }
}
