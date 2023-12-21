/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.Gpsdata;
import EntityClasses.Satellite;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author KareemEldeen
 */
public class LaunchVehicles implements Initializable{
    
    @FXML
    TextField satName,dest,x,y,browseSat,esn,esd,esx,esy,searchSat;
    @FXML
    Label sNameLabel,sxLabel,syLabel,sIDLabel,sDestLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Launch Vehicles window opens");
    }
    
    public void addSatellite(){
        Gpsdata gps = new Gpsdata(dest.getText(),Float.parseFloat(x.getText()), Float.parseFloat(y.getText()));
        Satellite s = new Satellite(satName.getText(), gps);
        s.add();
    }
    public void browseSatellite() throws SQLException{
        Satellite s = Satellite.fetch(Integer.parseInt(browseSat.getText()));
        sNameLabel.setText(s.getSatName());
        sIDLabel.setText(browseSat.getText());
        sDestLabel.setText(s.getGpsdata().getDestinationName());
        sxLabel.setText(String.valueOf(s.getGpsdata().getX_axis()));
        syLabel.setText(String.valueOf(s.getGpsdata().getY_axis()));
    }
    
    public void searchSatellite() throws SQLException{
        Satellite s = Satellite.fetch(Integer.parseInt(searchSat.getText()));
        esn.setText(s.getSatName());
        esd.setText(s.getGpsdata().getDestinationName());
        esx.setText(String.valueOf(s.getGpsdata().getX_axis()));
        esy.setText(String.valueOf(s.getGpsdata().getY_axis()));
    }
    
    public void editSatellite(){
        Gpsdata gps = new Gpsdata(esd.getText(),Float.parseFloat(esx.getText()), Float.parseFloat(esy.getText()));
        Satellite s = new Satellite(esn.getText(),gps);
        s.edit(Integer.parseInt(searchSat.getText()));
    }
    
    public void deleteSatellite(){
        Satellite.delete(Integer.parseInt(searchSat.getText()));
    }
}
