
package com.main;

import javafx.application.Application;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class MainClass extends Application{

    @Override
    public void start(Stage ps) throws Exception {
       ps.setTitle("JavaFx code Design");
        MenuButton myMenuButton=new MenuButton();
        MenuItem  createbutton=new MenuItem("Click here fore creating button");
       MenuItem  createLabel=new MenuItem("Click here fore creating label");
       myMenuButton.getItems().addAll(createbutton,createLabel);
  
       
       
       ps.show();
    }
    public static void main(String[] args) {
        
        launch(args);
    }
}
