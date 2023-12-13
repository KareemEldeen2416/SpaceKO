public class Mission {
    // Private attributes specific to the Mission class
    private String MissionName;     // Name or title of the mission
    private int MissionId;          // Unique identifier for the mission
    private int MissionProgress;    // Progress of the mission
    private String Leader;          // Leader or manager of the mission
    private Float Budget;           // Budget allocated for the mission
    private Report Report;          // Report object containing information about the mission

    // Constructor for creating a Mission object
    public Mission(String MissionName, int MissionId, int MissionProgress, String Leader, Float Budget, Report Report) {
        this.MissionName = MissionName;
        this.MissionId = MissionId;
        this.MissionProgress = MissionProgress;
        this.Leader = Leader;
        this.Budget = Budget;
        this.Report = Report;
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

    public void setReport(Report Report) {
        this.Report = Report;
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

    public Report getReport() {
        return Report;
    }
}
