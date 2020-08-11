package com.main;

import com.main.model.Car;
import com.main.model.Customer;
import com.main.model.Person;
import java.util.Iterator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.HTMLEditor;
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
 static void pieChartExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("PieChart");

        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("Desktop", 213);
        PieChart.Data slice2 = new PieChart.Data("Phone", 67);
        PieChart.Data slice3 = new PieChart.Data("Tablet", 36);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);

        VBox vbox = new VBox(pieChart);

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(1200);

        primaryStage.show();

    }

    static void tableViewExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("TableView");

        TableView tableView = new TableView();

        TableColumn<String, Person> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<String, Person> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        tableView.setPlaceholder(new Label("No rows to display!"));
        TableViewSelectionModel<Person> selectionModel = tableView.getSelectionModel();

// set selection mode to only 1 row
// selectionModel.setSelectionMode(SelectionMode.SINGLE);
// set selection mode to multiple rows
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        VBox vbox = new VBox(tableView);

        Button button = new Button("Add rows");
        vbox.getChildren().add(button);
        button.setOnAction((e) -> {

            ObservableList<Person> selectedItems = selectionModel.getSelectedItems();
            System.out.println(selectedItems);

            selectedItems.addListener(new ListChangeListener<Person>() {
                @Override
                public void onChanged(Change<? extends Person> change) {
                    System.out.println("Selection changed: " + change.getList());
                }
            });
            ObservableList<Integer> selectedIndices = selectionModel.getSelectedIndices();
            System.out.println(selectedIndices);
            tableView.getItems().add(new Person("John", "Doe"));
            tableView.getItems().add(new Person("Jane", "Deer"));
        });

        Button clear = new Button("Clear selection");
        vbox.getChildren().add(clear);
        clear.setOnAction((e) -> {
            selectionModel.clearSelection();

        });

        TableView tableView2 = new TableView();

        TableColumn<String, Customer> customer = new TableColumn<>("Customer");
        TableColumn<String, Customer> customerId = new TableColumn<>("Customer No");
        TableColumn<String, Customer> name = new TableColumn<>("Name");
        TableColumn<String, Customer> firstName = new TableColumn<>("First Name");
        TableColumn<String, Customer> lastName = new TableColumn<>("Last Name");

        name.getColumns().addAll(firstName, lastName);
        customer.getColumns().addAll(customerId, name);
        tableView2.getColumns().addAll(customer);

        customerId.setCellValueFactory(new PropertyValueFactory<>("customerNo"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView2.getItems().add(new Customer("007", "Jane", "Deer"));
        tableView2.getItems().add(new Customer("006", "John", "Doe"));
        tableView2.getItems().add(new Customer("008", "Mack", "Alamo"));

        vbox.getChildren().add(tableView2);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    static void treeViewExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("TreeView");

        TreeView treeView = new TreeView();
        TreeItem rootItem = new TreeItem("Tutorials");

        TreeItem webItem = new TreeItem("Web Tutorials");
        webItem.getChildren().add(new TreeItem("HTML  Tutorial"));
        webItem.getChildren().add(new TreeItem("HTML5 Tutorial"));
        webItem.getChildren().add(new TreeItem("CSS Tutorial"));
        webItem.getChildren().add(new TreeItem("SVG Tutorial"));
        rootItem.getChildren().add(webItem);

        TreeItem javaItem = new TreeItem("Java Tutorials");
        javaItem.getChildren().add(new TreeItem("Java Language"));
        javaItem.getChildren().add(new TreeItem("Java Collections"));
        javaItem.getChildren().add(new TreeItem("Java Concurrency"));
        rootItem.getChildren().add(javaItem);

        treeView.setRoot(rootItem);
        treeView.setShowRoot(false);
        VBox vbox = new VBox(treeView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    static void treeTableViewExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("TreeTableView");

        TreeTableView<Car> treeTableView = new TreeTableView<Car>();

        TreeTableColumn<Car, String> treeTableColumn1 = new TreeTableColumn<>("Brand");
        TreeTableColumn<Car, String> treeTableColumn2 = new TreeTableColumn<>("Model");

        treeTableColumn1.setCellValueFactory(new TreeItemPropertyValueFactory<>("brand"));
        treeTableColumn2.setCellValueFactory(new TreeItemPropertyValueFactory<>("model"));

        treeTableView.getColumns().add(treeTableColumn1);
        treeTableView.getColumns().add(treeTableColumn2);

        TreeItem mercedes1 = new TreeItem(new Car("Mercedes", "SL500"));
        TreeItem mercedes2 = new TreeItem(new Car("Mercedes", "SL500 AMG"));
        TreeItem mercedes3 = new TreeItem(new Car("Mercedes", "CLA 200"));

        TreeItem mercedes = new TreeItem(new Car("Mercedes", "..."));
        mercedes.getChildren().add(mercedes1);
        mercedes.getChildren().add(mercedes2);
        mercedes.getChildren().add(mercedes3);

        TreeItem audi1 = new TreeItem(new Car("Audi", "A1"));
        TreeItem audi2 = new TreeItem(new Car("Audi", "A5"));
        TreeItem audi3 = new TreeItem(new Car("Audi", "A7"));

        TreeItem audi = new TreeItem(new Car("Audi", "..."));
        audi.getChildren().add(audi1);
        audi.getChildren().add(audi2);
        audi.getChildren().add(audi3);

        TreeItem cars = new TreeItem(new Car("Cars", "..."));
        cars.getChildren().add(audi);
        cars.getChildren().add(mercedes);

        treeTableView.setRoot(cars);

        VBox vbox = new VBox(treeTableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    static void HTMLEditorExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("HTMLEditor");

        HTMLEditor htmlEditor = new HTMLEditor();

        VBox vBox = new VBox(htmlEditor);

        Button button = new Button("Get html text");
        vBox.getChildren().add(button);
        button.setOnAction((e) -> {
            System.out.println(htmlEditor.getHtmlText());

        });

        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    static void paginationExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Pagination");

        Pagination pagination = new Pagination();
        pagination.setPageCount(21);
        pagination.setCurrentPageIndex(3);
        pagination.setMaxPageIndicatorCount(3);

        pagination.setPageFactory((pageIndex) -> {
            System.out.println(pageIndex);
            Label label1 = new Label("Content for page with index: " + pageIndex);
            label1.setFont(new Font("Arial", 24));

            Label label2 = new Label("Main content of the page ...");

            return new VBox(label1, label2);
        });

        VBox vBox = new VBox(pagination);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void barChartExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("BarChart");

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Devices");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Visits");

        BarChart barChart = new BarChart(xAxis, yAxis);
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data("Desktop", 567));
        dataSeries1.getData().add(new XYChart.Data("Phone", 65));
        dataSeries1.getData().add(new XYChart.Data("Tablet", 23));

        barChart.getData().add(dataSeries1);

        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("2015");

        dataSeries2.getData().add(new XYChart.Data("Desktop", 540));
        dataSeries2.getData().add(new XYChart.Data("Phone", 120));
        dataSeries2.getData().add(new XYChart.Data("Tablet", 36));

        barChart.getData().add(dataSeries2);

        VBox vBox = new VBox(barChart);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void stackedBarChartExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("StackedBarChart");

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Devices");
        xAxis.getCategories().addAll("Desktop", "Phone", "Tablet");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Visits");

        StackedBarChart stackedBarChart = new StackedBarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Desktop");

        dataSeries1.getData().add(new XYChart.Data("2014", 567));
        dataSeries1.getData().add(new XYChart.Data("2015", 540));

        stackedBarChart.getData().add(dataSeries1);

        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("Phone");

        dataSeries2.getData().add(new XYChart.Data("2014", 65));
        dataSeries2.getData().add(new XYChart.Data("2015", 120));

        stackedBarChart.getData().add(dataSeries2);

        XYChart.Series dataSeries3 = new XYChart.Series();
        dataSeries3.setName("Tablet");

        dataSeries3.getData().add(new XYChart.Data("2014", 23));
        dataSeries3.getData().add(new XYChart.Data("2015", 36));

        stackedBarChart.getData().add(dataSeries3);
        VBox vBox = new VBox(stackedBarChart);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void scatterChartExample() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("ScatterChart");

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("No of employees");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue per employee");

        ScatterChart scatterChart = new ScatterChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data(1, 567));
        dataSeries1.getData().add(new XYChart.Data(5, 612));
        dataSeries1.getData().add(new XYChart.Data(10, 800));
        dataSeries1.getData().add(new XYChart.Data(20, 780));
        dataSeries1.getData().add(new XYChart.Data(40, 810));
        dataSeries1.getData().add(new XYChart.Data(80, 850));

        scatterChart.getData().add(dataSeries1);

        VBox vBox = new VBox(scatterChart);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    
    }   
}

