
package az.developia.student.controller;

import az.developia.student.db.DataManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.NativeDate;
import org.controlsfx.control.Notifications;


public class UptadestudentController implements Initializable {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    String name,surname,telefon,valideynadi,adres;
    String date;
    String username,sector;


    public void setSector(String sector) {
        this.sector = sector;
        comboxsector.getSelectionModel().select(sector);
       
    }
DataManager dataManager=DataManager.getDataManager();
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        findSectors();
    }
@FXML
  
    private TextField nameTX;

    @FXML
    private DatePicker birthdayDt;

    @FXML
    private TextField surnameTX;

    @FXML
    private TextField adressTX;

    @FXML
    private TextField telefonTX;

    @FXML
    private TextField vnameTX;

    @FXML
    private ComboBox comboxsector;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        nameTX.setText(name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        surnameTX.setText(surname);
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
        telefonTX.setText(telefon);
    }

    public String getValideynadi() {
        return valideynadi;
    }

    public void setValideynadi(String valideynadi) {
        this.valideynadi = valideynadi;
        vnameTX.setText(valideynadi);
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
        adressTX.setText(adres);
    }

    public String getDate() {
        return date;
          
    }

    public void setDate(String date) throws SQLException {
        this.date = date; 
        LocalDate localDate=LocalDate.parse(date);
           birthdayDt.setValue(localDate);
      
    }

  

    @FXML
    void uptade(ActionEvent event) throws SQLException {
Connection c=dataManager.getConnection();
Statement s=c.createStatement();
 s.execute("update students set name='"+nameTX.getText()+"'  ,surname='"+surnameTX.getText()+"',"
  + "date='"+birthdayDt.getValue()+"' ,adress='"+adressTX.getText()+"',"
 + "telefon='"+telefonTX.getText()+"', valideynadi='"+vnameTX.getText()+"',"
         + "sector='"+comboxsector.getValue()+"' Where id='"+getId()+"';");
s.close();
 Notifications.create().position(Pos.CENTER).title("Məlumat").text("Secdiginiz telebenin melumatlari deyisdirildi").showConfirm();

    }
    
     @FXML
    void sektorayarlar(ActionEvent event) throws IOException {
 Stage s = new Stage();

        s.setTitle("Sektor Ayarlari");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/az/developia/student/view/sektorayarlar.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        s.setScene(scene);

        SektorayarlarController sektorayarlarController = loader.getController();

        sektorayarlarController.setUsername(username);

        s.showAndWait();
        findSectors();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
      public void findSectors() {
         comboxsector.getItems().clear();
        Connection c=dataManager.getConnection();
     ArrayList<String> alist=new ArrayList<String>();
          try {
             Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select sector from sectors where username='"+username+"';");
             
                  while(rs.next()){ 
                alist.add(rs.getString("sector"));
            } 
              comboxsector.getItems().addAll(alist);
              
         
          }catch(Exception ex){
            ex.printStackTrace();
          }
        
        }

   
}
