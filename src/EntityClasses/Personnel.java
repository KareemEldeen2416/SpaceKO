package EntityClasses;


import DBConnection.DbConnection;

// Class representing personnel
public class Personnel {
    // Private member variables to store personnel information
     private int Id;
     private  String Name;
     private  String JobTitle;
     private String UserName;
     private String Password;

    // Constructor to initialize personnel information
    public  Personnel(String name,String jobTitle,String userName,String password){
         this.Name=name;
         this.JobTitle=jobTitle;
         this.UserName=userName;
         this.Password=password;
     }

    // Setter methods to update personnel information
    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setJobTitle(String JobTitle) {
        this.JobTitle = JobTitle;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }


    // Getter methods to retrieve personnel information
    public int getId(){
          return Id;
     }
     public String getName(){
          return Name;
     }

     public String getJobTitle() {
          return JobTitle;
     }

     public String getUserName() {
          return UserName;
     }

    public String getPassword() {
        return Password;
    }
    
    public void addSystemUser(){
        if(DbConnection.executeQuery("insert into")){
            System.out.println("A new report added");
        }else{
            System.out.println("Error");
        }
    }
}
