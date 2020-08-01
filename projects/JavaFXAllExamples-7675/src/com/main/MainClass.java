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
HBox hBox1 = new HBox();
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

        Button choiceBoxExample = new Button("choiceBox Example");
        choiceBoxExample.setOnAction((e) -> {
            Examples.choiceBoxExample();
        });

        hBox.getChildren().add(choiceBoxExample);

        Button ComboBoxExample = new Button("ComboBoxExample");
        ComboBoxExample.setOnAction((e) -> {
            Examples.ComboBoxExample();
        });

        hBox.getChildren().add(ComboBoxExample);

        Button listviewExample = new Button("listviewExample");
        listviewExample.setOnAction((e) -> {
            Examples.listviewExample();
        });

        hBox.getChildren().add(listviewExample);

        Button datepickerExample = new Button("datepickerExample");
        datepickerExample.setOnAction((e) -> {
            Examples.datepickerExample();
        });

        hBox.getChildren().add(datepickerExample);
        Button ColorPickerExample = new Button("ColorPickerExample");
        ColorPickerExample.setOnAction((e) -> {
            Examples.ColorPickerExample();
        });
        hBox.getChildren().add(ColorPickerExample);
        Button toolBarExample = new Button("tool bar Example");
        toolBarExample.setOnAction((e) -> {
            Examples.toolBarExample();
        });

        hBox1.getChildren().add(toolBarExample);
        
        
         Button toolTipExample = new Button("tool tip Example");
        toolTipExample.setOnAction((e) -> {
            Examples.toolTipExample();
        });

        hBox1.getChildren().add(toolTipExample);
        
        
        
        
        
         Button progressBarExample = new Button("progressBarExample");
        progressBarExample.setOnAction((e) -> {
            Examples.progressBarExample();
        });

        hBox1.getChildren().add(progressBarExample);
        
        
         Button fileChooserExample = new Button("fileChooserExample");
        fileChooserExample.setOnAction((e) -> {
            Examples.fileChooserExample();
        });

        hBox1.getChildren().add(fileChooserExample);

        

        VBox vBox = new VBox();
        hBox.setSpacing(2);
        vBox.setSpacing(2);
        vBox.getChildren().addAll(hBox,hBox1);
        Scene scene = new Scene(vBox, 1000, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
