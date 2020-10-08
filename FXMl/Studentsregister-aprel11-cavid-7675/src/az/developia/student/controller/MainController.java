package az.developia.student.controller;

import az.developia.student.DAO.StudentDAO;
import az.developia.student.db.DataManager;
import az.developia.student.model.ModelTable;
import az.developia.student.model.Student;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable {

    private DataManager dataManager = DataManager.getDataManager();
    private String username;

    public String getUsername() {
        return username;

    }

    void setUsername(String username) {
        this.username = username;

    }

    @FXML
    private TableView<ModelTable> studentsTable;
    @FXML
    private TableColumn<ModelTable, String> nameTC;
    @FXML
    private TextField deleteodin;
    @FXML
    private TextField searchtx;
    @FXML
    private Label alerts;
    @FXML
     TableColumn<ModelTable, String> surnameTC;

    @FXML
    private TableColumn<ModelTable, String> valnameTC;

    @FXML
    private TableColumn<ModelTable, String> adressTC;

    @FXML
    private TableColumn<ModelTable, String> dateTC;

    @FXML
    private TableColumn<ModelTable, String> userlnameTC;
    @FXML
    private TableColumn<ModelTable, String> idTC;

    @FXML
    private TableColumn<ModelTable, String> telefonn;

    @FXML
    private DatePicker birthday;

    @FXML
    private TextField vname;

    @FXML
    private TextField surname;

    @FXML
    private TextField telefon;

    @FXML
    private TextField name;
 @FXML
    private ComboBox combox;
    @FXML
    private TextField adress;

    private StudentDAO studentDAO = new StudentDAO();

    @FXML
    void qeydiyyatB(ActionEvent event) throws SQLException {
        LocalDate dt = birthday.getValue();
        Date dtw = Date.valueOf(dt);
        Student s = new Student();
        s.setName(name.getText());
        s.setUsername(username);
        s.setSurname(surname.getText());
        s.setBirthday(dtw);
        s.setAdres(adress.getText());
        s.setTelefon(telefon.getText());
        s.setVname(vname.getText());
        studentDAO.addStudent(s);
        show();
        alerts.setText("Qeydiyyat olundu");
    }
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @FXML

    void goster(ActionEvent event) throws SQLException {
        // String id,username,name,surname,date12,adress,phone,valname;

        Connection c = dataManager.getConnection();
        idTC.getColumns().clear();
        userlnameTC.getColumns().clear();
        nameTC.getColumns().clear();
        surnameTC.getColumns().clear();
        dateTC.getColumns().clear();
        adressTC.getColumns().clear();
        telefonn.getColumns().clear();
        valnameTC.getColumns().clear();
        studentsTable.getItems().clear();
        show();

        studentsTable.setItems(oblist);

        alerts.setText("Gosterildi");

    }

    @FXML
    void delete(ActionEvent event) throws SQLException {
        Connection c = dataManager.getConnection();
        idTC.getColumns().clear();
        userlnameTC.getColumns().clear();
        nameTC.getColumns().clear();
        surnameTC.getColumns().clear();
        dateTC.getColumns().clear();
        adressTC.getColumns().clear();
        telefonn.getColumns().clear();
        valnameTC.getColumns().clear();
        studentsTable.getItems().clear();
        Statement s = c.createStatement();
        s.execute("delete FROM  students where id>0 and username='" + getUsername() + "' ;");
        studentsTable.setItems(oblist);
        show();
        alerts.setText("Hamisi silindi");
    }

    @FXML
    void deleteodin(ActionEvent event) throws SQLException {
        Connection c = dataManager.getConnection();
        String str = deleteodin.getText();
        int strn = Integer.valueOf(str);
        Statement s = c.createStatement();
        s.execute("delete FROM  students where id=" + strn + ";");
        idTC.getColumns().remove(strn);
        userlnameTC.getColumns().remove(strn);
        nameTC.getColumns().remove(strn);
        surnameTC.getColumns().remove(strn);
        dateTC.getColumns().remove(strn);
        adressTC.getColumns().remove(strn);
        telefonn.getColumns().remove(strn);
        valnameTC.getColumns().remove(strn);
        studentsTable.getItems().remove(strn);
        studentsTable.setItems(oblist);
        show();
        alerts.setText("silindi");

    }
    String[] massiv = new String[8];
  
  int searchint;
    @FXML
    void searchbutton(ActionEvent event) throws SQLException {
       String str = searchtx.getText();
        Connection c = dataManager.getConnection();
        Statement s = c.createStatement();
        massiv[0] = "id";
        massiv[1] = "username";
        massiv[2] = "name";
        massiv[3] = "surname";
        massiv[4] = "date";
        massiv[5] = "adress";
        massiv[6] = "telefon";
        massiv[7] = "valideynadi";
       String combostr=combox.getSelectionModel().getSelectedItem().toString();
       for (int i = 0; massiv.length < 10; i++) {
            if (combostr==massiv[searchint]) {
                showsearch();
      break;
            }else{
                searchint++;
            }
        }
       
        System.out.println(String.valueOf(massiv));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
combox.getItems().add("id");
        combox.getItems().add("username");
         combox.getItems().add("name");
         combox.getItems().add("surname");
         combox.getItems().add("date");
        combox.getItems().add("adress");
        combox.getItems().add("telefon");
        combox.getItems().add("valideynadi");
    }

    private void show() throws SQLException {
        idTC.getColumns().clear();
        userlnameTC.getColumns().clear();
        nameTC.getColumns().clear();
        surnameTC.getColumns().clear();
        dateTC.getColumns().clear();
        adressTC.getColumns().clear();
        telefonn.getColumns().clear();
        valnameTC.getColumns().clear();
        studentsTable.getItems().clear();
        Connection c = dataManager.getConnection();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM  students where username='" + getUsername() + "' ");
        System.out.println(getUsername());

        while (rs.next()) {
            oblist.add(new ModelTable(rs.getString("id"), rs.getString("username"), rs.getString("name"), rs.getString("surname"), rs.getString("date"), rs.getString("adress"), rs.getString("telefon"), rs.getString("valideynadi")));

        }
        rs.close();
        alerts.setText("Sagirdler Gosterildi");

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        userlnameTC.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameTC.setCellValueFactory(new PropertyValueFactory<>("surname"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("TBdt"));
        adressTC.setCellValueFactory(new PropertyValueFactory<>("adress"));
        telefonn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        valnameTC.setCellValueFactory(new PropertyValueFactory<>("valname"));

        studentsTable.setItems(oblist);
    }
 private void showsearch() throws SQLException {
     String str = searchtx.getText();
        idTC.getColumns().clear();
        userlnameTC.getColumns().clear();
        nameTC.getColumns().clear();
        surnameTC.getColumns().clear();
        dateTC.getColumns().clear();
        adressTC.getColumns().clear();
        telefonn.getColumns().clear();
        valnameTC.getColumns().clear();
        studentsTable.getItems().clear();
        Connection c = dataManager.getConnection();
        ResultSet rs = c.createStatement().executeQuery("Select * from students WHERE "+massiv[searchint]+" LIKE '" + str + "%';");
        System.out.println(getUsername());

        while (rs.next()) {
            oblist.add(new ModelTable(rs.getString("id"), rs.getString("username"), rs.getString("name"), rs.getString("surname"), rs.getString("date"), rs.getString("adress"), rs.getString("telefon"), rs.getString("valideynadi")));

        }
        rs.close();
        alerts.setText("Sagirdler Gosterildi");

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        userlnameTC.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameTC.setCellValueFactory(new PropertyValueFactory<>("surname"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("TBdt"));
        adressTC.setCellValueFactory(new PropertyValueFactory<>("adress"));
        telefonn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        valnameTC.setCellValueFactory(new PropertyValueFactory<>("valname"));

        studentsTable.setItems(oblist);
    }
}
