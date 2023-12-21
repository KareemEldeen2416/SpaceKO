/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.Project;
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
public class Projects implements Initializable{
    
    @FXML
    TextField pName,budget,searchProject,searchEProject,epName,epBudget;
    @FXML
    TextArea target,epTarget;
    @FXML
    Label pname,pno,ptarget,pbudget;
    @FXML
    AnchorPane pane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Projects window opens");
    }
    
    public void addProject(){
        Project p = new Project(pName.getText(), target.getText(), Float.parseFloat(budget.getText()));
        p.addProject();
    }
    
    public void browseProject() throws SQLException{
        Project p = Project.fetchProject(Integer.parseInt(searchProject.getText()));
        pname.setText(p.getProjectName());
        pno.setText(searchProject.getText());
        ptarget.setText(p.getTarget());
        pbudget.setText(String.valueOf(p.getBudget()));
        
    }
    
    public void searchProject() throws SQLException{
        Project p = Project.fetchProject(Integer.parseInt(searchEProject.getText()));
        epName.setText(p.getProjectName());
        epBudget.setText(String.valueOf(p.getBudget()));
        epTarget.setText(p.getTarget());
    }
    
    public void editProject(){
        Project p = new Project(epName.getText(),epTarget.getText(), Float.parseFloat(epBudget.getText()));
        p.edit(Integer.parseInt(searchEProject.getText()));
    }
    
    public void deleteProject(){
        Project p = new Project(epName.getText(),epTarget.getText(), Float.parseFloat(epBudget.getText()));
        p.delete(Integer.parseInt(searchEProject.getText()));
        for(Object o : pane.getChildren()){
            if(o instanceof TextField){
                ((TextField)o).clear();
            }
            if(o instanceof TextArea){
                ((TextArea)o).clear();
            }
        }
    }
}
