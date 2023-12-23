/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import DBConnection.DbConnection;
import EntityClasses.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author KareemEldeen
 */
public class MissionsPersonnel implements Initializable{
    
    @FXML
    TextField astroName,crewMemberName,crewMissionID,searchAstro,searchEAstro,eAstroName,browseMember,searchCrewMember,emissionID,ememberName;
    @FXML
    Label nameLabel,astroID,missionName,missionID,memberName,memberMissionName,memberMissionID;
    @FXML
    AnchorPane addAstroPane,astroPane,memberPane,addMemberPane;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Missions Personnel window opens");
        DbConnection.executeQuery("select * from mission");
    }
    
    public void addAstronaut(){
       try{
        Astronaut astro = new Astronaut(astroName.getText());
        astro.addAstronaut();
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL ADD OPERATION","Astronaut Added Successfully");
        myTools.clearTextField(addAstroPane);
       }catch(Exception e){  
           myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","ADD OPERATION FAILED");
       }
    }
    
    public void browseAstronaut() throws SQLException{
      try{
        Astronaut astro = Astronaut.fetch(Integer.parseInt(searchAstro.getText()));
        nameLabel.setText(astro.getAstroName());
        astroID.setText(searchAstro.getText());
        missionName.setText(astro.getMissionName());
        missionID.setText(String.valueOf(astro.getMissionID()));
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not fine the astronaut");
      }
    }
    
    public void searchAstronaut() throws SQLException{
      try{
        Astronaut astro = Astronaut.fetch(Integer.parseInt(searchEAstro.getText()));
        eAstroName.setText(astro.getAstroName());
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not fine the astronaut");
      }
    }
    
    public void editAstronaut(){
      try{
        Astronaut astro = new Astronaut(eAstroName.getText());
        astro.edit(Integer.parseInt(searchEAstro.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL EDIT OPERATION","Astronaut Edited Successfully");

      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","EDIT OPERATION FAILED");
      }
    }
    
    public void deleteAstronaut(){
      try{
        Astronaut astro = new Astronaut(eAstroName.getText());
        astro.delete(Integer.parseInt(searchEAstro.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL DELETE OPERATION","Astronaut Deleted Successfully");
        myTools.clearTextField(astroPane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","DELETE OPERATION FAILED");
      }
    }
    
    public void addCrewMember(){
      try{
        CrewMember member = new CrewMember(crewMemberName.getText(),Integer.parseInt(crewMissionID.getText()));
        member.addCrewMember();
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL ADD OPERATION","Crew Member Added Successfully");
        myTools.clearTextField(addMemberPane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","ADD OPERATION FAILED");
      }
    }
    
    public void browseCrewMember() throws SQLException{
      try{
        CrewMember member = CrewMember.fetch(Integer.parseInt(browseMember.getText()));
        memberName.setText(member.getMemberName());
        memberMissionName.setText(member.getMissionName());
        memberMissionID.setText(String.valueOf(member.getMissionID()));
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not fine the crew member");
      }
    }
    
    public void searchCrewMember() throws SQLException{
      try{
        CrewMember member = CrewMember.fetch(Integer.parseInt(searchCrewMember.getText()));
        ememberName.setText(member.getMemberName());
        emissionID.setText(String.valueOf(member.getMissionID()));
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not fine the crew member");
      }
    }
    
    public void editCrewMember(){
      try{
        CrewMember member = new CrewMember(ememberName.getText(),Integer.parseInt(emissionID.getText()));
        member.edit(Integer.parseInt(searchCrewMember.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL EDIT OPERATION","Crew Member Edited Successfully");

      }catch(Exception e ){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","EDIT OPERATION FAILED");
      }
    }
    
    public void deleteCrewMember(){
      try{
        CrewMember member = new CrewMember(ememberName.getText(),Integer.parseInt(emissionID.getText()));
        member.delete(Integer.parseInt(searchCrewMember.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL DELETE OPERATION","Crew Member Deleted Successfully");
        myTools.clearTextField(memberPane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","DELETE OPERATION FAILED");
      }
    }
    
    
    
    
    
}
