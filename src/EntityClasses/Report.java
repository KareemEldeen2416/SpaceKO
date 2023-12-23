
package EntityClasses;

import DBConnection.DbConnection;
import java.sql.SQLException;
import java.sql.ResultSet;
public class Report {
    // Private attributes specific to the Report class
    private  int ReportNumber;               // Unique identifier for the report
    private  String Title;                 // Title of the report
    private  String Author;                // Author of the report
    private  String Content;// Content or body of the report
    private  int missionID;

    // Constructor for creating a Report object
    public Report(String Title,String Author,String Content,int missionID){
  
        this.Title=Title;
        this.Author=Author;
        this.Content=Content;
        this.missionID = missionID;

    }
    
    public Report(String Title,String Author,String Content){
  
        this.Title=Title;
        this.Author=Author;
        this.Content=Content;

        
    }

    public int getMissionID() {
        return missionID;
    }

    public void setMissionID(int missionID) {
        this.missionID = missionID;
    }
    
  
    // Setter methods for updating the values of attributes
    public void setReportNumber(int ReportNumber) {
        this.ReportNumber = ReportNumber;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    // Getter methods for retrieving the values of attributes
    public int getReportNumber() {
        return ReportNumber;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getContent() {
        return Content;
    }
    
    public void addReport(){
//        insert into report (reportTitle,reportAuthor,reportContent,missionID) values ("Missoin One","Issac","This is a report",1);
        if(DbConnection.executeQuery("insert into report (reportTitle,reportAuthor,reportContent,missionID) values (\""
                +this.Title+"\",\""+this.Author+"\",\""+this.Content+"\","+this.missionID+");"
        )){
            System.out.println("A New Report Added Successfully");
        }else{
            System.out.println("Report Addition Failure");
        }
    }
    
    
    public static Report fetch(int id) throws SQLException{
        ResultSet rs = DbConnection.executeFetchQuery("select * from report where reportID ="+id+";");
        if(rs.next()){
            return new Report(rs.getString("reportTitle"), rs.getString("reportAuthor"), rs.getString("reportContent"));
        }else{
            return null;
        }
    }
    
    public void edit(int id){
        if(DbConnection.executeQuery("update report set reportTitle = \""+this.Title+"\",reportAuthor=\""+this.Author+"\",reportContent =\""+this.Content+"\" where reportID = "+id+";")){
            System.out.println("Report Edited Successfully");
        }else{
            System.out.println("Report Edition Failed");
        }
    } 
    
    public static void delete(int id){
        if(DbConnection.executeQuery("delete from report where reportID = "+id+";")){
            System.out.println("Report Deleted Successfully");
        }else{
            System.out.println("Report Deletion Failed");
        }
    }
    
    
}
