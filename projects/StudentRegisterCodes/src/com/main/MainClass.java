package com.main;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class MainClass extends Application {

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

        Label label1 = new Label("      Tevellud          ");
        DatePicker yas = new DatePicker();
        HBox hBox1 = new HBox();
        hBox1.getChildren().add(label1);
        hBox1.getChildren().add(yas);

        Button myButton = new Button("Elave et");

        Label label2 = new Label("                             Ad           ");
        Label label3 = new Label("                            Tevellud          ");
        HBox hBox3 = new HBox();
        hBox3.getChildren().add(label2);
        hBox3.getChildren().add(label3);

        ListView<String> listview = new ListView<>();
        ListView<String> listview1 = new ListView<>();
         HBox hBox4= new HBox();
        hBox4.getChildren().add(listview);
        hBox4.getChildren().add(listview1);
        
        myButton.setOnAction((e)->{
            boolean allowRegister=true;
       
        String Ad = ad.getText();
       LocalDate Yas = yas.getValue();
    
       if(Yas==null){
           allowRegister=false;
           JOptionPane.showMessageDialog(null,"Tevvellud secmek lazimdir");
           
       }
       if(allowRegister){
       String Yas1=Yas.toString();
        listview.getItems().add(Ad);
        listview1.getItems().add(Yas1);
       }
        });
        
        VBox vBox = new VBox();
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(myButton);
        vBox.getChildren().add(hBox3);
        vBox.getChildren().add(hBox4);
        Scene scene = new Scene(vBox, 430, 430);

        ps.setScene(scene);
        ps.setTitle("StudentRegister");
        ps.show();
    }

}
