/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listview;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ListviewController implements Initializable {
long cem1;
    Random dice=new Random();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    
     @FXML
    private ListView<Integer> cedvel;

    @FXML
    private Label cem;

    @FXML
    void elaveet(ActionEvent event) {


int Selected=dice.nextInt(100);

Integer secilmis=Selected;
cem1+=secilmis;
String cemstring=String.valueOf(cem1);
cem.setText(cemstring);

cedvel.getItems().add(Selected);


    }

    @FXML
    void hamisinisil(ActionEvent event) {
cedvel.getItems().clear();
cem.setText("0");
cem1=0;
    }

}


