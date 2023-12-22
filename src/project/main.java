/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class main implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("main screen shown");
    }
    
    private void createStage(String fxmlName,String title) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlName));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }
    
    
    public void showAddUser(ActionEvent e) throws IOException{
        createStage("SystemUser.fxml","Add System User");
    }
    
    public void showEditUser() throws IOException{
        createStage("EditUser.fxml","Edit System User");
    }
    
    public void showMissionsPersonnel() throws IOException{
        createStage("MissionsPersonnel.fxml","Missions Personnel");
    }
    
    public void showReports() throws IOException{
        createStage("Reports.fxml","Reports");
    }
    
    public void showResearchs() throws IOException{
        createStage("Research.fxml","Researchs");
    }
    
    public void showMissions() throws IOException{
        createStage("Missions.fxml","Missions");
    }
    
    public void showProjects() throws IOException{
        createStage("Projects.fxml","Projects");
    }
    
    public void showLaunchVehicles() throws IOException{
        createStage("LaunchVehicles.fxml","Launch Vehicles");
    }
    
    
    
    
}
