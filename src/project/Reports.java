/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import DBConnection.DbConnection;
import EntityClasses.Report;
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
public class Reports implements Initializable{
    
    @FXML
    TextField browseReport,reportTitle,author,missionID,searchReport,eTitle,eAuthor;
    @FXML
    TextArea content,eContent,rContent;
    @FXML
    AnchorPane addPane,pane;
    @FXML
    Label rTitle,rID,rAuthor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Reports window opens");
    }
    
    
    
    
    public void searchReport() throws SQLException{
      try{
            Report report = Report.fetch(Integer.parseInt(searchReport.getText()));
            eTitle.setText(report.getTitle());
            eAuthor.setText(report.getAuthor());
            eContent.setText(report.getContent());
        }catch(Exception e){
            myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the report");
        }
    }
    
    public void browseReport(){
        try{
            Report report = Report.fetch(Integer.parseInt(browseReport.getText()));
            rTitle.setText(report.getTitle());
            rID.setText(browseReport.getText());
            rAuthor.setText(report.getAuthor());
            rContent.setText(report.getContent());
        }catch(Exception e){
            myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the report");
        }
    }
    
    
    public void addReport(){
      try{
        Report report = new Report(reportTitle.getText(),author.getText(),content.getText(),Integer.parseInt(missionID.getText()));
        report.addReport();
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL ADD OPERATION","Report Added Successfully");
        myTools.clearTextArea(addPane);
        myTools.clearTextField(addPane);

      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","ADD OPERATION FAILED");
      }
    }
    
    public void editReport(){
        try{
            Report report = new Report(eTitle.getText(), eAuthor.getText(), eContent.getText());
            report.edit(Integer.parseInt(searchReport.getText()));
            myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL EDIT OPERATION","Report Edited Successfully");

        }catch(Exception e){
            myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","EDIT OPERATION FAILED");

        }
    }
    
    public void deleteReport(){
        try{
            Report.delete(Integer.parseInt(searchReport.getText()));
            myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","DELETE DELETE OPERATION","Report Deleted Successfully");
            myTools.clearTextArea(pane);
            myTools.clearTextField(pane);
        }catch(Exception e){
        
        }
    }
    
}
