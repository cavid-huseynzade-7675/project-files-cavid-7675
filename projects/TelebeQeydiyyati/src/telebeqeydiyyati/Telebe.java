package telebeqeydiyyati;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Telebe extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage s) throws Exception {
       s.setTitle("ListView");
        FXMLLoader loader=new FXMLLoader(getClass().getResource("telebe.fxml"));
        Parent root=loader.load();
        Scene scene= new Scene(root);
        s.setScene(scene);
        s.show();
    }
    
}