/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import DBConnection.DbConnection;
import EntityClasses.User;
import EntityClasses.myTools;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author KareemEldeen
 */
public class SystemUser implements Initializable{

    @FXML
    TextField fullNameInput,userNameInput;
    @FXML
    PasswordField passInput;
    @FXML
    AnchorPane pane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("System users shown");
    }
    
    public void addUser(){
        try{
            User user = new User(fullNameInput.getText(),userNameInput.getText(),passInput.getText());
            user.addUser();
            myTools.clearTextField(pane);
            myTools.showMessage(Alert.AlertType.CONFIRMATION,"Add User","Successful!","User Added Successfully");
            
            
        }catch(Exception e){
            myTools.showMessage(Alert.AlertType.WARNING,"Warning","Add Operation Failed","Revise data types of all your inputs.");
        }
    }
    
    
}
