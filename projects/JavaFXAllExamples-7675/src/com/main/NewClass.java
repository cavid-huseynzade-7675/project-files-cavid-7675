package com.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

class Examples {
static  String cavab;
    static String[] Imagenames = new String[6];
    static String[] Imagepaths = new String[6];
    static int currentImageIndex = 0;
    static int sliderCount = 0;
   static ImageView flag;
  static Label results;
   static ComboBox images;

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

        VBox vbox = new VBox(textArea, button, button2);

        Scene scene = new Scene(vbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void choiceBoxExample() {
        Stage primaryStage1 = new Stage();

        ChoiceBox<String> choiceBox = new ChoiceBox();

        choiceBox.getItems().add("1 ci sual");
        choiceBox.getItems().add("2 ci sual");
        choiceBox.getItems().add("3 cu sual");
        
       
        
        
        Label  lb=new Label("        sual");
        Label  lwe=new Label();
        RadioButton bir=new RadioButton();
         RadioButton iki=new RadioButton();
          RadioButton uc=new RadioButton();
           RadioButton dord=new RadioButton();
        ToggleGroup tg=new ToggleGroup();
        bir.setToggleGroup(tg);
          iki.setToggleGroup(tg);
            uc.setToggleGroup(tg);
             dord.setToggleGroup(tg);
            Button btn=new Button("cavabi tesdiqle");
        HBox hb=new HBox(bir,iki,uc,dord,btn);
        hb.setSpacing(7.5);
        
        primaryStage1.setTitle("choiceBoxExample");
        VBox vbox = new VBox(choiceBox);
           vbox.getChildren().addAll(lb,lwe);
        vbox.getChildren().add(hb);
        vbox.setSpacing(30);
         choiceBox.setOnAction((e) -> {;
  
        if (choiceBox.getValue()=="1 ci sual"){
           lb.setText("HAnsi primitiv tip degil");
           bir.setText("int");
              iki.setText("double");
                uc.setText("string");
                     dord.setText("char");
         }else if(choiceBox.getValue()=="2 ci sual"){
            lb.setText("Button haradan import olunur"); 
           bir.setText("import javafx.stage.control.Button");
              iki.setText("javafx.awt.Button");
                uc.setText("import javafx.scene.node.Button");
                     dord.setText(" import javafx.scene.control.Button");

             
             
         }else{
           lb.setText("nece for dovru var");
           bir.setText("1");
              iki.setText("4");
                uc.setText("2");
                     dord.setText("3");
   
             
         }
         });
              bir.setOnAction((e) -> {
                 if (choiceBox.getValue()=="1 ci sual"){
          cavab="sehv";
         }else if(choiceBox.getValue()=="2 ci sual"){
           
             
              cavab="Sehv";
             
         }else{
           
           cavab="Sehv";   
         }        
              });
   iki.setOnAction((e) -> {
                  
                  if (choiceBox.getValue()=="1 ci sual"){
           cavab="sehv";
         }else if(choiceBox.getValue()=="2 ci sual"){
           
              cavab="sehv";
             
             
         }else{
            cavab="duz";
             
         }              
              });
   uc.setOnAction((e) -> {
                  
                      if (choiceBox.getValue()=="1 ci sual"){
           cavab="Duz";
         }else if(choiceBox.getValue()=="2 ci sual"){
           
              cavab="sehv";
             
             
         }else{
           
             cavab="sehv"; 
         }          
              });
     dord.setOnAction((e) -> {
                     if (choiceBox.getValue()=="1 ci sual"){
            cavab="Sehv";
         }else if(choiceBox.getValue()=="2 ci sual"){
           
             
               cavab="Duz";
             
         }else{
           
              cavab="Sehv"; 
         }           
                  
              });
        btn.setOnAction((e) -> {
         lwe.setText(cavab);
        });

      
      
        Scene scene = new Scene(vbox, 900, 500);
        primaryStage1.setScene(scene);
        primaryStage1.show();
    }

    static void ComboBoxExample(){
        Stage primaryStage2 = new Stage();

        primaryStage2.setTitle("ComboBoxExample");

        ImageView flag = new ImageView();

        Label results = new Label("seklin adi");

        ComboBox images = new ComboBox();
        images.getItems().add("Az");
        images.getItems().add("Rus");
        images.getItems().add("Turkiye");
        images.getItems().add("Amerika");
        images.getItems().add("Ingiltere");
        images.getItems().add("Almaniya");

       Imagenames[0] = "Az";
        Imagenames[1] = "Rus";
        Imagenames[2] = "Turkiye";
        Imagenames[3] = "Amerika";
        Imagenames[4] = "Ingiltere";
        Imagenames[5] = "Almaniya";

        Imagepaths[0] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\JavaFXAllExamples-7675\\images\\Azerbaycan.jpeg";
        Imagepaths[1] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\JavaFXAllExamples-7675\\images\\rusiya.png";
        Imagepaths[2] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\JavaFXAllExamples-7675\\images\\turkiye.png";
        Imagepaths[3] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\JavaFXAllExamples-7675\\images\\Amerika.png";
        Imagepaths[4] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\JavaFXAllExamples-7675\\images\\Ingiltere.png";
        Imagepaths[5] = "C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\projects\\JavaFXAllExamples-7675\\images\\Almaniya.png";

        images.setOnAction((e) -> {
          
            for (int i = 0; i <= Imagenames.length; i++) {

                String selected = images.getSelectionModel().getSelectedItem().toString();
                if (selected == Imagenames[currentImageIndex]) {
                    try {
                          System.out.println("com.main.Examples.ComboBoxExample()");
                         FileInputStream input2 = new FileInputStream(Imagepaths[currentImageIndex]);
        Image image2 = new Image(input2);
        flag.setImage(image2);
        results.setText(Imagenames[currentImageIndex]);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Examples.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                } else {
                    currentImageIndex++;
                }
            }
            currentImageIndex = 0;
        });
        HBox hbox = new HBox(images,flag,results);
        Scene scene = new Scene(hbox, 500, 500);
        primaryStage2.setScene(scene);
        primaryStage2.show();
    }

    static void listviewExample() {
        Stage primaryStage3 = new Stage();

        primaryStage3.setTitle("listviewExample");

        ListView<String> list = new ListView();
        TextField text = new TextField();
        Button btn = new Button("Elave et");
        btn.setOnAction((e) -> {

            String tex = text.getText();
            list.getItems().add(tex);
        });

        HBox hb = new HBox(list, text, btn);
        VBox vbox = new VBox(hb);
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage3.setScene(scene);
        primaryStage3.show();
    }

    static void datepickerExample() {
        Stage primaryStage4 = new Stage();

        primaryStage4.setTitle("datepickerExample");

        DatePicker date = new DatePicker();
        Label lab = new Label();
        Button btn = new Button("Elave et");

        btn.setOnAction((e) -> {

            LocalDate tex = date.getValue();
            String tex1 = tex.toString();
            lab.setText(tex1);

        });

        HBox hb = new HBox(date, lab, btn);
        VBox vbox = new VBox(hb);
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage4.setScene(scene);
        primaryStage4.show();
    }

    static void ColorPickerExample() {
        Stage primaryStage5 = new Stage();

        primaryStage5.setTitle("TextArea Experiment 1");
        ColorPicker colorPicker = new ColorPicker();
        Button setColor = new Button("reng qoy");

        VBox vbox = new VBox(colorPicker, setColor);
        setColor.setOnAction((e) -> {

            Color value = colorPicker.getValue();
            vbox.setBackground(new Background(new BackgroundFill(value, CornerRadii.EMPTY, Insets.EMPTY)));
        });
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage5.setScene(scene);
        primaryStage5.show();
    }

   

}
