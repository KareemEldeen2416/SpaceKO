/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import DBConnection.DbConnection;
import EntityClasses.Report;
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
public class Reports implements Initializable{
    
    @FXML
    TextField reportTitle,author;
    @FXML
    TextArea content;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Reports window opens");
    }
    
    
    public void addReport(){
        Report report = new Report(reportTitle.getText() , author.getText(),content.getText());
        report.addReport();
    }
    
}
