/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.User;
import EntityClasses.myTools;
import java.net.URL;
import java.sql.SQLException;
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
public class EditUser implements Initializable{
    
    @FXML
    TextField searchInput,fullName,userName;
    @FXML
    PasswordField password;
    @FXML
    AnchorPane pane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Edit user window");
    }
    
    public void searchUser() throws SQLException{
        try{
            User user = User.fetchUser(Integer.parseInt(searchInput.getText()));
            fullName.setText(user.getFullName());
            userName.setText(user.getUserName());
            password.setText(user.getPassword());
        }catch(Exception e){
            myTools.showMessage(Alert.AlertType.WARNING,"Warning","NOT FOUND ID","Search for an existed ID.");
        }
    }
    public void editUser(){
        try{
            User user = new User(fullName.getText(),userName.getText(),password.getText());
            user.editUser(Integer.parseInt(searchInput.getText()));
            myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL EDIT OPERATION","User Edited Successfully");
        }catch(Exception e){
            myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","User Edit Is Failure");
        }
        
        }
    
    public void deleteUser(){
        try{
            User.deleteUser(Integer.parseInt(searchInput.getText()));
            myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL DELETE OPERATION","User Deleted Successfully");
            myTools.clearPasswordField(pane);
            myTools.clearTextField(pane);
        }catch(Exception e){
            myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Delete User Is Failure");
        }
    }
    
}
