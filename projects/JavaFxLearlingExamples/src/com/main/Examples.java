package com.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Examples {

    static void buttonExample() {
        Stage primaryStage = new Stage();

        primaryStage.setTitle("Button");

        Button button = new Button("My Button");

        Scene scene = new Scene(button, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    static void sliderExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Slider");

        Slider slider = new Slider(0, 100, 0);
        slider.setMajorTickUnit(8.0);
        slider.setMinorTickCount(4);
        slider.setSnapToTicks(true);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
         
        
        slider.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov,
                        Number old_val, Number new_val) {
                    System.out.println("kohne = "+old_val+", yeni = "+new_val);
                }
            });
        VBox vBox = new VBox(slider);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void sliderExampleImage() {
    }

    static void toolTipExample() {
        Stage primaryStage = new Stage();

        primaryStage.setTitle("ToolTip");
        Tooltip tooltip = new Tooltip("This text is explanatory text");
        Button button = new Button("My Button");
        tooltip.setTextAlignment(TextAlignment.JUSTIFY);
        try {
            FileInputStream input = new FileInputStream("images/a.PNG");
            Image image = new Image(input);

            ImageView cappuccino = new ImageView(image);

            tooltip.setGraphic(cappuccino);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        button.setTooltip(tooltip);

        Scene scene = new Scene(button, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    static void titledPaneExample() {
        Stage primaryStage = new Stage();

        primaryStage.setTitle("Titled pane");
        Label label = new Label("The content inside the TitledPane");
        TitledPane titledPane = new TitledPane("The Title", label);

        Scene scene = new Scene(new VBox(titledPane), 500, 500);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    static void accordionExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Accordion");
        Accordion accordion = new Accordion();

        TitledPane pane1 = new TitledPane("Boats", new Label("Show all boats available"));
        TitledPane pane2 = new TitledPane("Cars", new Label("Show all cars available"));
        TitledPane pane3 = new TitledPane("Planes", new Label("Show all planes available"));

        accordion.getPanes().add(pane1);
        accordion.getPanes().add(pane2);
        accordion.getPanes().add(pane3);

        VBox vBox = new VBox(accordion);
        Scene scene = new Scene(vBox, 500, 500);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    static void splitPaneExample() {

        Stage primaryStage = new Stage();
        primaryStage.setTitle("SplitPane");
        SplitPane splitPane = new SplitPane();

        VBox leftControl = new VBox(new Label("Left Control"));
        VBox mid1Control = new VBox(new Label("Mid 1 Control"));
        VBox mid2Control = new VBox(new Label("Mid 2 Control"));

        VBox rightControl = new VBox(new Label("Right Control"));

        splitPane.getItems().addAll(leftControl, mid1Control, mid2Control, rightControl);

        Scene scene = new Scene(splitPane, 500, 500);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    static void tabPaneExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("TabPane");
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Planes", new Label("Show all planes available"));
        tab1.setClosable(false);
        Tab tab2 = new Tab("Cars", new Label("Show all cars available"));
        Tab tab3 = new Tab("Boats", new Label("Show all boats available"));

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        tabPane.setOnMousePressed((e) -> {
            Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
            System.out.println(selectedTab.getText());

        });
        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");

        primaryStage.show();
    }

    static void scrollPaneExample() {
        try {
            Stage primaryStage = new Stage();
            primaryStage.setTitle("ScrollPane");
            ScrollPane scrollPane = new ScrollPane();

            String imagePath = "images/cappuccino.jpg";
            ImageView imageView = new ImageView(new Image(new FileInputStream(imagePath)));

            scrollPane.setContent(imageView);
            scrollPane.pannableProperty().set(true);
            scrollPane.fitToWidthProperty().set(true);
            scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            Scene scene = new Scene(scrollPane, 200, 200);

            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    static void hBoxExample() {
        try {
            Stage primaryStage = new Stage();
            primaryStage.setTitle("HBox");
            Button button1 = new Button("Button Number 1");
            Button button2 = new Button("Button Number 2");
            Button button3 = new Button("Button Number 3");
            Button button4 = new Button("Button Number 4");

            HBox hBox = new HBox(20, button1, button2, button3, button4);
            HBox.setMargin(button1, new Insets(10, 10, 10, 10));
            HBox.setMargin(button2, new Insets(10, 10, 10, 10));
            HBox.setMargin(button3, new Insets(10, 10, 10, 10));
            hBox.setAlignment(Pos.BASELINE_CENTER);

            Scene scene = new Scene(hBox, 200, 200);

            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void menuBarExample() {
        try {
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Menu Bar");
            MenuItem item1 = new MenuItem("Menu item 1");
            MenuItem item2 = new MenuItem("Menu item 2");
               MenuItem item7 = new MenuItem("Menu item 7");
            
            
            item1.setOnAction(e -> {
                System.out.println("Menu Item 1 Selected");
            });
            item2.setOnAction(e -> {
                System.out.println("Menu Item 2 Selected");
            });item7.setOnAction(e -> {
                System.out.println("Menu Item 7 Selected");
            });

            Menu menu1 = new Menu("Menu 1");
            menu1.setOnShowing((e) -> {
                System.out.println("Menu 1 OnShowing");
            });
            menu1.setOnShown((e) -> {
                System.out.println("Menu 1 OnShown");
            });
            menu1.setOnHiding((e) -> {
                System.out.println("Menu 1 OnHiding");
            });
            menu1.setOnHidden((e) -> {
                System.out.println("Menu 1 OnHidden");
            });

           
            MenuBar menuBar = new MenuBar();
            try {
                FileInputStream input = new FileInputStream("images/a.PNG");
                Image image = new Image(input);

                ImageView img = new ImageView(image);

                menu1.setGraphic(img);

                FileInputStream input2 = new FileInputStream("images/spring1.jpg");
                Image image2 = new Image(input2);

                ImageView img2 = new ImageView(image2);

                item1.setGraphic(img2);

                FileInputStream input3 = new FileInputStream("images/spring2.png");
                Image image3 = new Image(input3);

                ImageView img3 = new ImageView(image3);

                item2.setGraphic(img3);
                
                
                
                 FileInputStream input4 = new FileInputStream("images/ya.jpg");
                Image image4 = new Image(input4);

                ImageView img4 = new ImageView(image4);

                item7.setGraphic(img4);
                
                
                

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
              MenuItem item3 = new MenuItem("Menu item 3");
            MenuItem item4 = new MenuItem("Menu item 4");
            
            
            
            item3.setOnAction(e -> {
                System.out.println("Menu Item 3 Selected");
            });
            item4.setOnAction(e -> {
                System.out.println("Menu Item 4 Selected");
            });
            
            
            
               Menu menu2 = new Menu("Menu 2");
               menu2.getItems().addAll(item3,item4);
               
               
               CheckMenuItem checkMenuItem = new CheckMenuItem("Check this!");
                menu1.getItems().addAll(item1, item2,item7,menu2,checkMenuItem);
               
                
                
                
                
                
                 

RadioMenuItem choice1Item = new RadioMenuItem("Choice 1");
RadioMenuItem choice2Item = new RadioMenuItem("Choice 2");
RadioMenuItem choice3Item = new RadioMenuItem("Choice 3");

ToggleGroup toggleGroup = new ToggleGroup();
toggleGroup.getToggles().add(choice1Item);
toggleGroup.getToggles().add(choice2Item);
toggleGroup.getToggles().add(choice3Item);


SeparatorMenuItem separator = new SeparatorMenuItem();


menu1.getItems().add(choice1Item);
menu1.getItems().add(separator);
menu1.getItems().add(choice2Item);

 
menu1.getItems().add(choice3Item);

 
 
 
Slider slider = new Slider(0, 100, 50);

CustomMenuItem customMenuItem = new CustomMenuItem();
customMenuItem.setContent(slider);
customMenuItem.setHideOnClick(false);
menu1.getItems().add(customMenuItem);

Button button = new Button("Custom Menu Item Button");
CustomMenuItem customMenuItem2 = new CustomMenuItem();
customMenuItem2.setContent(button);
customMenuItem2.setHideOnClick(false);
menu1.getItems().add(customMenuItem2);

 




            menuBar.getMenus().add(menu1);

            VBox vBox = new VBox(menuBar);

            Scene scene = new Scene(vBox, 960, 600);

            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
