package imageview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FlagController implements Initializable {

    String[] Imagenames = new String[6];
    String[] Imagepaths = new String[6];
    int currentImageIndex=0;
    @FXML
    ImageView flag;
    @FXML
    Label results;
    @FXML
    ComboBox images;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        images.getItems().add("Az");
        images.getItems().add("Rus");
        images.getItems().add("Turkiye");
        images.getItems().add("Amerika");
        images.getItems().add("Ingiltere");
        images.getItems().add("Almaniya");
        
    
        Imagenames[0] = "Az";
        Imagenames[1] = "Rus";
        Imagenames[2] = "Turkiye";
        Imagenames[3] = "Amerika";
        Imagenames[4] = "Ingiltere";
        Imagenames[5] = "Almaniya";
       
        
        Imagepaths[0] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\ImageView\\images\\Azerbaycan.jpeg";
        Imagepaths[1] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\ImageView\\images\\rusiya.png";
        Imagepaths[2] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\ImageView\\images\\turkiye.png";
        Imagepaths[3] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\ImageView\\images\\Amerika.png";
        Imagepaths[4] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\ImageView\\images\\Ingiltere.png";
        Imagepaths[5] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\ImageView\\images\\Almaniya.png";
       
    }

    @FXML
    private void show(ActionEvent event) throws FileNotFoundException {
        for (int i = 0; i <= Imagenames.length; i++) {
            
        
        String selected = images.getSelectionModel().getSelectedItem().toString();
        if(selected==Imagenames[currentImageIndex]){
         showimage();   
            break;
        }else{
           currentImageIndex++; 
        }
        }
        currentImageIndex=0;
    }

    private void showimage() throws FileNotFoundException {
       FileInputStream input2 = new FileInputStream(Imagepaths[currentImageIndex]);
          Image image2 = new Image(input2);
flag.setImage(image2); 
results.setText(Imagenames[currentImageIndex]);
    }
}
