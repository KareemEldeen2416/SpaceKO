/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.Mission;
import EntityClasses.myTools;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author KareemEldeen
 */
public class Missions implements Initializable{
    
    @FXML
    TextField missionName,missionLeader,missionBudget,browseMission,searchMission,eName,eProgress,eLeader,eBudget;
    @FXML
    Label mNameLabel,mBudgetLabel,mLeaderLabel,mIDLabel,mProgressLabel;
    @FXML
    TextArea mReport;
    @FXML
    AnchorPane pane,addPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Missions window opens");
    }
    
    public void addMission(){
      try{
        Mission mission = new Mission(missionName.getText(),0,Integer.parseInt(missionLeader.getText()),Float.parseFloat(missionBudget.getText()));
        mission.addMission();
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","ADD OPERATION IS SUCCESS","Mission Added Successfully");
        myTools.clearTextField(addPane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","ADD OPERATION IS FAILURE");
      }
    }
    
    public void browseMission() throws SQLException{
        
      try{
        Mission mission = Mission.fetch(Integer.parseInt(browseMission.getText()));
        mNameLabel.setText(mission.getMissionName());
        mIDLabel.setText(browseMission.getText());
        mBudgetLabel.setText(String.valueOf(mission.getBudget()));
        mProgressLabel.setText(String.valueOf(mission.getMissionProgress()));
        mLeaderLabel.setText(String.valueOf(mission.getLeaderID()));
        mission = Mission.helperFetch(Integer.parseInt(browseMission.getText()));
        mReport.setText(mission.getReportContent());
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","WRONG INPUT","ID May Be Wrong");
      }
    }
    
    public void SearchMission() throws SQLException{
      try{
        Mission mission = Mission.fetch(Integer.parseInt(searchMission.getText()));
        eName.setText(mission.getMissionName());
        eProgress.setText(String.valueOf(mission.getMissionProgress()));
        eLeader.setText(String.valueOf(mission.getLeaderID()));
        eBudget.setText(String.valueOf(mission.getBudget()));
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","WRONG INPUT","ID May Be Wrong");
      }  
    }
    
    public void editMission(){
      try{
        Mission mission = new Mission(eName.getText(),Integer.parseInt(eProgress.getText()),Integer.parseInt(eLeader.getText()),Float.parseFloat(eBudget.getText()));
        mission.edit(Integer.parseInt(searchMission.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL EDIT OPERATION","Mission Edit Successfully");
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","EDIT OPERATION IS FAILURE");
      }
    }
    
    public void deleteMission(){
        try{
            Mission.delete(Integer.parseInt(searchMission.getText()));
            myTools.clearTextField(pane);
            myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","DELTE OPERATION IS SUCCESS","Mission Deleted Successfully");

        }catch(Exception e){
            myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","MISSION DELET IS FAILURE");
        }
    }
}
