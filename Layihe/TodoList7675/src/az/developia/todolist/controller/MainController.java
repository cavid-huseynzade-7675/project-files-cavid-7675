
package az.developia.todolist.controller;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Notifications;


public class MainController implements Initializable {
@FXML
private ToggleGroup toggle=new  ToggleGroup();
   @FXML
    private RadioButton hellolmayanlarRadiobutton;

    @FXML
    private RadioButton hamisiRadiobutton;


    @FXML
    private RadioButton hellolanlarRadiobutton;
    @FXML
    private TextField tapsiriqTextField;

    @FXML
    private TableView<?> tapsiriqTableView;

    @FXML
    private TableColumn<?, ?> gunTC;

    @FXML
    private TextField searchTExtField;

    @FXML
    private TextField gunTextField;

    @FXML
    private TableColumn<?, ?> tarixTC;

    @FXML
    private TableColumn<?, ?> necegunqalibTC;

    @FXML
    private DatePicker tarixDatePicker;

    @FXML
    private TableColumn<?, ?> statusTC;

    @FXML
    private Label setirsayi;
@FXML
    private Label alerts;
    @FXML
    private TableColumn<?, ?> tapsiriqTC;

    @FXML
    private TableColumn<?, ?> idTC;

    @FXML
    private TableColumn<?, ?> kateqoriyaTC;

    @FXML
    private ComboBox<?> kategoriyaCombobox;
 @FXML
    private ImageView setingimage;

  
    @FXML
    private ImageView searchimage;
    @FXML
    void kategoriyasettings(ActionEvent event) {

    }

    @FXML
    void saveButtton(ActionEvent event) {
        boolean allowsave =true;
        String xeta="";
        if (tapsiriqTextField.getText().trim().length()<3) {
            allowsave=false;
          xeta+="Tapsirigi ";
                            
        }
        if (gunTextField.getText().trim().length()==0) {
            allowsave=false;
          xeta+=",nece gun erzinde yetiriceyinizi";
                            
        }
        if (!allowsave){
        xeta+="tam yazin\n";
        }
        if (tarixDatePicker.getValue()==null) {
            allowsave=false;
          xeta+=" Ne vaxt qeyd etdiyinizi secin\n";
                            
        }
         if (kategoriyaCombobox.getSelectionModel().getSelectedItem()==null) {
            allowsave=false;
          xeta+="Kategoriyani secin";
                            
        }
         if (allowsave) {
            
        }else{
             Notifications.create().title("Melumat").position(Pos.BOTTOM_RIGHT).text("Melumatlari tam yazin\n"+xeta).showInformation();
         alerts.setText("Melumatlari tam yazin\n"+xeta);
         }
         
    }

    @FXML
    void deleteButton(ActionEvent event) {

    }

    @FXML
    void hellolanlarRadiobutton(ActionEvent event) {

    }

    @FXML
    void hamisiRadiobutton(ActionEvent event) {

    }

    @FXML
    void hellolmayanlarRadiobutton(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
        hamisiRadiobutton.setToggleGroup(toggle);
        hellolanlarRadiobutton.setToggleGroup(toggle);
        hellolmayanlarRadiobutton.setToggleGroup(toggle);
         FileInputStream input2 = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\Layihe\\TodoList7675\\image\\search s.png");
          Image image2 = new Image(input2);
        searchimage.setImage(image2);
        FileInputStream input = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\Layihe\\TodoList7675\\image\\setting.png");
          Image image = new Image(input);
        setingimage.setImage(image);
        }catch(Exception ex){
            
        }
    }   
    
}
