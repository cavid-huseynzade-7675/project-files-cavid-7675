package com.main;

import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class Examples3 {

    static void lineChartExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("LineChart");

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("No of employees");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue per employee");

        LineChart lineChart = new LineChart(xAxis, yAxis);
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data(1, 567));
        dataSeries1.getData().add(new XYChart.Data(5, 612));
        dataSeries1.getData().add(new XYChart.Data(10, 800));
        dataSeries1.getData().add(new XYChart.Data(20, 780));
        dataSeries1.getData().add(new XYChart.Data(40, 810));
        dataSeries1.getData().add(new XYChart.Data(80, 850));

        lineChart.getData().add(dataSeries1);
        VBox vBox = new VBox(lineChart);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void areaChartExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("AreaChart");

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("No of employees");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue per employee");

        AreaChart areaChart = new AreaChart(xAxis, yAxis);
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data(1, 567));
        dataSeries1.getData().add(new XYChart.Data(5, 612));
        dataSeries1.getData().add(new XYChart.Data(10, 800));
        dataSeries1.getData().add(new XYChart.Data(20, 780));
        dataSeries1.getData().add(new XYChart.Data(40, 810));
        dataSeries1.getData().add(new XYChart.Data(80, 850));

        areaChart.getData().add(dataSeries1);

        VBox vBox = new VBox(areaChart);

        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void stackedAreaChartExample() {

        Stage primaryStage = new Stage();
        primaryStage.setTitle("StackedAreaChart");
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("No of employees");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue per employee");

        StackedAreaChart stackedAreaChart = new StackedAreaChart(xAxis, yAxis);
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Desktop");

        dataSeries1.getData().add(new XYChart.Data(0, 567));
        dataSeries1.getData().add(new XYChart.Data(1, 612));
        dataSeries1.getData().add(new XYChart.Data(2, 800));
        dataSeries1.getData().add(new XYChart.Data(3, 780));
        dataSeries1.getData().add(new XYChart.Data(4, 650));
        dataSeries1.getData().add(new XYChart.Data(5, 610));
        dataSeries1.getData().add(new XYChart.Data(6, 590));

        stackedAreaChart.getData().add(dataSeries1);

        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("Mobile");

        dataSeries2.getData().add(new XYChart.Data(0, 101));
        dataSeries2.getData().add(new XYChart.Data(1, 110));
        dataSeries2.getData().add(new XYChart.Data(2, 140));
        dataSeries2.getData().add(new XYChart.Data(3, 132));
        dataSeries2.getData().add(new XYChart.Data(4, 115));
        dataSeries2.getData().add(new XYChart.Data(5, 109));
        dataSeries2.getData().add(new XYChart.Data(6, 105));

        stackedAreaChart.getData().add(dataSeries2);
        VBox vBox = new VBox(stackedAreaChart);

        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    static void effectsExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Effects");
        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setRadius(1);
        dropShadow1.setOffsetX(10);
        dropShadow1.setOffsetY(10);
        dropShadow1.setColor(Color.web("#333333"));

        Circle circle1 = new Circle(75, 75, 50, Color.RED);
        circle1.setEffect(dropShadow1);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(5);
        dropShadow2.setOffsetX(20);
        dropShadow2.setOffsetY(20);
        dropShadow2.setColor(Color.web("#660066"));

        Circle circle2 = new Circle(200, 75, 50, Color.GREEN);
        circle2.setEffect(dropShadow2);

        DropShadow dropShadow3 = new DropShadow();
        dropShadow3.setRadius(25);
        dropShadow3.setOffsetX(30);
        dropShadow3.setOffsetY(30);
        dropShadow3.setColor(Color.web("#006666"));

        Circle circle3 = new Circle(325, 75, 50, Color.BLUE);
        circle3.setEffect(dropShadow3);
        VBox vbox = new VBox();
        vbox.getChildren().add(new Pane(circle1, circle2, circle3));

        Text text = new Text("Reflection Effect");
        text.setLayoutX(30);
        text.setLayoutY(20);
        text.setTextOrigin(VPos.TOP);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        Reflection reflection = new Reflection();
        reflection.setTopOffset(0);
        reflection.setTopOpacity(0.75);
        reflection.setBottomOpacity(0.10);
        reflection.setFraction(0.7);

        text.setEffect(reflection);
        vbox.getChildren().add(text);

        GaussianBlur blur = new GaussianBlur();
        blur.setRadius(5);

        Text text1 = new Text("Blur Effect 1");
        text1.setLayoutX(30);
        text1.setLayoutY(20);
        text1.setTextOrigin(VPos.TOP);
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        text1.setEffect(blur);

        GaussianBlur blur2 = new GaussianBlur();
        blur2.setRadius(10);

        Text text2 = new Text("Blur Effect 2");
        text2.setLayoutX(30);
        text2.setLayoutY(100);
        text2.setTextOrigin(VPos.TOP);
        text2.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        text2.setEffect(blur2);

        vbox.getChildren().addAll(text1, text2);
        vbox.setSpacing(60);

        Scene scene = new Scene(vbox, 825, 550);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    static void concurrencyExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Concurrency");
        

        ProgressBar progressBar = new ProgressBar(0);

        VBox vBox = new VBox(progressBar);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

        Thread taskThread = new Thread(new Runnable() {
            @Override
            public void run() {
                double progress = 0;
                for (int i = 0; i < 10; i++) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progress += 0.1;
                    final double reportedProgress = progress;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            progressBar
                                    .setProgress(reportedProgress);
                        }
                    });
                }
            }
        });

        taskThread.start();
    }

}
