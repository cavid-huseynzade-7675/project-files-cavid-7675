/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Cavid
 */
public class SekilController implements Initializable {

    @FXML
    private ImageView sekil;
    @FXML
    private Label SekilAdi;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }    
      @FXML
    private void Evvelki(ActionEvent event) throws FileNotFoundException  {
        
   FileInputStream input = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\JavaFx-aprel11\\Images/download");
        Image image = new Image(input);
        sekil.setImage(image);
       
        } 
        @FXML
    private void Sonraki (ActionEvent event) {
           SekilAdi.setText("value");  
        } 
}
