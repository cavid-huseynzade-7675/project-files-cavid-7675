package com.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainClass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Examples Aprel 11");
        HBox hBox = new HBox();
 

        Button sliderExample = new Button("Slider");
        sliderExample.setOnAction((e) -> {
            Examples.sliderExample();
        });

        hBox.getChildren().add(sliderExample);
        
        
        
         Button checkBoxExample = new Button("Check Box");
        checkBoxExample.setOnAction((e) -> {
            Examples.checkBoxExample();
        });

        hBox.getChildren().add(checkBoxExample);
        
        
        
        
        
         Button passwordFieldExample = new Button("PasswordField");
        passwordFieldExample.setOnAction((e) -> {
            Examples.passwordFieldExample();
        });

        hBox.getChildren().add(passwordFieldExample);
        
        
        
        
        
         Button textAreaExample = new Button("textAreaExample");
        textAreaExample.setOnAction((e) -> {
            Examples.textAreaExample();
        });

        hBox.getChildren().add(textAreaExample);
        
        
        

        VBox vBox = new VBox();
        hBox.setSpacing(2); 
        vBox.setSpacing(2);
        vBox.getChildren().addAll(hBox);
        Scene scene = new Scene(vBox, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}