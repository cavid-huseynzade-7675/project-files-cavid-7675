package az.developia.student.controller;



import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {
int eded = 1;
    @FXML
    private TextField usernameTF;

    @FXML
    private Label AlertsLabel;

    @FXML
    private PasswordField passwordPF;

    @FXML
    void LoginButtonPressed(ActionEvent event) {
        String username = usernameTF.getText();
        String password = passwordPF.getText();
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegister-Aprel11-7675", "root", "1234");

            Boolean b = chehkuser(c, username, password);
            if (b) {
                AlertsLabel.setText("Daxil oldunuz");
               ((Node)event.getSource()).getScene().getWindow().hide();
                loadWindow();
            } else {
                
                AlertsLabel.setText("Melumatlar sehvdir");
            }
            c.close();

        } catch (IllegalStateException ex) {

            AlertsLabel.setText("yer  sehvi");
            ex.printStackTrace();

        } catch (SQLException ex) {

            AlertsLabel.setText("Sql Sintaksis  sehvi");
            ex.printStackTrace();

        } catch (Exception ex1) {

            AlertsLabel.setText("JAva sehvi");

            ex1.printStackTrace();
        }

    }

    @FXML
    void CreateAccountButtonPressed(ActionEvent event) throws SQLException {
        String username = usernameTF.getText();
        String password = passwordPF.getText();
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegister-Aprel11-7675", "root", "1234");

            Boolean b = chehkuser(c, username, password);
            if (b) {
                AlertsLabel.setText("Artiq qeydiyyat olunub");

            } else {
                PreparedStatement ps = c.prepareStatement("insert into students  ( username, pasword) values (?,?);");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.executeUpdate();

                ps.close();
                AlertsLabel.setText("Ugurla Hesab Yaradildi");
            }

            c.close();

        } catch (SQLException ex) {

            AlertsLabel.setText("Sql Sintaksis  sehvi");
            ex.printStackTrace();

        } catch (Exception ex1) {

            AlertsLabel.setText("JAva sehvi");

        }

    }

    @FXML
    void DeleteAccountButtonPressed(ActionEvent event) {
        String username = usernameTF.getText();
        String password = passwordPF.getText();
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegister-Aprel11-7675", "root", "1234");

            Boolean b = chehkuser(c, username, password);
            if (b) {
                AlertsLabel.setText("Ugurla silindi");
                Statement stm = c.createStatement();
                stm.execute("Delete  from students WHERE username='" + username + "' and pasword='" + password + "';");
            } else {
                AlertsLabel.setText("Melumatlar sehvdir");
            }
            c.close();

        } catch (SQLException ex) {

            AlertsLabel.setText("Sql Sintaksis  sehvi");
            ex.printStackTrace();

        } catch (Exception ex1) {

            AlertsLabel.setText("JAva sehvi");

            ex1.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private boolean chehkuser(Connection c, String u, String p) throws Exception {
        Boolean b = false;
        Statement stm = c.createStatement();
        ResultSet rs = stm.executeQuery("select * from students WHERE username='" + u + "' and pasword='" + p + "';");
        if (rs.next()) {

            b = true;
        }
        stm.close();
        rs.close();
        return b;

    }
    
public void loadWindow() throws IOException{
    Stage ps=new Stage();
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
