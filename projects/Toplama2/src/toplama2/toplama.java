
package toplama2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class toplama extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage toplama) throws Exception {
      toplama.setTitle("toplama");
        FXMLLoader loader=new FXMLLoader(getClass().getResource("toplamaa.fxml"));
        Parent root=loader.load();
        Scene scene=new Scene(root);
        toplama.setScene(scene);
        toplama.show();
    }
    
}
