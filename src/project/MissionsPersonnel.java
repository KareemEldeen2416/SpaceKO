/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import DBConnection.DbConnection;
import EntityClasses.Astronaut;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author KareemEldeen
 */
public class MissionsPersonnel implements Initializable{
    
    @FXML
    TextField astroName,missionNo;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Missions Personnel window opens");
    }
    
    public void addAstronaut(){
        Astronaut astro = new Astronaut(astroName.getText(),Integer.parseInt(missionNo.getText()));
        astro.addAstronaut();
    }
    
}
