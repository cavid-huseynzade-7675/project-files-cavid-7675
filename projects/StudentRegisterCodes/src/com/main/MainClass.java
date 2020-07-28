package com.main;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class MainClass extends Application {

    int eded = 1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    public void start(Stage ps) throws Exception {
        Label label = new Label("              Ad           ");
        TextField ad = new TextField();
        HBox hBox = new HBox();
        hBox.getChildren().add(label);
        hBox.getChildren().add(ad);

        RadioButton goy = new RadioButton("Goy");
        RadioButton qirmizi = new RadioButton("Qirmizi");
        RadioButton yasil = new RadioButton("Yasil");
        RadioButton ag = new RadioButton("Ag");
        ToggleGroup qrup1 = new ToggleGroup();
        goy.setToggleGroup(qrup1);
        qirmizi.setToggleGroup(qrup1);
        yasil.setToggleGroup(qrup1);
        ag.setToggleGroup(qrup1);
        ToggleButton visible = new ToggleButton("Gizlet");

        Label label1 = new Label("      Tevellud          ");
        DatePicker yas = new DatePicker();
        HBox hBox1 = new HBox();
        hBox1.getChildren().add(label1);
        hBox1.getChildren().add(yas);

        Button myButton = new Button("Elave et");
        Button myButton1 = new Button("Hamisini sil");
        HBox hBox7 = new HBox();
        hBox7.getChildren().add(myButton);
         hBox7.getChildren().add(myButton1);
        hBox7.getChildren().add(goy);
        hBox7.getChildren().add(qirmizi);
        hBox7.getChildren().add(yasil);
        hBox7.getChildren().add(ag);
        hBox7.getChildren().add(visible);

        Label label2 = new Label("                             Ad           ");
        Label label3 = new Label("                            Tevellud          ");
        HBox hBox3 = new HBox();
        hBox3.getChildren().add(label2);
        hBox3.getChildren().add(label3);

        ListView<String> listview = new ListView<>();
        ListView<String> listview1 = new ListView<>();
        Slider slider = new Slider(0, 100, 100);
        slider.orientationProperty().set(Orientation.VERTICAL);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(10);
        slider.setMinorTickCount(9);
        HBox hBox4 = new HBox();
        hBox4.getChildren().add(listview);
        hBox4.getChildren().add(listview1);
        hBox4.getChildren().add(slider);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            listview.setOpacity(newValue.doubleValue() / 100);
            listview1.setOpacity(newValue.doubleValue() / 100);

        });

        myButton.setOnAction((e) -> {
            boolean allowRegister = true;

            String Ad = ad.getText();
            LocalDate Yas = yas.getValue();

            if (Yas == null) {
                allowRegister = false;
                JOptionPane.showMessageDialog(null, "Tevvellud secmek lazimdir");

            }
            if (allowRegister) {
                String Yas1 = Yas.toString();
                listview.getItems().add(eded + "." + Ad);
                listview1.getItems().add(eded + "." + Yas1);
                eded++;
            }

        });
        visible.setOnAction((e) -> {
            boolean secili = visible.isSelected();
            if (!secili) {
                hBox.setVisible(secili);
                hBox1.setVisible(secili);
                hBox3.setVisible(secili);
                hBox4.setVisible(secili);
                myButton.setVisible(secili);
                goy.setVisible(secili);
                qirmizi.setVisible(secili);
                yasil.setVisible(secili);
                ag.setVisible(secili);
                visible.setText("Goster");

            } else {
                hBox.setVisible(secili);
                hBox1.setVisible(secili);
                hBox3.setVisible(secili);
                hBox4.setVisible(secili);
                myButton.setVisible(secili);
                goy.setVisible(secili);
                qirmizi.setVisible(secili);
                yasil.setVisible(secili);
                ag.setVisible(secili);
                visible.setText("Gizlet");
            }

        });
        VBox vBox = new VBox();
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(hBox7);
        vBox.getChildren().add(hBox3);
        vBox.getChildren().add(hBox4);

        Scene scene = new Scene(vBox, 700, 500);

        goy.setOnAction((e) -> {
            vBox.setStyle("-fx-background-color:blue");
        });

        qirmizi.setOnAction((e) -> {
            vBox.setStyle("-fx-background-color:red");
        });

        yasil.setOnAction((e) -> {
            vBox.setStyle("-fx-background-color:green");
        });
        ag.setOnAction((e) -> {
            vBox.setStyle("-fx-background-color:white");
        });
 myButton1.setOnAction((e) -> {
            listview.getItems().clear();
                listview1.getItems().clear();
                eded=1;
        });
        ps.setScene(scene);
        ps.setTitle("StudentRegister");
        ps.show();
    }

}
