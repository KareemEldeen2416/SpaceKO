/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.Mission;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author KareemEldeen
 */
public class Missions implements Initializable{
    
    @FXML
    TextField missionName,missionLeader,missionBudget,reportID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Missions window opens");
    }
    
    public void addMission(){
        Mission mission = new Mission(missionName.getText(),0,missionLeader.getText(),Float.parseFloat(missionBudget.getText()),Integer.parseInt(reportID.getText()));
        mission.addMission();
    }
    
}
