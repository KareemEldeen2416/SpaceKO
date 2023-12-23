/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.Gpsdata;
import EntityClasses.Rocket;
import EntityClasses.Satellite;
import EntityClasses.myTools;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author KareemEldeen
 */
public class LaunchVehicles implements Initializable{
    
    @FXML
    TextField satName,dest,x,y,browseSat,esn,esd,esx,esy,searchSat;
    @FXML
    TextField rName,rModel,browseRocket,searchRocket,erName,erModel;
    @FXML
    JFXToggleButton rAV,rVC,erAv,erVc;
    @FXML
    Label sNameLabel,sxLabel,syLabel,sIDLabel,sDestLabel;
    @FXML
    Label rnLabel,rmLabel,ravLabel,rvcLabel,ridLabel;
    @FXML
    AnchorPane pane,addSatPane,satPane,addRocketPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Launch Vehicles window opens");
    }
    
    public void addSatellite(){
      try{
        Gpsdata gps = new Gpsdata(dest.getText(),Float.parseFloat(x.getText()), Float.parseFloat(y.getText()));
        Satellite s = new Satellite(satName.getText(), gps);
        s.add();
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL ADD OPERATION","Satellite Added Successfully");
        myTools.clearTextField(addSatPane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","ADD OPERATION FAILED");
      }
    }
    public void browseSatellite() throws SQLException{
      try{
        Satellite s = Satellite.fetch(Integer.parseInt(browseSat.getText()));
        sNameLabel.setText(s.getSatName());
        sIDLabel.setText(browseSat.getText());
        sDestLabel.setText(s.getGpsdata().getDestinationName());
        sxLabel.setText(String.valueOf(s.getGpsdata().getX_axis()));
        syLabel.setText(String.valueOf(s.getGpsdata().getY_axis()));
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the satellite");
      }
    }
    
    public void searchSatellite() throws SQLException{
      try{
        Satellite s = Satellite.fetch(Integer.parseInt(searchSat.getText()));
        esn.setText(s.getSatName());
        esd.setText(s.getGpsdata().getDestinationName());
        esx.setText(String.valueOf(s.getGpsdata().getX_axis()));
        esy.setText(String.valueOf(s.getGpsdata().getY_axis()));
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the satellite");
      }
    }
    
    public void editSatellite(){
      try{
        Gpsdata gps = new Gpsdata(esd.getText(),Float.parseFloat(esx.getText()), Float.parseFloat(esy.getText()));
        Satellite s = new Satellite(esn.getText(),gps);
        s.edit(Integer.parseInt(searchSat.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL EDIT OPERATION","Satellite Edited Successfully");

      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","EDIT OPERATION FAILED");
      }
    }
    
    public void deleteSatellite(){
      try{
        Satellite.delete(Integer.parseInt(searchSat.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL DELETE OPERATION","Satellite Deleted Successfully");
        myTools.clearTextField(satPane);
      }catch(Exception e){
                myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","DELETE OPERATION FAILED");
      }
    }
    
    
    public void addRocket(){
      try{
        Rocket r = new Rocket(rName.getText(),rModel.getText(),rAV.isSelected(),rVC.isSelected());
        r.add();
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL ADD OPERATION","Rocket Added Successfully");
        myTools.clearTextField(addRocketPane);
        myTools.unsetToggleButton(addRocketPane);
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","ADD OPERATION FAILED");
      }
    }
    
    public void browseRocket() throws SQLException{
      try{
        Rocket r = Rocket.fetch(Integer.parseInt(browseRocket.getText()));
        rnLabel.setText(r.getRocketName());
        rmLabel.setText(r.getModel());
        ridLabel.setText(browseRocket.getText());
        ravLabel.setText(String.valueOf(r.isAvailability()));
        rvcLabel.setText(String.valueOf(r.isVisualCommunication()));
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the rocket");
      }
    }
    
    public void searchRocket() throws SQLException{
      try{
        Rocket r = Rocket.fetch(Integer.parseInt(searchRocket.getText()));
        erName.setText(r.getRocketName());
        erModel.setText(r.getModel());
        erAv.setSelected(r.isAvailability());
        erVc.setSelected(r.isVisualCommunication());
      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","Can not find the rocket");
      }
    }
    
    public void editRocket(){
      try{
        Rocket r = new Rocket(erName.getText(),erModel.getText(),erAv.isSelected(), erVc.isSelected());
        r.edit(Integer.parseInt(searchRocket.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL EDIT OPERATION","Rocket Edited Successfully");

      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","EDIT OPERATION FAILED");
      }
    }
    
    public void deleteRocket(){
      try{
        Rocket.delete(Integer.parseInt(searchRocket.getText()));
        myTools.showMessage(Alert.AlertType.CONFIRMATION,"SUCCESS","SUCCESSFUL DELETE OPERATION","Rocket Deleted Successfully");
        myTools.clearTextField(pane);
        myTools.unsetToggleButton(pane);

      }catch(Exception e){
          myTools.showMessage(Alert.AlertType.WARNING,"Warning","FAILURE","DELETE OPERATION FAILED");
      }
    }
    
    
}
