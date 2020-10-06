package az.developia.student.controller;

import az.developia.student.DAO.StudentDAO;
import az.developia.student.db.DataManager;
import az.developia.student.model.ModelTable;
import az.developia.student.model.Student;
import java.net.URL;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable {

    private DataManager dataManager = DataManager.getDataManager();
    private String username;
int say=-1;
    public String getUsername() {
        return username;
       
    }


 void setUsername(String username) {
     this.username=username;
 
         }
  
@FXML
    private TableView<ModelTable> studentsTable;
    @FXML
    private TableColumn<ModelTable, String> nameTC;
     @FXML
    private TextField deleteodin;

    @FXML
    private TableColumn<ModelTable, String> surnameTC;

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
    private TextField adress;

    private StudentDAO studentDAO = new StudentDAO();

   int sa=3;
  
    @FXML
    void qeydiyyatB(ActionEvent event) throws SQLException {
          LocalDate dt=birthday.getValue();
    Date dtw=Date.valueOf(dt);
        Student s = new Student();
        s.setName(name.getText());
        s.setUsername(username);
        s.setSurname(surname.getText());
        s.setBirthday(dtw);
        s.setAdres(adress.getText());
        s.setTelefon(telefon.getText());
        s.setVname(vname.getText());
        studentDAO.addStudent(s);

    }
    ObservableList<ModelTable> oblist=FXCollections.observableArrayList();
    @FXML
            
     void goster(ActionEvent event) throws SQLException {
      // String id,username,name,surname,date12,adress,phone,valname;
     
try {
     Connection c=dataManager.getConnection();
     idTC.getColumns().clear();
userlnameTC.getColumns().clear();
nameTC.getColumns().clear();
surnameTC.getColumns().clear();
dateTC.getColumns().clear();
adressTC.getColumns().clear();
telefonn.getColumns().clear();
valnameTC.getColumns().clear();
studentsTable.getItems().clear();
     ResultSet rs=c.createStatement().executeQuery("SELECT * FROM  students where username='"+getUsername()+"' ");
    System.out.println(getUsername());
    
     while (rs.next()) {
          oblist.add(new ModelTable(rs.getString("id"), rs.getString("username"), rs.getString("name"), rs.getString("surname"), rs.getString("date"), rs.getString("adress"), rs.getString("telefon"), rs.getString("valideynadi")));
        say++;
    }
        } catch (Exception e) {
        }

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
     
      @FXML
    void delete(ActionEvent event) throws SQLException {
Connection c=dataManager.getConnection();
 idTC.getColumns().clear();
userlnameTC.getColumns().clear();
nameTC.getColumns().clear();
surnameTC.getColumns().clear();
dateTC.getColumns().clear();
adressTC.getColumns().clear();
telefonn.getColumns().clear();
valnameTC.getColumns().clear();
studentsTable.getItems().clear();
    Statement s=c.createStatement();
     s.execute("delete FROM  students where id>0 and username='"+getUsername()+"' ;");
     studentsTable.setItems(oblist);
    }

  

    
      @FXML
    void deleteodin(ActionEvent event) throws SQLException {
Connection c=dataManager.getConnection();
String str=deleteodin.getText();
int strn=Integer.valueOf(str);
 Statement s=c.createStatement();
     s.execute("delete FROM  students where id="+strn+";");
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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {


}

   
}