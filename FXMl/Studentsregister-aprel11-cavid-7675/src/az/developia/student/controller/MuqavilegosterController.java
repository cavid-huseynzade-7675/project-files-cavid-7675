
package az.developia.student.controller;

import az.developia.student.db.DataManager;
import az.developia.student.model.ModelMuvaqile;
import az.developia.student.model.ModelTable;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;


public class MuqavilegosterController implements Initializable {
 int studentid;
    DataManager dataManager=DataManager.getDataManager();
    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) throws SQLException {
        this.studentid = studentid;
        show();
        showStudent();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    @FXML
    private TableView<ModelTable> studentsTable;
    @FXML
    private TableColumn<ModelTable, String> nameTC;
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
    private TableColumn<ModelTable, String> idTC1;

    @FXML
    private TableColumn<ModelTable, String> telefonn;
    @FXML
    private TableColumn<ModelTable, String> sectortb;
    //ayrima
    @FXML
    private TableColumn<Date, ModelMuvaqile> muqavileendTC;

    @FXML
    private TableColumn<Double, ModelMuvaqile> muqavilepriceTC;

    @FXML
    private TableColumn<Date, ModelMuvaqile> muqavilestartTC;

    @FXML
    private TableView<ModelMuvaqile> muqaviletable;

    @FXML
    private TableColumn<String, ModelMuvaqile> muqavileadiTC;
  @FXML
    private TableColumn<Integer, ModelMuvaqile> STudentTC;
  @FXML
    private TableColumn<Integer, ModelMuvaqile> idTC;
     @FXML
    void deleteMI(ActionEvent event) throws SQLException {
Connection c=dataManager.getConnection();
ModelMuvaqile select=muqaviletable.getSelectionModel().getSelectedItem();
Statement s=c.createStatement();
s.execute("delete from  muqavile  where id="+select.getId()+";");
show();
 Notifications.create().position(Pos.CENTER).title("Məlumat").text("Muqavile silindi").showConfirm();
   
    }
    ObservableList<ModelMuvaqile> oblist=FXCollections.observableArrayList();
 private void show() throws SQLException {
        //burda database sorgu gonderirik ve cavablari ResultSete veririk 
        //while vasitesi ile  Observable liste modeltable vasitesile deyer veririk
        //sonra deyerleri Tableviewe qoyuruq
        muqaviletable.getItems().clear();
        Connection c = dataManager.getConnection();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM  muqavile where studentid='" + getStudentid() + "' ");
        

        while (rs.next()) {
            oblist.add(new ModelMuvaqile(rs.getInt("id"), rs.getInt("studentid"), rs.getDouble("price"), rs.getDate("opendate"),rs.getDate("lenght"),rs.getString("muqavileadi")));

        }

        rs.close();
     
           idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
           STudentTC.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        muqavileadiTC.setCellValueFactory(new PropertyValueFactory<>("name"));
       muqavilestartTC.setCellValueFactory(new PropertyValueFactory<>("start"));
        muqavileendTC.setCellValueFactory(new PropertyValueFactory<>("end"));
        muqavilepriceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
       
        muqaviletable.setItems(oblist);
    }
  ObservableList<ModelTable> oblist1=FXCollections.observableArrayList();
 private void showStudent() throws SQLException {
        //burda database sorgu gonderirik ve cavablari ResultSete veririk 
        //while vasitesi ile  Observable liste modeltable vasitesile deyer veririk
        //sonra deyerleri Tableviewe qoyuruq
        studentsTable.getItems().clear();
        Connection c = dataManager.getConnection();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM  students where id='" + getStudentid()+ "' ");
       
        while (rs.next()) {
            oblist1.add(new ModelTable(rs.getString("id"), rs.getString("username"), rs.getString("name"), rs.getString("surname"), rs.getString("date"), rs.getString("adress"), rs.getString("telefon"), rs.getString("valideynadi"), rs.getString("sector")));

        }

        rs.close();
     

        idTC1.setCellValueFactory(new PropertyValueFactory<>("id"));
        userlnameTC.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameTC.setCellValueFactory(new PropertyValueFactory<>("surname"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("TBdt"));
        adressTC.setCellValueFactory(new PropertyValueFactory<>("adress"));
        telefonn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        valnameTC.setCellValueFactory(new PropertyValueFactory<>("valname"));
        sectortb.setCellValueFactory(new PropertyValueFactory<>("sector1"));
        studentsTable.setItems(oblist1);
    }
}



