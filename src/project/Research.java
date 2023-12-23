/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.Researcher;
import EntityClasses.Researchs;
import EntityClasses.myTools;
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
public class Research implements Initializable{
    
    @FXML
    TextField browseResearcher,reName,ereName,sr,browseResearch,researchName,reID,sre,eres,eresReID;
    @FXML
    Label researcherName,researcherID,resName,resID,resRe,resReID;
    @FXML
    AnchorPane rePane,sePane,addResPane,addRePane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Research window opens");
    }
    
    public void browseResearch() throws SQLException{
      try{
        Researchs r = Researchs.fetch(Integer.parseInt(browseResearch.getText()));
        resName.setText(r.getResearchName());
        resID.setText(browseResearch.getText());
        resRe.setText(r.getResearcherName());
        resReID.setText(String.valueOf(r.getResearcherID()));
      }catch(Exception e){
        myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the research");
      }
    }
    
    public void addResearch(){
      try{
        Researchs r = new Researchs(researchName.getText(),Integer.parseInt(reID.getText()));
        r.add();
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL ADD OPERATION","Research Added Successfully");
        myTools.clearTextField(addResPane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","ADD OPERATION FAILED");
      }
    }
    
    public void searchResearch() throws SQLException{
      try{
        Researchs r = Researchs.fetch(Integer.parseInt(sre.getText()));
        eres.setText(r.getResearchName());
        eresReID.setText(String.valueOf(r.getResearcherID()));
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the research");
      }
    }
    
    
    public void editResearch(){
      try{
        Researchs r = new Researchs(eres.getText(), Integer.parseInt(eresReID.getText()));
        r.edit(Integer.parseInt(sre.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL EDIT OPERATION","Research Edited Successfully");

      }catch(Exception e){
        myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","EDIT OPERATION FAILED");
      }
    }
    
    public void deleteResearch(){
      try{
        Researchs.delete(Integer.parseInt(sre.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL DELETE OPERATION","Research Deleted Successfully");
        myTools.clearTextField(sePane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","DELETE OPERATION FAILED");
      }
    }
    
    public void browseResearcher() throws SQLException{
      try{
        Researcher r = Researcher.fetch(Integer.parseInt(browseResearcher.getText()));
        researcherName.setText(r.getName());
        researcherID.setText(browseResearcher.getText());
      }catch(Exception e){
        myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the researcher");
      }
    }
    
    public void searchResearcher() throws SQLException{
      try{
        Researcher r = Researcher.fetch(Integer.parseInt(sr.getText()));
        ereName.setText(r.getName());
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the researcher");
      }
    }
    
    public void addResearcher(){
      try{
        Researcher r = new Researcher(reName.getText());
        r.add();
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL ADD OPERATION","Researcher Added Successfully");
        myTools.clearTextField(addRePane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","ADD OPERATION FAILED");
      }
    }
    
    public void editResearcher(){
      try{
        Researcher r = new Researcher(ereName.getText());
        r.edit(Integer.parseInt(sr.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL EDIT OPERATION","Researcher Edited Successfully");

      }catch(Exception e){
        myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","EDIT OPERATION FAILED");
      }
    }
    
    public void deleteResearcher(){
      try{
        Researcher.delete(Integer.parseInt(sr.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL DELETE OPERATION","Research Deleted Successfully");
        myTools.clearTextField(rePane);
      }catch(Exception e){
        myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","DELETE OPERATION FAILED");
      }
    }
    
    
    
    
    
    
}
