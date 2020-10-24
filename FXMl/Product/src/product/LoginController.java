package product;




import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{
  private Stage thisStage;
 private DataManager dataManager = DataManager.getDataManager();
   
    public Stage getThisStage() {
        return thisStage;
    }

    public void setThisStage(Stage thisStage) {
        this.thisStage = thisStage;
    }
    //burda dyerleri ve fxml kompenentlerini yazmisiq 
int eded = 1;
    @FXML
    private TextField usernameTF;
@FXML
    private TextField searchtx;
@FXML

    private ComboBox combox;
    @FXML
    private Label AlertsLabel;

    @FXML
    private PasswordField passwordPF;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       }
     @FXML
    void LoginButtonPressed(ActionEvent event) {
String username = usernameTF.getText();
        String password = passwordPF.getText(); 
        try {

            Connection c = dataManager.getConnection();
        boolean userExists = false;
        Statement stm = c.createStatement();
        ResultSet rs = stm.executeQuery("select * from users where username='" + username + "' and pasword='" + password + "';");
        if (rs.next()) {
            userExists = true;
        }
        rs.close();
            if (userExists) {
                AlertsLabel.setText("Daxil oldunuz");
((Node)event.getSource()).getScene().getWindow().hide();
                Stage s=new Stage();
  
                s.setTitle("Main");
                
    FXMLLoader loader=new FXMLLoader(getClass().getResource("/az/developia/student/view/main.fxml"));
     Parent root=loader.load();
        Scene scene=new Scene(root);
       s.setScene(scene);
                
      
      
      s.show();
      
                
            } else {
                AlertsLabel.setText("Məlumatlar səhvdir");
            }

         

        } catch (LoadException ex) {
            ex.printStackTrace();

        }catch(Exception ex){
          ex.printStackTrace();
        }
    }

    @FXML
    void CreateAccountButtonPressed(ActionEvent event) {
 String username = usernameTF.getText();
        String password = passwordPF.getText();
       
        try {

           Connection c = dataManager.getConnection();
        boolean userExists = false;
        Statement stm = c.createStatement();
        ResultSet rs = stm.executeQuery("select * from product.users where username='" + username + "' ;");
        if (rs.next()) {
            userExists = true;
        }
        rs.close();
            if (userExists) {
                AlertsLabel.setText("Bu artıq qeydiyyat olub");
            } else {
                PreparedStatement ps = c.prepareStatement("insert into users (username"
                        + ",pasword) values (?,?); ");
                ps.setString(1, username);
                ps.setString(2, password);

                ps.executeUpdate();

                ps.close();
                 AlertsLabel.setText("İstifadəçi yaradıldı");
            }

           

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    @FXML
    void DeleteAccountButtonPressed(ActionEvent event) {
String username = usernameTF.getText();
        String password = passwordPF.getText();
       
        try {

             Connection c = dataManager.getConnection();
       
          boolean userExists = false;
        Statement stm = c.createStatement();
        ResultSet rs = stm.executeQuery("select * from users where username='" + username + "' and pasword='" + password + "';");
        if (rs.next()) {
            userExists = true;
        }
        rs.close();
            if (userExists) {
                
                 PreparedStatement ps = c.prepareStatement("delete from product.users where username=? and pasword=?;");
                ps.setString(1, username);
                ps.setString(2, password);

                ps.executeUpdate();

                ps.close();
                AlertsLabel.setText("Silindi");
            } else {
               AlertsLabel.setText("Silinmədi");
            }

            

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
   
     
     
}

