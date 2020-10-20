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
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

public class MainController implements Initializable {

    private DataManager dataManager = DataManager.getDataManager();
    private String username;

    public String getUsername() {
        return username;

    }

    void setUsername(String username) {
        this.username = username;

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

    private StudentDAO studentDAO = new StudentDAO();
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        //burda combobox deyer elave edirik
combox.getItems().add("id");
        combox.getItems().add("username");
         combox.getItems().add("name");
         combox.getItems().add("surname");
         combox.getItems().add("date");
        combox.getItems().add("adress");
        combox.getItems().add("telefon");
        combox.getItems().add("valideynadi");
        combox.getItems().add("sector");
        adress.addEventHandler(KeyEvent.KEY_TYPED,  allowOnlyDecimalsOrLetters(10));
        surname.addEventHandler(KeyEvent.KEY_TYPED,  allowOnlyDecimalsOrLetters(10));
        name.addEventHandler(KeyEvent.KEY_TYPED,  allowOnlyDecimalsOrLetters(10));
        telefon.addEventHandler(KeyEvent.KEY_TYPED,  allowOnlyDecimalsOrLetters(10));
        vname.addEventHandler(KeyEvent.KEY_TYPED,  allowOnlyDecimalsOrLetters(10));
        searchtx.addEventHandler(KeyEvent.KEY_TYPED,  allowOnlyDecimalsOrLetters(10));
        refreshSectors();
    }
    @FXML
    void qeydiyyatB(ActionEvent event) throws SQLException {
        //burda aldigimiz melumatlari student sinifine gonderrik
        //ve sonra student sinifindendeki deyerler student dao
        //sinifinden addstudent metodu cagirilir ve database eleva olunur 
        ////sonra show metodu ile yene table view melumat gonderilir
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
        s.setSector2((String) comboxsector.getSelectionModel().getSelectedItem());
        studentDAO.addStudent(s);
        show();
         
      
        alerts.setText("Qeydiyyat olundu");
    }
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @FXML

    void goster(ActionEvent event) throws SQLException {
        // show metodu ile  table viewe melumat gonderilir
        Connection c = dataManager.getConnection();
        studentsTable.getItems().clear();
        show();
        studentsTable.setItems(oblist);
}

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
        alerts.setText("Hamisi silindi");
    }

    @FXML
    void deleteodin(ActionEvent event) throws SQLException {
       //duymeye basanda databasedeki bu username ve idye sahib olan  olan telebe silinir 
       ////sonra show metodu ile yene table view melumat gonderilir
        Connection c = dataManager.getConnection();
        String str = deleteodin.getText();
        int strn = Integer.valueOf(str);
        Statement s = c.createStatement();
        s.execute("delete FROM  students where id=" + strn + ";");
      ModelTable sa=studentsTable.getSelectionModel().getSelectedItem();
        System.out.println(sa);
        studentsTable.setItems(oblist);
        show();
        alerts.setText("silindi");

    }
     @FXML
    void addSector(ActionEvent event) {
        //duymeye basnda  mysqle sectorlarin saxlanildigi table a addsector metodu ile setor elave edirik
          
        String newSector=JOptionPane.showInputDialog("Yeni sektorun adini daxil edin");
         if (newSector==null) {
             
         }else{
          studentDAO.addSector(newSector,username);
        refreshSectors();
         
         }
         System.out.println(newSector);
        }
    
    
    @FXML
    void deleteSector(ActionEvent event) {
       //duymeye basnda  mysqle sectorlarin saxlanildigi tablede secdigimiz 
       //deleteSector metodu ile secdigimizsectoru silir 
        String selectedSector=(String) comboxsector.getSelectionModel().getSelectedItem();
         studentDAO.deleteSector(selectedSector,username);
           refreshSectors();
        
    }
    String[] massiv = new String[9];
  
  int searchint;
    @FXML
    void searchbutton(ActionEvent event) throws SQLException {
        //burda yoxluyuq ki hamsi combobox secilib
        //sonra show search metodu vasitesil ile table view melumatgonderilir
        searchint=0;
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
        massiv[8] = "sector";
       String combostr=combox.getSelectionModel().getSelectedItem().toString();
       for (int i = 0; massiv.length < 10; i++) {
    if (combostr == null ? massiv[searchint] == null : combostr.equals(massiv[searchint])) {
                showsearch();
      break;
            }else{
                searchint++;
            }
        }
       
        System.out.println(String.valueOf(massiv));

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
            oblist.add( new ModelTable(rs.getString("id"), rs.getString("username"), rs.getString("name"), rs.getString("surname"), rs.getString("date"), rs.getString("adress"), rs.getString("telefon"), rs.getString("valideynadi"),rs.getString("sector")));

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
        ResultSet rs = c.createStatement().executeQuery("Select * from students WHERE username='"+getUsername()+"'and "+massiv[searchint]+" LIKE '" + str + "%';");
     

        while (rs.next()) {
            oblist.add(new ModelTable(rs.getString("id"), rs.getString("username"), rs.getString("name"), rs.getString("surname"), rs.getString("date"), rs.getString("adress"), rs.getString("telefon"), rs.getString("valideynadi"),rs.getString("sector")));

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
 sectortb.setCellValueFactory(new PropertyValueFactory<>("sector1"));
        studentsTable.setItems(oblist);
    }

    private void refreshSectors() {
        //burda eger Comboboxa nese elave olunnanda yada silinende
        //combobox deyerler silinir ve yeniden database den gelir 
        //bu ele suretli olur ki gorsenmir
         comboxsector.getItems().clear();
        comboxsector.getItems().addAll(studentDAO.findAllSectorsByUsername(username));
        if(comboxsector.getItems().size()>0){
             comboxsector.getSelectionModel().select(0);
        }
   
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
                if (e.getCharacter().matches("[0-9.a-zA-Z]") ) {
                    if (text.getText().contains(".") && e.getCharacter().matches("[.]")  ) {
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
