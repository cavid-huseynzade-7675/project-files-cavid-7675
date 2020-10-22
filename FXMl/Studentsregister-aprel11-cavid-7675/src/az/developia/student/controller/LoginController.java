package az.developia.student.controller;



import az.developia.student.db.DataManager;
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
 
    @FXML
    void LoginButtonPressed(ActionEvent event) {
  // burda duymeye basanda text field deyer goturub
  //stringe verir sonra onu checkUserLogin metodu database gore yoxluyuruq 
  //eger dogrudursa giris eleye bilirik dogru  deyilse giris eliye bilmirik ve label 
  //vasitesile deyirikki sifre ve ad yanlisdir
 String username = usernameTF.getText();
        String password = passwordPF.getText(); 
        try {

            Connection c = dataManager.getConnection();
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

         

        } catch (LoadException ex) {
            ex.printStackTrace();

        }catch(Exception ex){
          ex.printStackTrace();
        }
    }
    @FXML
    void CreateAccountButtonPressed(ActionEvent event) {
        // burda duymeye basanda text field deyer goturub
        //stringe verir  checkUserCreateAccount metodu vasitesile yoxluyuruq
        //eger databasede melumat varsa label vasitesi deyirki "İstifadəçi yaradıldı"
        //eger yoxdursa teze account yaradir
        String username = usernameTF.getText();
        String password = passwordPF.getText();
       
        try {

           Connection c = dataManager.getConnection();
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

           

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    @FXML
     void DeleteAccountButtonPressed(ActionEvent event) {
         // burda duymeye basanda text field deyer goturub
        //stringe verir checkUserLogin metodu ile yoxluyur
        //eger varsa silir yoxdursa label vasitesile deyirki"Silinmədi"
    String username = usernameTF.getText();
        String password = passwordPF.getText();
       
        try {

             Connection c = dataManager.getConnection();
       
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

            

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private boolean checkUserCreateAccount(Connection c, String u) throws Exception {
        // burda username gore yoxluyur
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
       //  burda hem username hemde paswword yoxluyur
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

