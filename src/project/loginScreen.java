/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.User;
import EntityClasses.myTools;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    
    int counter = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Login screen opened");
    }
    
    public void loginAction(ActionEvent e) throws SQLException, IOException{
        
        User user = new User(userNameInput.getText(),passwordInput.getText());
        if(user.checkUser()){
            Node source = (Node)(e.getSource());
            Stage stg = (Stage)(source.getScene().getWindow());
            stg.close();
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Main Screen");
            stage.show();
        }else{
            counter++;
            if(counter == 5){
               Node source = (Node)(e.getSource());
               Stage stg = (Stage)(source.getScene().getWindow());
               stg.close();
               myTools.showMessage(Alert.AlertType.ERROR,"Forbidden Access","NO ACCESS","You Have Exceeded 5 Tries, You No Longer Can Access The System");
            }else{
               myTools.showMessage(Alert.AlertType.WARNING,"Unauthorized","Warning","Wrong Password Or User Name \n Try again");
            }
        }
    }
    
}
