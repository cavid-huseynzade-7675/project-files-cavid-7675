 
package com.main;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Examples {

    static int sliderCount = 0;

    static void sliderExample() {

        Stage stage = new Stage();
        stage.setTitle("Slider example");

        VBox vb = new VBox();
        Slider slider = new Slider(0, 100, 50);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(10);
        slider.setMinorTickCount(4);
        Label label = new Label();

        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            label.setText(String.format("%d", (int) newValue.doubleValue()));

            sliderCount++;
            if (sliderCount % 10 == 0) {
                System.out.println(sliderCount);
            }

        });
        vb.getChildren().addAll(slider, label);
        slider.orientationProperty().set(Orientation.HORIZONTAL);

        Scene scene = new Scene(vb, 800, 500);
        stage.setScene(scene);
        stage.show();

    }

    static void checkBoxExample() {

        Stage stage = new Stage();
        stage.setTitle("checkBox Example");

        VBox vb = new VBox();

        CheckBox myCheckBox = new CheckBox();
        myCheckBox.setText("my check text");
        myCheckBox.setAllowIndeterminate(true);
        myCheckBox.setIndeterminate(true);
        myCheckBox.setOnAction((e) -> {
            System.out.println("isSelected = " + myCheckBox.isSelected());
            System.out.println("isIndeterminate = " + myCheckBox.isIndeterminate());
        });
        Button myBtn = new Button("print check box properties");
        myBtn.setOnAction((e) -> {
            System.out.println("isSelected = " + myCheckBox.isSelected());
            System.out.println("isIndeterminate = " + myCheckBox.isIndeterminate());

        });

        vb.getChildren().addAll(myCheckBox, myBtn);

        Scene scene = new Scene(vb, 800, 500);
        stage.setScene(scene);
        stage.show();

    }

    static void passwordFieldExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("PasswordField Experiment 1");

        PasswordField passwordField = new PasswordField();

        Button button = new Button("Click to get password");

        button.setOnAction(action -> {
            System.out.println(passwordField.getText());
        });

        HBox hbox = new HBox(passwordField, button);

        Scene scene = new Scene(hbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    static void textAreaExample() {
        Stage primaryStage = new Stage();

        primaryStage.setTitle("TextArea Experiment 1");

        TextArea textArea = new TextArea();

        Button button = new Button("Click to get text");

        button.setOnAction(action -> {
            System.out.println(textArea.getText());

        });

        Button button2 = new Button("set text");
        Tooltip tt = new Tooltip("bu duyme ile textarea komponentinin daxiline yazi yazdiririq");
        button2.setTooltip(tt);
        button2.setOnAction(action -> {
          textArea.setText("salam\nhello\nprivet");

        });

        VBox vbox = new VBox(textArea, button,button2);

        Scene scene = new Scene(vbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}