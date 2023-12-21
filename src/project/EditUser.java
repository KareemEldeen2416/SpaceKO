/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        User user = User.fetchUser(Integer.parseInt(searchInput.getText()));
        fullName.setText(user.getFullName());
        userName.setText(user.getUserName());
        password.setText(user.getPassword());
    }
    public void editUser(){
        User user = new User(fullName.getText(),userName.getText(),password.getText());
        user.editUser(Integer.parseInt(searchInput.getText()));
    }
    
    public void deleteUser(){
        User.deleteUser(Integer.parseInt(searchInput.getText()));
        for(Object o : pane.getChildren()){
            if(o instanceof TextField){
                ((TextField) o).clear();
            }
            if(o instanceof PasswordField){
                ((PasswordField)o).clear();
            }
        }
    }
    
}
