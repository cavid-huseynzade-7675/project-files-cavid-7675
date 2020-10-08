package az.developia.student.controller;



import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    private Stage thisStage;

    public Stage getThisStage() {
        return thisStage;
    }

    public void setThisStage(Stage thisStage) {
        this.thisStage = thisStage;
    }
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
 //Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegister-Aprel11-7675", "root", "1234");

    @FXML
    void LoginButtonPressed(ActionEvent event) {
 String username = usernameTF.getText();
        String password = passwordPF.getText(); 
        try {

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegister-Aprel11-7675", "root", "1234");
 boolean userExists = checkUserLogin(c, username, password);
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
            MainController mainController=loader.getController();

                mainController.setUsername(username);    
                
            } else {
                AlertsLabel.setText("Məlumatlar səhvdir");
            }

            c.close();

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
        //System.out.println("username = "+username);
        //System.out.println("password = "+password);

        try {

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegister-Aprel11-7675", "root", "1234");
 boolean userExists = checkUserCreateAccount(c, username);
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

            c.close();

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    @FXML
     void DeleteAccountButtonPressed(ActionEvent event) {
    String username = usernameTF.getText();
        String password = passwordPF.getText();
       
        try {

             Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegister-Aprel11-7675", "root", "1234");

            boolean userExists = checkUserLogin(c, username,password);
            if (userExists) {
                
                 PreparedStatement ps = c.prepareStatement("delete from users where username=? and pasword=?;");
                ps.setString(1, username);
                ps.setString(2, password);

                ps.executeUpdate();

                ps.close();
                AlertsLabel.setText("Silindi");
            } else {
               AlertsLabel.setText("Silinmədi");
            }

            c.close();

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
@FXML
     void searchbutton(ActionEvent event) {
   
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private boolean checkUserCreateAccount(Connection c, String u) throws Exception {
        boolean userExists = false;
        Statement stm = c.createStatement();
        ResultSet rs = stm.executeQuery("select * from users where username='" + u + "' ;");
        if (rs.next()) {
            userExists = true;
        }
        rs.close();
        stm.close();
        return userExists;
    }
    
     private boolean checkUserLogin(Connection c, String u, String p) throws Exception {
        boolean userExists = false;
        Statement stm = c.createStatement();
        ResultSet rs = stm.executeQuery("select * from users where username='" + u + "' and pasword='" + p + "';");
        if (rs.next()) {
            userExists = true;
        }
        rs.close();
        stm.close();
        return userExists;
    }
     
    

}

