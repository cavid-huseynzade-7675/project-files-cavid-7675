
package az.developia.todolist.controller;

import az.developia.todolist.db.DataManager;
import az.developia.todolist.model.Model;
import az.developia.todolist.util.UtilClass;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;


public class KategoriyasettingsController implements Initializable {
DataManager dataManager=DataManager.getDataManager();
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        try {
              findKateqoriya();
        } catch (Exception e) {
        }
      
    }
     @FXML
    private TextField textfield;

    @FXML
    private ListView<String> kategoriyatable;

    @FXML
    void delete(ActionEvent event) throws SQLException {

        if(UtilClass.confirmDialog("Əminsiniz?")){
           String selectedSector=kategoriyatable.getSelectionModel().getSelectedItem();
  Connection c=dataManager.getConnection();
            Statement s=c.createStatement();
            s.execute("delete from kateqoriyatable  where kateqoriyaname ='"+selectedSector+"' and username='"+getUsername()+"'  ;");
            s.close();
            findKateqoriya();
             Notifications.create().position(Pos.BOTTOM_RIGHT).title("Məlumat").text("Secdiginiz kateqoriya silindi").showConfirm();
    }   
    }

    @FXML
    void save(ActionEvent event) throws SQLException {
       
String kategoriya =textfield.getText();
Connection c = dataManager.getConnection();
 
            Statement s=c.createStatement();
            s.execute("insert into kateqoriyatable (kateqoriyaname ,username) values ('"+kategoriya+"','"+getUsername()+"');");
            s.close();
       
        findKateqoriya();
         Notifications.create().position(Pos.BOTTOM_RIGHT).title("Məlumat").text("Kategoriya artirildi").showConfirm();
   
    }

    @FXML
    void deleteevery(ActionEvent event) throws SQLException {
  if(UtilClass.confirmDialog("Əminsiniz?")){
          Connection c = dataManager.getConnection();
        Statement s = c.createStatement();
        s.execute("delete FROM  kateqoriyatable  where id>0 and username='" + getUsername() + "' ;");
        kategoriyatable.getItems().clear();
         Notifications.create().position(Pos.BOTTOM_RIGHT).title("Məlumat").text("Butun kateqoriyalar silindi").showConfirm();
     
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
      public void findKateqoriya() {
        kategoriyatable.getItems().clear();
       
        Connection c=dataManager.getConnection();
     ArrayList<String> alist=new ArrayList<String>();
          try {
           
            ResultSet rs=c.createStatement().executeQuery("select kateqoriyaname from kateqoriyatable where username='"+getUsername()+"';");
             
                  while(rs.next()){ 
                alist.add(rs.getString("kateqoriyaname"));
            } 
              kategoriyatable.getItems().addAll(alist);
              
         
          }catch(Exception ex){
            ex.printStackTrace();
          }
        
        }
}
