/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ListviewController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    @FXML
    private TextField eded;
     @FXML
    private ListView<Integer> cedvel;

    @FXML
    private Label cem;

    @FXML
    void elaveet(ActionEvent event) {
String selected=eded.getText();
int Selected=Integer.parseInt(selected);
cedvel.getItems().add(Selected);
    }

    @FXML
    void hamisinisil(ActionEvent event) {
cedvel.getItems().clear();
    }

}


