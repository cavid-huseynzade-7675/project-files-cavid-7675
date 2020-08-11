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
        primaryStage.setTitle("JavaFX Examples");
        HBox hBox = new HBox();
        
        HBox hBox2 = new HBox();
         HBox hBox3 = new HBox();
        Button buttonExample = new Button("Button");
        buttonExample.setOnAction((e) -> {
            Examples.buttonExample();
        });

        Button sliderExample = new Button("Slider");
        sliderExample.setOnAction((e) -> {
            Examples.sliderExample();
        });

        hBox.getChildren().add(buttonExample);
        hBox.getChildren().add(sliderExample);

        Button sliderExampleImage = new Button("Slider Image");
        sliderExampleImage.setOnAction((e) -> {

            SliderImageExample sie = new SliderImageExample();

            sie.sliderExampleImage();
        });

        hBox.getChildren().add(sliderExampleImage);

        Button toolTipExample = new Button("Tooltip");
        toolTipExample.setOnAction((e) -> {

            Examples.toolTipExample();

        });

        hBox.getChildren().add(toolTipExample);

        Button titledPaneExample = new Button("Titled Pane");
        titledPaneExample.setOnAction((e) -> {

            Examples.titledPaneExample();

        });

        hBox.getChildren().add(titledPaneExample);
        
        
        
        
          Button accordionExample = new Button("Accordion");
        accordionExample.setOnAction((e) -> {

            Examples.accordionExample();

        });

        hBox.getChildren().add(accordionExample);
        
        
        
        
        
        
          Button splitPaneExample = new Button("SplitPane");
        splitPaneExample.setOnAction((e) -> {

            Examples.splitPaneExample();

        });

        hBox.getChildren().add(splitPaneExample);
        
        
           
          Button tabPaneExample = new Button("TabPane");
        tabPaneExample.setOnAction((e) -> {

            Examples.tabPaneExample();

        });

        hBox.getChildren().add(tabPaneExample);
        
        
        
        
         Button scrollPaneExample = new Button("ScrollPane");
        scrollPaneExample.setOnAction((e) -> {

            Examples.scrollPaneExample();

        });

        hBox.getChildren().add(scrollPaneExample);
        
        
        
        
        
        
        
        
         
         Button hBoxExample = new Button("HBox");
        hBoxExample.setOnAction((e) -> {

            Examples.hBoxExample();

        });

        hBox.getChildren().add(hBoxExample);
        
        
        
        
        
        Button menuBarExample = new Button("Menu Bar");
        menuBarExample.setOnAction((e) -> {

            Examples.menuBarExample();

        });

        hBox.getChildren().add(menuBarExample);
        
        
        
        
        
        
        
        
        
         Button contextMenuExample = new Button("Context Menu");
        contextMenuExample.setOnAction((e) -> {

            Examples2.contextMenuExample();

        });

        hBox2.getChildren().add(contextMenuExample);
        
        
        
           Button webViewExample = new Button("WebView");
        webViewExample.setOnAction((e) -> {

            Examples2.webViewExample();

        });

        hBox2.getChildren().add(webViewExample);
        Button pieChartExample = new Button("PieChart");
        pieChartExample.setOnAction((e) -> {

            Examples2.pieChartExample();

        });

     hBox2.getChildren().add(pieChartExample);

        Button tableViewExample = new Button("TableView");
        tableViewExample.setOnAction((e) -> {

            Examples2.tableViewExample();

        });

        hBox2.getChildren().add(tableViewExample);
        
        
        Button treeViewExample = new Button("TreeView");
        treeViewExample.setOnAction((e) -> {

            Examples2.treeViewExample();

        });

        hBox2.getChildren().add(treeViewExample);

          Button treeTableViewExample = new Button("TreeTableView");
        treeTableViewExample.setOnAction((e) -> {

            Examples2.treeTableViewExample();

        });

        hBox2.getChildren().add(treeTableViewExample);
        
        
        
        
        
        
            Button HTMLEditorExample = new Button("HTMLEditor");
        HTMLEditorExample.setOnAction((e) -> {

            Examples2.HTMLEditorExample();

        });

        hBox2.getChildren().add(HTMLEditorExample);
        
        
        
        
         Button paginationExample = new Button("Pagination");
        paginationExample.setOnAction((e) -> {

            Examples2.paginationExample();

        });

        hBox2.getChildren().add(paginationExample);
        
        
        
            Button barChartExample = new Button("BarChart");
        barChartExample.setOnAction((e) -> {

            Examples2.barChartExample();

        });

        hBox2.getChildren().add(barChartExample);
        
        
         Button stackedBarChartExample = new Button("StackedBarChart");
        stackedBarChartExample.setOnAction((e) -> {

            Examples2.stackedBarChartExample();

        });

        hBox2.getChildren().add(stackedBarChartExample);
        
        
        
        
         Button scatterChartExample = new Button("ScatterChart");
        scatterChartExample.setOnAction((e) -> {

            Examples2.scatterChartExample();

        });

        hBox3.getChildren().add(scatterChartExample);
        
          Button lineChartExample = new Button("LineChart");
        lineChartExample.setOnAction((e) -> {

            Examples3.lineChartExample();

        });

        hBox3.getChildren().add(lineChartExample);
        
        
Button areaChartExample = new Button("AreaChart");
        areaChartExample.setOnAction((e) -> {

            Examples3.areaChartExample();

        });

        hBox3.getChildren().add(areaChartExample);
        
        
        Button stackedAreaChartExample = new Button("StackedAreaChart");
        stackedAreaChartExample.setOnAction((e) -> {

            Examples3.stackedAreaChartExample();

        });

        hBox3.getChildren().add(stackedAreaChartExample);
        
        Button effectsExample = new Button("Effects");
        effectsExample.setOnAction((e) -> {

            Examples3.effectsExample();

        });

        hBox3.getChildren().add(effectsExample);
        
        
        
        
         Button concurrencyExample = new Button("Concurrency");
        concurrencyExample.setOnAction((e) -> {

            Examples3.concurrencyExample();

        });

        hBox3.getChildren().add(concurrencyExample);
        
        
        
        
        
        VBox vBox = new VBox();
        hBox.setSpacing(2);
        hBox2.setSpacing(2);
        hBox3.setSpacing(2);
        vBox.setSpacing(2);
        vBox.getChildren().addAll(hBox, hBox2,hBox3);
        Scene scene = new Scene(vBox, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
