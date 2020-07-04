package sekil;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Cavid
 */
public class Sekil extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage sekil) throws Exception {
     sekil.setTitle("sekil");
        FXMLLoader loader=new FXMLLoader(getClass().getResource("sekil.fxml"));
        Parent root=loader.load();
        Scene scene=new Scene(root);
        sekil.setScene(scene);
        sekil.show();
    }
    
}
