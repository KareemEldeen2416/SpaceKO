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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author KareemEldeen
 */
public class MissionsPersonnel implements Initializable{
    
    @FXML
    TextField astroName,crewMemberName,crewMissionID,searchAstro,searchEAstro,eAstroName,browseMember,searchCrewMember,emissionID,ememberName;
    @FXML
    Label nameLabel,astroID,missionName,missionID,memberName,memberMissionName,memberMissionID;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Missions Personnel window opens");
        DbConnection.executeQuery("select * from mission");
    }
    
    public void addAstronaut(){
       Astronaut astro = new Astronaut(astroName.getText());
       astro.addAstronaut();
    }
    
    public void browseAstronaut() throws SQLException{
        Astronaut astro = Astronaut.fetch(Integer.parseInt(searchAstro.getText()));
        nameLabel.setText(astro.getAstroName());
        astroID.setText(searchAstro.getText());
        missionName.setText(astro.getMissionName());
        missionID.setText(String.valueOf(astro.getMissionID()));
    }
    
    public void searchAstronaut() throws SQLException{
        Astronaut astro = Astronaut.fetch(Integer.parseInt(searchEAstro.getText()));
        eAstroName.setText(astro.getAstroName());
    }
    
    public void editAstronaut(){
        Astronaut astro = new Astronaut(eAstroName.getText());
        astro.edit(Integer.parseInt(searchEAstro.getText()));
    }
    
    public void deleteAstronaut(){
        Astronaut astro = new Astronaut(eAstroName.getText());
        astro.delete(Integer.parseInt(searchEAstro.getText()));
    }
    
    public void addCrewMember(){
        CrewMember member = new CrewMember(crewMemberName.getText(),Integer.parseInt(crewMissionID.getText()));
        member.addCrewMember();
    }
    
    public void browseCrewMember() throws SQLException{
        CrewMember member = CrewMember.fetch(Integer.parseInt(browseMember.getText()));
        memberName.setText(member.getMemberName());
        memberMissionName.setText(member.getMissionName());
        memberMissionID.setText(String.valueOf(member.getMissionID()));
    }
    
    public void searchCrewMember() throws SQLException{
        CrewMember member = CrewMember.fetch(Integer.parseInt(searchCrewMember.getText()));
        ememberName.setText(member.getMemberName());
        emissionID.setText(String.valueOf(member.getMissionID()));
    }
    
    public void editCrewMember(){
        CrewMember member = new CrewMember(ememberName.getText(),Integer.parseInt(emissionID.getText()));
        member.edit(Integer.parseInt(searchCrewMember.getText()));
    }
    
    public void deleteCrewMember(){
        CrewMember member = new CrewMember(ememberName.getText(),Integer.parseInt(emissionID.getText()));
        member.delete(Integer.parseInt(searchCrewMember.getText()));
    }
    
    
    
    
    
}
