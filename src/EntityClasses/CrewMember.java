/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityClasses;


import DBConnection.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrewMember {
    
    private int memberID;
    private String memberName;
    private int missionID;
    private String missionName;
    
    public CrewMember(String memberName , int missionID){
        this.missionID = missionID;
        this.memberName = memberName;
    }
    
    public CrewMember(String memberName,String missionName,int memberID,int missionID){
        this.memberName = memberName;
        this.missionName = missionName;
        this.memberID = memberID;
        this.missionID = missionID;
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

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }
    
    
    
    public void addCrewMember(){
//        insert into crewmember (memberName,missionID) VALUES ("Luis",1);
        if(DbConnection.executeQuery("insert into crewmember (memberName,missionID) VALUES (\""+this.memberName+"\","+this.missionID+");")){
            System.out.println("A New Crew Member Added Successfully");
        }else{
            System.out.println("Crew Member Addition Was Failure");
        }
    }
    
    public static CrewMember fetch(int id) throws SQLException{
//        select * from crewmember inner join mission on mission.missionID = crewmember.missionID where crewmember.memeberID =1;
        ResultSet rs = DbConnection.executeFetchQuery("select * from crewmember inner join mission on mission.missionID = crewmember.missionID where crewmember.memeberID = "+id+";");
        if(rs.next()){
            return new CrewMember(rs.getString("memberName"),rs.getString("missionName"),rs.getInt("memeberID"),rs.getInt("missionID"));
        }else{
            return null;
        }
    }
    
    public void edit(int id){
        if(DbConnection.executeQuery("update crewmember set memberName = \""+this.memberName+"\",missionID = "+this.missionID+" where memeberID ="+id+";")){
            System.out.println("Crew Member Edited Successfully");
        }else{
            System.out.println("Crew Member Edition Failed");
        }
    }
    
    public void delete(int id){
        if(DbConnection.executeQuery("delete from crewmember where memeberID = "+id+";")){
            System.out.println("A Crew Member Deleted Successfully");
        }else{
            System.out.println("Crew Member Deletion Failed");
        }
    }
    
}
