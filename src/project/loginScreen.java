/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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
        userNameInput.setText("From the class");
    }
    
    public void loginAction(){
        System.out.println("Action taken");
    }
    
}
