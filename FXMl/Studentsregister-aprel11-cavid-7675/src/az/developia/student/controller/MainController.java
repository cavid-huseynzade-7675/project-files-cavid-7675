package az.developia.student.controller;

import az.developia.student.DAO.StudentDAO;
import az.developia.student.db.DataManager;
import az.developia.student.model.ModelTable;
import az.developia.student.model.Student;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

public class MainController implements Initializable {

    private DataManager dataManager = DataManager.getDataManager();
    private String username;

    public String getUsername() {
        return username;

    }

    void setUsername(String username) throws SQLException {
        this.username = username;
        show();
        findSectors();

    }
//burda dyerleri ve fxml kompenentlerini yazmisiq 
    @FXML
    private TableView<ModelTable> studentsTable;
    @FXML
    private TableColumn<ModelTable, String> nameTC;
    @FXML
    private TextField deleteodin;
    @FXML
    private TextField searchtx;
  
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
    private TableColumn<ModelTable, String> sectortb;

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
    private ComboBox comboxsector;

    @FXML
    private TextField adress;

    private StudentDAO studentDAO;

    @FXML
    void deletect(ActionEvent event)  {
        try{
        Connection c = dataManager.getConnection();

        ObservableList<ModelTable> selectedStudents = studentsTable.getSelectionModel().getSelectedItems();
        ModelTable select=studentsTable.getSelectionModel().getSelectedItem();
        System.out.println(selectedStudents);
        Statement s = c.createStatement();
        Statement as=c.createStatement();
        as.execute("delete FROM muqavile where studentid="+select.getId()+";");
        ResultSet rs = s.executeQuery("select * from students where username='" + username + "';");
        while (rs.next()) {
            Student st = new Student();
            System.out.println(rs.getInt("id"));
            st.setId(rs.getInt("id"));
        }
        for (int i = 0; i < selectedStudents.size(); i++) {

            deleteById(selectedStudents.get(i).getId());

        }
        show();
        Notifications.create().position(Pos.CENTER).title("Məlumat").text("Secdiginiz telebe silindi").showConfirm();
    }catch(Exception e){
        Notifications.create().position(Pos.CENTER).title("Məlumat").text("Secdiginiz telebe silinmedi").showError();
    }
    }
    public void deleteById(String id) {
        try {

            // mysqle bazada id ye gore telebenin melematini silir
            Connection c = dataManager.getConnection();
            Statement s = c.createStatement();
            s.execute("delete from students where id=" + id + "");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
@FXML
    void muqavileet(ActionEvent event) throws IOException  {
        Stage s = new Stage();

        s.setTitle("Muqavile et");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/az/developia/student/view/muqavileet.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        s.setScene(scene);
        MuqavileetController muqavileetController=loader.getController();
          ModelTable selectedstudnbt = studentsTable.getSelectionModel().getSelectedItem();
          int i=Integer.parseInt(selectedstudnbt.getId());
        muqavileetController.setStudentid(i);
        s.show();
    }
    
    @FXML
    void muqavilerigoster(ActionEvent event) throws IOException, SQLException  {
        Stage s = new Stage();

        s.setTitle("Muqavile goster");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/az/developia/student/view/muqavilegoster.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        s.setScene(scene);
        MuqavilegosterController muqavilegosterController=loader.getController();
          ModelTable selectedstudnbt = studentsTable.getSelectionModel().getSelectedItem();
          int i=Integer.parseInt(selectedstudnbt.getId());
        muqavilegosterController.setStudentid(i);
         s.show();
    }
    @FXML
    void update(ActionEvent event) throws SQLException, IOException {

        Stage s = new Stage();

        s.setTitle("Uptade");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/az/developia/student/view/uptade.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        s.setScene(scene);
       
        Connection c = dataManager.getConnection();
        UptadestudentController uptadestudentController = loader.getController();
       
        ModelTable selectedstudnbt = studentsTable.getSelectionModel().getSelectedItem();
         
      
            uptadestudentController.setId(selectedstudnbt.getId());
            uptadestudentController.setName(selectedstudnbt.getName());
            uptadestudentController.setDate(selectedstudnbt.getTBdt());
            uptadestudentController.setAdres(selectedstudnbt.getAdress());
            uptadestudentController.setSurname(selectedstudnbt.getSurname());
            uptadestudentController.setTelefon(selectedstudnbt.getPhone());
            uptadestudentController.setSector(selectedstudnbt.getSector1());
            uptadestudentController.setValideynadi(selectedstudnbt.getValname());
            uptadestudentController.setUsername(username);
           
 s.showAndWait();

      show();

    }

    public void findSectors() {
        comboxsector.getItems().clear();
        Connection c = dataManager.getConnection();
        ArrayList<String> alist = new ArrayList<String>();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select sector from sectors where username='" + username + "';");

            while (rs.next()) {
                alist.add(rs.getString("sector"));
            }
            comboxsector.getItems().addAll(alist);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        adress.addEventHandler(KeyEvent.KEY_TYPED, allowOnlyDecimalsOrLetters(10));
        surname.addEventHandler(KeyEvent.KEY_TYPED, allowOnlyDecimalsOrLetters(10));
        name.addEventHandler(KeyEvent.KEY_TYPED, allowOnlyDecimalsOrLetters(10));
        telefon.addEventHandler(KeyEvent.KEY_TYPED, allowOnlyDecimalsOrLetters(10));
        vname.addEventHandler(KeyEvent.KEY_TYPED, allowOnlyDecimalsOrLetters(10));
        searchtx.addEventHandler(KeyEvent.KEY_TYPED, allowOnlyDecimalsOrLetters(10));

    }

    @FXML
    void qeydiyyatB(ActionEvent event) throws SQLException {
        //burda aldigimiz melumatlari student sinifine gonderrik
        //ve sonra student sinifindendeki deyerler student dao
        //sinifinden addstudent metodu cagirilir ve database eleva olunur 
        ////sonra show metodu ile yene table view melumat gonderilir
        LocalDate dt = birthday.getValue();
        Date dtw = Date.valueOf(dt);
        Connection c = dataManager.getConnection();
        PreparedStatement ps1 = c.prepareStatement("insert into students (username, name,surname, date, adress, telefon,valideynadi,sector) values (?,?,?,?,?,?,?,?);");
        ps1.setString(1, username);
        ps1.setString(2, name.getText());
        ps1.setString(3, surname.getText());
        ps1.setDate(4, dtw);
        ps1.setString(5, adress.getText());
        ps1.setString(6, telefon.getText());
        ps1.setString(7, vname.getText());
        ps1.setString(8, (String) comboxsector.getSelectionModel().getSelectedItem());
        ps1.executeUpdate();
        ps1.close();

        show();
         Notifications.create().position(Pos.CENTER).title("Məlumat").text("Tələbə qeydiyyat olundu").showConfirm();

    
    }
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @FXML
    void delete(ActionEvent event) throws SQLException {
        //duymeye basanda databasedeki bu username aid olan butun telebeler silinir
        //sonra show metodu ile yene table view melumat gonderilir melumat olmadigi
        //ucun table view de hecne olmur
        Connection c = dataManager.getConnection();
        Statement s = c.createStatement();
        s.execute("delete FROM  students where id>0 and username='" + getUsername() + "' ;");
        studentsTable.setItems(oblist);
        show();
         Notifications.create().position(Pos.CENTER).title("Məlumat").text("Butun telebeler silindi").showConfirm();
     
    }

    @FXML
    void addSector(ActionEvent event) throws IOException {
        //duymeye basnda  mysqle sectorlarin saxlanildigi table a addsector metodu ile setor elave edirik
        Stage s = new Stage();

        s.setTitle("Sektor Ayarlari");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/az/developia/student/view/sektorayarlar.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        s.setScene(scene);

        SektorayarlarController sektorayarlarController = loader.getController();

        sektorayarlarController.setUsername(username);

        s.showAndWait();
        findSectors();
    }
    @FXML

    String[] massiv = new String[9];

    int searchint;

    @FXML
    void searchbutton(KeyEvent event) throws SQLException {

        System.out.println(searchtx.getText());
        showsearch();

    }

    private void show() throws SQLException {
        //burda database sorgu gonderirik ve cavablari ResultSete veririk 
        //while vasitesi ile  Observable liste modeltable vasitesile deyer veririk
        //sonra deyerleri Tableviewe qoyuruq
        studentsTable.getItems().clear();
        Connection c = dataManager.getConnection();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM  students where username='" + getUsername() + "' ");
        System.out.println(getUsername());

        while (rs.next()) {
            oblist.add(new ModelTable(rs.getString("id"), rs.getString("username"), rs.getString("name"), rs.getString("surname"), rs.getString("date"), rs.getString("adress"), rs.getString("telefon"), rs.getString("valideynadi"), rs.getString("sector")));

        }

        rs.close();
     

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        userlnameTC.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameTC.setCellValueFactory(new PropertyValueFactory<>("surname"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("TBdt"));
        adressTC.setCellValueFactory(new PropertyValueFactory<>("adress"));
        telefonn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        valnameTC.setCellValueFactory(new PropertyValueFactory<>("valname"));
        sectortb.setCellValueFactory(new PropertyValueFactory<>("sector1"));
        studentsTable.setItems(oblist);
    }

    private void showsearch() throws SQLException {
        //burda database sorgu gonderirik ve cavablari ResultSete veririk 
        //while vasitesi ile  Observable liste modeltable vasitesile deyer veririk
        //sonra deyerleri Tableviewe qoyuruq
        String str = searchtx.getText();

        studentsTable.getItems().clear();
        Connection c = dataManager.getConnection();
        ResultSet rs = c.createStatement().executeQuery("select * from students where username='" + username + "' and concat(username,name,surname,date,adress,telefon,valideynadi,sector) like '%" + str + "%';");

        while (rs.next()) {
            oblist.add(new ModelTable(rs.getString("id"), rs.getString("username"), rs.getString("name"), rs.getString("surname"), rs.getString("date"), rs.getString("adress"), rs.getString("telefon"), rs.getString("valideynadi"), rs.getString("sector")));

        }
        rs.close();
       

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        userlnameTC.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameTC.setCellValueFactory(new PropertyValueFactory<>("surname"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("TBdt"));
        adressTC.setCellValueFactory(new PropertyValueFactory<>("adress"));
        telefonn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        valnameTC.setCellValueFactory(new PropertyValueFactory<>("valname"));
        sectortb.setCellValueFactory(new PropertyValueFactory<>("sector1"));
        studentsTable.setItems(oblist);
    }

    public static EventHandler<KeyEvent> allowOnlyDecimalsOrLetters(final Integer maxLength) {
        // burda textfiellde limit qoyacayiq
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField text = (TextField) e.getSource();
                if (text.getText().length() >= maxLength) {
                    e.consume();
                }
                if (e.getCharacter().matches("[0-9.a-zA-Z]")) {
                    if (text.getText().contains(".") && e.getCharacter().matches("[.]")) {
                        e.consume();
                    } else if (text.getText().length() == 0 && e.getCharacter().matches("[.]")) {
                        e.consume();
                    }
                } else {
                    e.consume();
                }
            }
        };
    }
}
