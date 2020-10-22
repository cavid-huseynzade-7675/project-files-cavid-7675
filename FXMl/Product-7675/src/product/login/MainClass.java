
package product.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainClass extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage s) throws Exception {
        // Biz burda fxml faylini aciriq
      s.setTitle("Studentregister");
        FXMLLoader loader=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root=loader.load();
        Scene scene= new Scene(root);
        s.setScene(scene);
        s.show();  
    
    
    
    }
    
}
