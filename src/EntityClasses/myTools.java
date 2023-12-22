/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityClasses;

import com.jfoenix.controls.JFXToggleButton;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author KareemEldeen
 */
public class myTools {
    
    public static void clearTextField(AnchorPane pane){
        for(Object o : pane.getChildren()){
            if(o instanceof TextField){
                ((TextField)o).clear();
            }
        }
    }
    
    public static void clearTextArea(AnchorPane pane){
        for(Object o : pane.getChildren()){
            if(o instanceof TextArea){
                ((TextArea)o).clear();
            }
        }
    }
    
    public static void clearPasswordField(AnchorPane pane){
        for(Object o : pane.getChildren()){
            if(o instanceof PasswordField){
                ((PasswordField)o).clear();
            }
        }
    }
    
    public static void unsetToggleButton(AnchorPane pane){
        for(Object o : pane.getChildren()){
            if(o instanceof JFXToggleButton){
                ((JFXToggleButton)o).setSelected(false);
            }
        }
    }
    
    public static void showMessage(Alert.AlertType type,String alertTitle,String alertHeader,String msg){
        Alert alert = new Alert(type);
        alert.setTitle(alertTitle);
        alert.setHeaderText(alertHeader);
        alert.setContentText(msg);
        alert.show();
    }
    
}
