/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telebeqeydiyyati;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class TelebeController implements Initializable {
  @FXML
    private ListView<String> listTarix;

    @FXML
    private DatePicker date;
    @FXML
    private TextField ad;

    

    @FXML
    private ListView<String> list;

    @FXML
    void elave(ActionEvent event) {
        boolean allowRegister=true;
       
        String Ad = ad.getText();
       LocalDate Yas = date.getValue();
       if(Ad==null){
           allowRegister=false;
           JOptionPane.showMessageDialog(null,"Ad yazmzaqlazimdir"); 
       }
       if(Yas==null){
           allowRegister=false;
           JOptionPane.showMessageDialog(null,"Tevvellud secmek lazimdir");
           
       }
       if(allowRegister){
       String yas=Yas.toString();
        list.getItems().add(Ad);
        listTarix.getItems().add(yas);
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
