public class Report {
    // Private attributes specific to the Report class
    private  int ReportNumber;               // Unique identifier for the report
    private  String Title;                 // Title of the report
    private  String Author;                // Author of the report
    private  String Content;                 // Content or body of the report

    // Constructor for creating a Report object
    public Report(int ReportNumber,String Title,String Author,String Content){
        this.ReportNumber=ReportNumber;
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
}
