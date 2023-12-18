/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.Project;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author KareemEldeen
 */
public class Projects implements Initializable{
    
    @FXML
    TextField pName,leaderName,budget;
    @FXML
    TextArea target;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Projects window opens");
    }
    
    public void addProject(){
        Project p = new Project(pName.getText(),leaderName.getText(),target.getText(),13000.0f);
        p.addProject();
    }
    
}
