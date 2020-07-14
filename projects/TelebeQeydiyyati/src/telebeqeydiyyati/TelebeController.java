/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telebeqeydiyyati;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Cavid
 */
public class TelebeController implements Initializable {

    @FXML
    private TextField ad;

    @FXML
    private TextField yas;

    @FXML
    private ListView<String> list;

    @FXML
    void elave(ActionEvent event) {
        String Ad = ad.getText();
        String Yas = yas.getText();
        String son = "Ad "+Ad +"-"+"Yas "+ Yas;
        list.getItems().add(son);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
