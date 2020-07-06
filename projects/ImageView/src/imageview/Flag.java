
package imageview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Flag extends Application{
 
    public static void main(String[] args) {
        launch(args);
    }
    

        
    @Override
    public void start(Stage s) throws Exception {
     s.setTitle("Flag");
        FXMLLoader loader=new FXMLLoader(getClass().getResource("flag.fxml"));
        Parent root=loader.load();
        Scene scene= new Scene(root);
        s.setScene(scene);
        s.show();
    }   
    
}
