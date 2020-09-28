
package az.developia.student.controller;

import com.sun.prism.paint.Color;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;


public class LoginController implements Initializable {
@FXML
    private TextField usernameTF;

    @FXML
    private Label AlertsLabel;

    @FXML
    private PasswordField passwordPF;

    @FXML
    void LoginButtonPressed(ActionEvent event) {
String username=usernameTF.getText();
String password=passwordPF.getText();
try{
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegister-Aprel11-7675", "root", "1234");

Boolean b=chehkuser(c, username, password);
if(b){
AlertsLabel.setText("Daxil oldunuz");


}else{
 AlertsLabel.setText("Melumatlar sehvdir");
}
     c.close();
    
}catch(SQLException ex){
    
   AlertsLabel.setText("Sql Sintaksis  sehvi");   
ex.printStackTrace();

}catch(Exception ex1){
  
   AlertsLabel.setText("JAva sehvi");  
  

}

    }

    @FXML
    void CreateAccountButtonPressed(ActionEvent event) throws SQLException {
String username=usernameTF.getText();
String password=passwordPF.getText();
try{
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegister-Aprel11-7675", "root", "1234");

Boolean b=chehkuser(c, username, password);
if(b){
AlertsLabel.setText("Artiq qeydiyyat olunub");


}else{
 PreparedStatement ps=c.prepareStatement("insert into students  ( username, pasword) values (?,?);");
         ps.setString(1,username );
     ps.setString(2, password);
     ps.executeUpdate();
     
     
     ps.close();   
    AlertsLabel.setText("Ugurla Hesab Yaradildi");
}



     
     
     c.close();
    
}catch(SQLException ex){
    
   AlertsLabel.setText("Sql Sintaksis  sehvi");   
ex.printStackTrace();

}catch(Exception ex1){
  
   AlertsLabel.setText("JAva sehvi");  
  

}

              }
    

    @FXML
    void DeleteAccountButtonPressed(ActionEvent event) {

   
            
            }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
   private boolean chehkuser(Connection c,String u,String p) throws Exception {
   Boolean b=false;
 Statement stm=c.createStatement();
ResultSet rs= stm.executeQuery("select * from students WHERE username='"+u+"' and pasword='"+p+"';");
if(rs.next()){
    
    b=true;
}
stm.close();
rs.close();
return b;
   
   }
}
