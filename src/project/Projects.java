/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.Project;
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
public class Projects implements Initializable{
    
    @FXML
    TextField pName,budget,searchProject,searchEProject,epName,epBudget;
    @FXML
    TextArea target,epTarget;
    @FXML
    Label pname,pno,ptarget,pbudget;
    @FXML
    AnchorPane pane,addPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Projects window opens");
    }
    
    public void addProject(){
      try{  
        Project p = new Project(pName.getText(), target.getText(), Float.parseFloat(budget.getText()));
        p.addProject();
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL ADD OPERATION","Project Added Successfully");
        myTools.clearTextField(addPane);
        myTools.clearTextArea(addPane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","ADD OPERATION FAILED");
      } 
    }
    
    public void browseProject() throws SQLException{
      try{
        Project p = Project.fetchProject(Integer.parseInt(searchProject.getText()));
        pname.setText(p.getProjectName());
        pno.setText(searchProject.getText());
        ptarget.setText(p.getTarget());
        pbudget.setText(String.valueOf(p.getBudget()));
      }catch(Exception e){
            myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the project");
      }
        
    }
    
    public void searchProject() throws SQLException{
      try{
        Project p = Project.fetchProject(Integer.parseInt(searchEProject.getText()));
        epName.setText(p.getProjectName());
        epBudget.setText(String.valueOf(p.getBudget()));
        epTarget.setText(p.getTarget());
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the project");
      }
    }
    
    public void editProject(){
      try{
        Project p = new Project(epName.getText(),epTarget.getText(), Float.parseFloat(epBudget.getText()));
        p.edit(Integer.parseInt(searchEProject.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL EDIT OPERATION","Project Edited Successfully");

      }catch(Exception e){
           myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","EDIT OPERATION IS FAILURE");
      }
    }
    
    public void deleteProject(){
      try{
        Project p = new Project(epName.getText(),epTarget.getText(), Float.parseFloat(epBudget.getText()));
        p.delete(Integer.parseInt(searchEProject.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL DELETE OPERATION","Project Deleted Successfully");
        myTools.clearTextField(pane);
        myTools.clearTextArea(pane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","EDIT OPERATION IS FAILURE");
      }  
    }
}
