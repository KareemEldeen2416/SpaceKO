/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import EntityClasses.Researcher;
import EntityClasses.Researchs;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author KareemEldeen
 */
public class Research implements Initializable{
    
    @FXML
    TextField browseResearcher,reName,ereName,sr,browseResearch,researchName,reID,sre,eres,eresReID;
    @FXML
    Label researcherName,researcherID,resName,resID,resRe,resReID;
    @FXML
    AnchorPane rePane,sePane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Research window opens");
    }
    
    public void browseResearch() throws SQLException{
        Researchs r = Researchs.fetch(Integer.parseInt(browseResearch.getText()));
        resName.setText(r.getResearchName());
        resID.setText(browseResearch.getText());
        resRe.setText(r.getResearcherName());
        resReID.setText(String.valueOf(r.getResearcherID()));
    }
    
    public void addResearch(){
        Researchs r = new Researchs(researchName.getText(),Integer.parseInt(reID.getText()));
        r.add();
    }
    
    public void searchResearch() throws SQLException{
        Researchs r = Researchs.fetch(Integer.parseInt(sre.getText()));
        eres.setText(r.getResearchName());
        eresReID.setText(String.valueOf(r.getResearcherID()));
    }
    
    
    public void editResearch(){
        Researchs r = new Researchs(eres.getText(), Integer.parseInt(eresReID.getText()));
        r.edit(Integer.parseInt(sre.getText()));
    }
    
    public void deleteResearch(){
        Researchs.delete(Integer.parseInt(sre.getText()));
    }
    
    public void browseResearcher() throws SQLException{
        Researcher r = Researcher.fetch(Integer.parseInt(browseResearcher.getText()));
        researcherName.setText(r.getName());
        researcherID.setText(browseResearcher.getText());
    }
    
    public void searchResearcher() throws SQLException{
        Researcher r = Researcher.fetch(Integer.parseInt(sr.getText()));
        ereName.setText(r.getName());
    }
    
    public void addResearcher(){
        Researcher r = new Researcher(reName.getText());
        r.add();
    }
    
    public void editResearcher(){
        Researcher r = new Researcher(ereName.getText());
        r.edit(Integer.parseInt(sr.getText()));
    }
    
    public void deleteResearcher(){
        Researcher.delete(Integer.parseInt(sr.getText()));
        for(Object o : rePane.getChildren()){
            if(o instanceof TextField){
                ((TextField)o).clear();
            }
        }
    }
    
    
    
    
    
    
}
