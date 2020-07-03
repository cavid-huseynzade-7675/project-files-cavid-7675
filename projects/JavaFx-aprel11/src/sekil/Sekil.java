/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekil;

import javafx.application.Application;
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
