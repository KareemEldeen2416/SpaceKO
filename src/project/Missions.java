/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.Mission;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    AnchorPane pane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Missions window opens");
    }
    
    public void addMission(){
        Mission mission = new Mission(missionName.getText(),0,Integer.parseInt(missionLeader.getText()),Float.parseFloat(missionBudget.getText()));
        mission.addMission();
    }
    
    public void browseMission() throws SQLException{
        Mission mission = Mission.fetch(Integer.parseInt(browseMission.getText()));
        mNameLabel.setText(mission.getMissionName());
        mIDLabel.setText(browseMission.getText());
        mBudgetLabel.setText(String.valueOf(mission.getBudget()));
        mProgressLabel.setText(String.valueOf(mission.getMissionProgress()));
        mLeaderLabel.setText(String.valueOf(mission.getLeaderID()));
        mission = Mission.helperFetch(Integer.parseInt(browseMission.getText()));
        mReport.setText(mission.getReportContent());
    }
    
    public void SearchMission() throws SQLException{
        Mission mission = Mission.fetch(Integer.parseInt(searchMission.getText()));
        eName.setText(mission.getMissionName());
        eProgress.setText(String.valueOf(mission.getMissionProgress()));
        eLeader.setText(String.valueOf(mission.getLeaderID()));
        eBudget.setText(String.valueOf(mission.getBudget()));
    }
    
    public void editMission(){
        Mission mission = new Mission(eName.getText(),Integer.parseInt(eProgress.getText()),Integer.parseInt(eLeader.getText()),Float.parseFloat(eBudget.getText()));
        mission.edit(Integer.parseInt(searchMission.getText()));
    }
    
    public void deleteMission(){
        Mission.delete(Integer.parseInt(searchMission.getText()));
        for(Object o : pane.getChildren()){
            if(o instanceof TextField){
                ((TextField)o).clear();
            }
        }
    }
}
