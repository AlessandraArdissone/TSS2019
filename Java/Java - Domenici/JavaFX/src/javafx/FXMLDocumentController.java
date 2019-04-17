/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author tss
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField usr;
    
    @FXML
    private TextField pwd;
    
    @FXML
    private void login(ActionEvent event) {
        System.out.println("eseguo la login per: ");
        System.out.println("username: " + usr.getText());
        System.out.println("username: " + pwd.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("inizialize FXMLDocumentController...");
    }    
    
}
