
package az.developia.todolist.controller;

import az.developia.todolist.db.DataManager;
import az.developia.todolist.model.Model;
import az.developia.todolist.util.UtilClass;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

public class UptdeController implements Initializable {
DataManager dataManager=DataManager.getDataManager();
   String username;
    Model model=new Model();

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
        tapsiriqTextFieldu.setText(model.getTapsiriq());
        String st=String.valueOf(model.getTarix());
        LocalDate date=LocalDate.parse(st);
        tarixDatePickeru.setValue(date);
        kategoriyaCombobox.getSelectionModel().select(model.getKateqoriya());
        
         String st1=String.valueOf(model.getGun());
        LocalDate date2=LocalDate.parse(st1);
        gunDatePickeru1.setValue(date2);
      
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
findKategoriya();    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
         FileInputStream input = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\Layihe\\TodoList7675\\image\\setting.png");
          Image image = new Image(input);
        setingimageu.setImage(image);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }    
    

   @FXML
    private ImageView setingimageu;

    @FXML
    private TextField tapsiriqTextFieldu;

    @FXML
    private DatePicker tarixDatePickeru;

    @FXML
    private DatePicker gunDatePickeru1;

    @FXML
    private ComboBox<String> kategoriyaCombobox;


   
    @FXML
    void kategoriyasettingsu(ActionEvent event) {
        try{
 Stage s=new Stage();
  
                s.setTitle("Tasks");
                 FileInputStream input=new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\Layihe\\TodoList7675\\image\\setting.png");
          Image image=new Image(input);
         
        Image[] elements = new Image[1];
        elements[0]=image;
          s.getIcons().setAll(elements);
    FXMLLoader loader=new FXMLLoader(getClass().getResource("/az/developia/todolist/view/kategoriyasettings.fxml"));
     Parent root=loader.load();
        Scene scene=new Scene(root);
       s.setScene(scene);
       KategoriyasettingsController kategoriyasettingsController=loader.getController();
       kategoriyasettingsController.setUsername(username);
       s.showAndWait();
       findKategoriya();
       
        }catch(Exception ex){
            ex.printStackTrace();
    }
    }

    @FXML
    void uptadeButtton(ActionEvent event) throws SQLException {
   if(UtilClass.confirmDialog("Əminsiniz?")){
            Connection c=dataManager.getConnection();
Statement s=c.createStatement();
 s.execute("update tasks set taskname='"+tapsiriqTextFieldu.getText()+"',gun='"+gunDatePickeru1.getValue()+"',date='"+tarixDatePickeru.getValue()+"',kateqoriya='"+kategoriyaCombobox.getSelectionModel().getSelectedItem()+"' Where id='"+model.getId()+"';");
s.close();
 Notifications.create().position(Pos.BOTTOM_RIGHT).title("Məlumat").text("Secdiginiz telebenin melumatlari deyisdirildi").showConfirm();

    }}
     private void findKategoriya() {
           kategoriyaCombobox.getItems().clear();
         Connection c = dataManager.getConnection();
        ArrayList<String> alist = new ArrayList<String>();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select kateqoriyaname from kateqoriyatable where username='" + username + "';");

            while (rs.next()) {
                alist.add(rs.getString("kateqoriyaname"));
            }
            kategoriyaCombobox.getItems().addAll(alist);

        } catch (Exception ex) {
            ex.printStackTrace();
        } }
}
