/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aprel11.listview.pkg7675;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ListView extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage s) throws Exception {
    s.setTitle("ListView");
        FXMLLoader loader=new FXMLLoader(getClass().getResource("listview.fxml"));
        Parent root=loader.load();
        Scene scene= new Scene(root);
        s.setScene(scene);
        s.show();
    }
    
}
