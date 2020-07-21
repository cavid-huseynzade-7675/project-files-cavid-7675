package com.main;

import java.util.Iterator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Examples2 {

    static void contextMenuExample() {
        try {
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Context Menu");

            ContextMenu contextMenu = new ContextMenu();
            MenuItem menuItem1 = new MenuItem("Choice 1");
            MenuItem menuItem2 = new MenuItem("Choice 2");
            MenuItem menuItem3 = new MenuItem("Choice 3");

            menuItem3.setOnAction((event) -> {
                System.out.println("Choice 3 clicked!");
            });

            contextMenu.getItems().addAll(menuItem1, menuItem2, menuItem3);

            TextArea textArea = new TextArea();

            textArea.setContextMenu(contextMenu);
            textArea.setText("This JavaFX control\nhas context menu");
            VBox vBox = new VBox(textArea);
            Scene scene = new Scene(vBox);

            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void webViewExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("JavaFX WebView Example. yalizada.com");

        WebView webView = new WebView();
        Slider slider = new Slider(0, 1.0, 1.0);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {

                webView.setZoom((Double) new_val);
            }
        });
        webView.getEngine().load("http://yalizada.com");
        WebEngine webEngine = webView.getEngine();

        webEngine.setUserAgent("MyApp Web Browser 1.0 - AppleWebKit/555.99 JavaFX 8.0");
        webView.setContextMenuEnabled(false);

        webView.setFontScale(1.5);
        VBox vBox = new VBox();

        Button button = new Button("see history");
        button.setOnAction((e) -> {
            WebHistory history = webEngine.getHistory();
            ObservableList<WebHistory.Entry> entries = history.getEntries();

            Iterator<WebHistory.Entry> iterator = entries.iterator();
            while (iterator.hasNext()) {
                WebHistory.Entry entry = iterator.next();
                System.out.println("url > " + entry.getUrl());
                System.out.println("Title > " + entry.getTitle());
                System.out.println("Last visited date > " + entry.getLastVisitedDate());

            }

        });

        Button goToEngagement = new Button("Go To Engagement");
        goToEngagement.setOnAction((e) -> {

            webEngine.load("http://164.68.100.161:8081/engagement/login");
        });

        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println("oldValue: " + oldValue);
                System.out.println("newValue: " + newValue);

                if (newValue == Worker.State.SUCCEEDED) {

                    System.out.println("document finished loading");

                }
            }
        }
        );

        vBox.getChildren().addAll(slider, button, goToEngagement, webView);

        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

