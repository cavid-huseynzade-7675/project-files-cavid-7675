/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttoplama;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Cavid
 */
public class Ttoplama extends Application {
    
    @Override
    public void start(Stage toplama) throws Exception {
       toplama.setTitle("toplama");
        FXMLLoader loader=new FXMLLoader(getClass().getResource("toplama.fxml"));
     Parent root=loader.load();
     Scene scene=new Scene(root);
     toplama.setScene(scene);
     toplama.show();
        
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
