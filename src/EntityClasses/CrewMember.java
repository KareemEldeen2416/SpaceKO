/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityClasses;


import DBConnection.DbConnection;

public class CrewMember {
    
    private int memberID;
    private String memberName;
    private int missionID;
    
    public CrewMember(int missionID, String memberName){
        this.missionID = missionID;
        this.memberName = memberName;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getMissionID() {
        return missionID;
    }

    public void setMissionID(int missionID) {
        this.missionID = missionID;
    }
    
    
    public void addCrewMember(){
//        
        if(DbConnection.executeQuery("insert into crewmember (memberName,missionID) values(\""+this.memberName+"\",\""+this.missionID+"\");")){
            System.out.println("A new Crew member added");
        }else{
            System.out.println("Error");
        }
    }
}
