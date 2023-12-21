/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author KareemEldeen
 */
public class loginScreen implements Initializable{
    
    @FXML
    TextField userNameInput;
    @FXML
    TextField passwordInput;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Login screen opened");
    }
    
    public void loginAction() throws SQLException, IOException{
        User user = new User(userNameInput.getText(),passwordInput.getText());
        if(user.checkUser()){
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }else{
            System.out.println("Wrong username or password");
        }
    }
    
}
