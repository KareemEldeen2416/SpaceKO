/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import DBConnection.DbConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author KareemEldeen
 */
public class SystemUser implements Initializable{

    @FXML
    TextField fullNameInput,jobTitleInput,userNameInput,idInput;
    @FXML
    PasswordField passInput;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("System users shown");
    }
    
    public void addUser(){
        DbConnection.addUser(Integer.parseInt(idInput.getText()),fullNameInput.getText(),jobTitleInput.getText(),userNameInput.getText(),passInput.getText());
    }
    
}
