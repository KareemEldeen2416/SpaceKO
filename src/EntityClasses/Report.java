
package EntityClasses;

import DBConnection.DbConnection;
public class Report {
    // Private attributes specific to the Report class
    private  int ReportNumber;               // Unique identifier for the report
    private  String Title;                 // Title of the report
    private  String Author;                // Author of the report
    private  String Content;                 // Content or body of the report

    // Constructor for creating a Report object
    public Report(String Title,String Author,String Content){
  
        this.Title=Title;
        this.Author=Author;
        this.Content=Content;

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
        if(DbConnection.executeQuery("insert into report (Report_Author,Report_Title,Report_String) values (\""+this.Author+"\",\""+this.Title+"\",\""+this.Content+"\");")){
            System.out.println("A new report added");
        }else{
            System.out.println("Error");
        }
    }
}
