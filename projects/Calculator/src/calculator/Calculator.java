/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Cavid
 */
public class Calculator extends Application {
     public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage toplama) throws Exception {
       toplama.setTitle("calculator(demo)");
        FXMLLoader loader=new FXMLLoader(getClass().getResource("calculator.fxml"));
        Parent root=loader.load();
        Scene scene=new Scene(root);
       toplama.setScene(scene);
       toplama.show();
    }
   
}