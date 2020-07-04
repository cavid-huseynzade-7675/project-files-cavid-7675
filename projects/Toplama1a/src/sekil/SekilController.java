
package sekil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class SekilController implements Initializable {
@FXML
Label SeklinAdi;
@FXML
ImageView Sekil;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileInputStream input = null;
    try {
        input = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\Toplama1a\\images\\alma.jpg");
    } catch (FileNotFoundException ex) {
        Logger.getLogger(SekilController.class.getName()).log(Level.SEVERE, null, ex);
    }
          Image image = new Image(input);
Sekil.setImage(image); 
 SeklinAdi.setText("Alma");
    }    
    @FXML
    private void Evvelki(ActionEvent event) throws FileNotFoundException{
        
         
      
        
        if(SeklinAdi.getText()=="Armud"){
          FileInputStream input1 = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\Toplama1a\\images\\alma.jpg");
          Image image1 = new Image(input1);
Sekil.setImage(image1); 
 SeklinAdi.setText("Alma");
       }  
 
        if(SeklinAdi.getText()=="Heyva"){
          FileInputStream input2 = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\Toplama1a\\images\\armud.jpg");
          Image image2 = new Image(input2);
Sekil.setImage(image2); 
 SeklinAdi.setText("Armud");
       }  

    }
    
     @FXML
    private void Sonraki(ActionEvent event) throws FileNotFoundException{
       
        if(SeklinAdi.getText()=="Armud"){
     FileInputStream input1 = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\Toplama1a\\images\\heyva.jpg");
          Image image1 = new Image(input1);
Sekil.setImage(image1); 
SeklinAdi.setText("Heyva");
}
        if(SeklinAdi.getText()=="Alma"){
          FileInputStream input2 = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\Toplama1a\\images\\armud.jpg");
          Image image2 = new Image(input2);
Sekil.setImage(image2); 
SeklinAdi.setText("Armud");
        }

    
    }
}