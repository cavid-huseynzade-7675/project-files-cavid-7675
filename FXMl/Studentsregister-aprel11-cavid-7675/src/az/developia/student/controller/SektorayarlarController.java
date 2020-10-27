
package az.developia.student.controller;

import az.developia.student.DAO.StudentDAO;
import az.developia.student.db.DataManager;
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


public class SektorayarlarController implements Initializable {
      private String username;
private  StudentDAO studentDAO;
DataManager dataManager=DataManager.getDataManager();
    public String getUsername() {
        return username;

    }

    void setUsername(String username) {
        this.username = username;
        findSectors();

    }
@FXML
    private TextField textfield;

    @FXML
    private ListView<String> list;

    @FXML
    void add(ActionEvent event) throws SQLException {
       
String sector =textfield.getText();
Connection c = dataManager.getConnection();
 
            Statement s=c.createStatement();
            s.execute("insert into sectors (sector,username) values ('"+sector+"','"+username+"');");
            s.close();
       
        findSectors();
         Notifications.create().position(Pos.CENTER).title("Məlumat").text("Sektor artirildi").showConfirm();
    }

    @FXML
    void delete(ActionEvent event) throws SQLException {
        String selectedSector=list.getSelectionModel().getSelectedItem();
  Connection c=dataManager.getConnection();
            Statement s=c.createStatement();
            s.execute("delete from sectors where sector='"+selectedSector+"' and username='"+username+"'  ;");
            s.close();
            findSectors();
             Notifications.create().position(Pos.CENTER).title("Məlumat").text("Secdiginiz sektor silindi").showConfirm();
    }

    @FXML
    void deletehersey(ActionEvent event) throws SQLException {
 Connection c = dataManager.getConnection();
        Statement s = c.createStatement();
        s.execute("delete FROM  sectors where id>0 and username='" + getUsername() + "' ;");
        list.getItems().clear();
         Notifications.create().position(Pos.CENTER).title("Məlumat").text("Butun sektorlar silindi").showConfirm();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
    }
 
   public void findSectors() {
       list.getItems().clear();
       
        Connection c=dataManager.getConnection();
     ArrayList<String> alist=new ArrayList<String>();
          try {
             Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select sector from sectors where username='"+username+"';");
             
                  while(rs.next()){ 
                alist.add(rs.getString("sector"));
            } 
              list.getItems().addAll(alist);
              
         
          }catch(Exception ex){
            ex.printStackTrace();
          }
        
        }
   
       }
    


