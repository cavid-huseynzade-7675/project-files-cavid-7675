 
package question;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Question extends Application{

    @Override
    public void start(Stage s) throws Exception {
        s.setTitle("Question");
        FXMLLoader loader=new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root=loader.load();
        Scene scene= new Scene(root);
        s.setScene(scene);
        s.show();   }
    
}
