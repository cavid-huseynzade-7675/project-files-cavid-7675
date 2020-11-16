
package az.developia.todolist.controller;

import az.developia.todolist.db.DataManager;
import az.developia.todolist.util.UtilClass;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController implements Initializable {
  private final  DataManager dataManager= DataManager.getDataManager();
       @FXML
    private Label alerts;      
    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    void loginButton(ActionEvent event) {
      try {
          String username=usernameTextField.getText();
          String password=passwordPasswordField.getText();
          Connection c =dataManager.getConnection();
          boolean userexist=checkUserLogin( username, password);
          if (userexist) {
              alerts.setText("Daxil oldunuz");
          }else{
              alerts.setText("Məlumatlar sehvdir!");
          }
      } catch (Exception ex) {
          
            }
        }

    @FXML
    void accountCreatedButton(ActionEvent event) {
 String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();
       
        try {

           Connection c = dataManager.getConnection();
        boolean userExists = checkUserCreateAccount( username);
            if (userExists) {
                alerts.setText("Bu artıq qeydiyyat olub");
            } else {
                PreparedStatement ps = c.prepareStatement("insert into users (username"
                        + ",password) values (?,?); ");
                ps.setString(1, username);
                ps.setString(2, password);

                ps.executeUpdate();

                ps.close();
                alerts.setText("İstifadəçi yaradıldı");
            }

           

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    @FXML
    void accountDeleteButton(ActionEvent event) {
 String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();
     if(UtilClass.confirmDialog("Əminsiniz?")){
        try {

             Connection c = dataManager.getConnection();
       
            boolean userExists = checkUserLogin( username,password);
            if (userExists) {
                
                 PreparedStatement ps = c.prepareStatement("delete from users where username=? and password=?;");
                ps.setString(1, username);
                ps.setString(2, password);

                ps.executeUpdate();

                ps.close();
                alerts.setText("Silindi");
            } else {
               alerts.setText("Silinmədi");
            }

            

        } catch (Exception ex) {
            ex.printStackTrace();

        }   
    }}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
     private boolean checkUserCreateAccount( String u) throws Exception {
        // burda username gore yoxluyur
        Connection c =dataManager.getConnection();
        boolean userExists = false;
        ResultSet rs = c.createStatement().executeQuery("select * from users where username='" + u + "' ;");
        if (rs.next()) {
            userExists = true;
        }
        rs.close();
        return userExists;
    }
    
     private boolean checkUserLogin( String u, String p) throws Exception {
       //  burda hem username hemde paswword yoxluyur
       Connection c =dataManager.getConnection();
        boolean userExists = false;
        ResultSet rs = c.createStatement().executeQuery("select * from users where username='" + u + "' and password='" + p + "';");
        if (rs.next()) {
            userExists = true;
        }
        rs.close();;
        return userExists;
    }
}
