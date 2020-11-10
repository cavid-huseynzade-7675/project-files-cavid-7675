/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.developia.student.controller;

import az.developia.student.db.DataManager;
import az.developia.student.model.ModelTable;
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


public class SettingsgroupController implements Initializable {
    DataManager dataManager=DataManager.getDataManager();
    @FXML
    private TextField textfieldqrup;
    

    @FXML
    private ListView<String> list;
    private String username;
      public String getUsername() {

        return username;

    }

    void setUsername(String username) {
        this.username = username;
        findQrup(username);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      findQrup(getUsername());
   
    }    
     @FXML
    void add(ActionEvent event) throws SQLException {
        String qrup =textfieldqrup.getText();
Connection c = dataManager.getConnection();
 
            Statement s=c.createStatement();
            s.execute("insert into group_table(group_name,username) values ('"+qrup+"','"+getUsername()+"');");
            s.close();
       
        findQrup(getUsername());
         Notifications.create().position(Pos.CENTER).title("Məlumat").text("Qrup artirildi").showInformation();
   
  }

    @FXML
    void delete(ActionEvent event) throws SQLException {
      String selectedGroup=list.getSelectionModel().getSelectedItem();
  Connection c=dataManager.getConnection();
            Statement s=c.createStatement();
            s.execute("delete from group_table where group_name='"+selectedGroup+"' and username='"+getUsername()+"'  ;");
            s.close();
            findQrup(getUsername());
             Notifications.create().position(Pos.CENTER).title("Məlumat").text("Secdiginiz qrup silindi").showConfirm();
    }

  

    @FXML
    void deletehersey(ActionEvent event) throws SQLException {
 Connection c = dataManager.getConnection();
        Statement s = c.createStatement();
        s.execute("delete FROM  group_table where id>0 and username='" + getUsername()+ "' ;");
        list.getItems().clear();
         Notifications.create().position(Pos.CENTER).title("Məlumat").text("Butun qruplar silindi").showConfirm();
    }

    private void findQrup(String username) {
           list.getItems().clear();
       
        Connection c=dataManager.getConnection();
     ArrayList<String> alist=new ArrayList<String>();
          try {
             Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select group_name from group_table where username='"+username+"';");
             
                  while(rs.next()){ 
                alist.add(rs.getString("group_name"));
            } 
              list.getItems().addAll(alist);
              
         
          }catch(Exception ex){
            ex.printStackTrace();
          }
        
       }
}
