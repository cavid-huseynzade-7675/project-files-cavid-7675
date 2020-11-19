
package az.developia.todolist.controller;

import az.developia.todolist.DAO.TodoListDao;
import az.developia.todolist.db.DataManager;
import az.developia.todolist.model.Model;
import az.developia.todolist.util.UtilClass;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;


public class MainController implements Initializable {
    String username;
    DataManager dataManager=DataManager.getDataManager();
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        findKategoriya();
        try {
            show("SELECT * FROM  tasks where username='" + getUsername() + "' ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
@FXML
private ToggleGroup toggle=new  ToggleGroup();
   @FXML
    private RadioButton hellolmayanlarRadiobutton;

    @FXML
    private RadioButton hamisiRadiobutton;


    @FXML
    private RadioButton hellolanlarRadiobutton;
    @FXML
    private TextField tapsiriqTextField;

    @FXML
    private TableView<Model> tapsiriqTableView;

    @FXML
    private TableColumn<Model, Date> gunTC;

    @FXML
    private TextField searchTExtField;

    @FXML
    private DatePicker gunDatePicker1;

    @FXML
    private TableColumn<Model, Date> tarixTC;

    @FXML
    private TableColumn<Model, String> necegunqalibTC;

    @FXML
    private DatePicker tarixDatePicker;

    @FXML
    private TableColumn<Model, String> statusTC;

    @FXML
    private Label setirsayi;
@FXML
    private Label alerts;
    @FXML
    private TableColumn<Model, String> tapsiriqTC;

    @FXML
    private TableColumn< Model,Integer> idTC;

    @FXML
    private TableColumn<Model, String> kateqoriyaTC;

    @FXML
    private ComboBox<String> kategoriyaCombobox;
    
    @FXML
    private ComboBox<String> kategoriyaCombobox1;
 @FXML
    private ImageView setingimage;
long uzunluq;
  
    @FXML
    private ImageView searchimage;
      @FXML
    void uptade(ActionEvent event) {
  try{
 Stage s=new Stage();
  
                s.setTitle("Uptade");
             Model selected=tapsiriqTableView.getSelectionModel().getSelectedItem();
    FXMLLoader loader=new FXMLLoader(getClass().getResource("/az/developia/todolist/view/uptde.fxml"));
     Parent root=loader.load();
        Scene scene=new Scene(root);
       s.setScene(scene);
      UptdeController uptdeController=loader.getController();
     uptdeController.setUsername(username);
     uptdeController.setModel(selected);
       s.showAndWait();
       show("SELECT * FROM  tasks where username='" + getUsername() + "' ");
       alerts.setText("Secdiginiz tapsirigin melumatlari deyisdirildi");
       findKategoriya();
       show("SELECT * FROM  tasks where username='" + getUsername() + "' ");
        }catch(Exception ex){
            ex.printStackTrace();
    }
    }
  @FXML
    void filterkategoriya(ActionEvent event) throws SQLException {
      show("SELECT * FROM  tasks where username='" + getUsername() + "' and kateqoriya='"+kategoriyaCombobox1.getSelectionModel().getSelectedItem()+"'");
    }
    @FXML
    void deleteone(ActionEvent event) throws SQLException {
if(UtilClass.confirmDialog("Eminsiniz")){
    Model selected=tapsiriqTableView.getSelectionModel().getSelectedItem();
    Connection c=dataManager.getConnection();
    Statement s=c.createStatement();
    s.execute("delete FROM tasks where id="+selected.getId()+";");
    show("SELECT * FROM  tasks where username='" + getUsername() + "' ");
}
    }

    @FXML
    void statusdeyisdir(ActionEvent event) throws SQLException {
if(UtilClass.confirmDialog("Eminsiniz")){
    String hellolunub="Hell olunub";
    String hellolunmuyub="Hell olunmayib";
    Model selected=tapsiriqTableView.getSelectionModel().getSelectedItem();
    Connection c=dataManager.getConnection();
    Statement s=c.createStatement();
    if(hellolunub.equals(selected.getStatus())){
        s.execute("UPDATE `todolist-7675`.`tasks` SET `status`='"+hellolunmuyub+"' WHERE `id`='"+selected.getId()+"';");
   
    }
    if(hellolunmuyub.equals(selected.getStatus())){
      s.execute("UPDATE `todolist-7675`.`tasks` SET `status`='"+hellolunub+"' WHERE `id`='"+selected.getId()+"';");
  
    }
        
    show("SELECT * FROM  tasks where username='" + getUsername() + "' ");
}
    }
     @FXML
    void searchenter(KeyEvent event) throws SQLException {
 if(event.getCode().equals(KeyCode.ENTER)){
       show("select * from tasks where username='" + username + "' and concat(id,username,taskname,gun,date,kateqoriya,status) like '%" + searchTExtField.getText() + "%';");

    }
    }
    @FXML
    void kategoriyasettings(ActionEvent event) {
        try{
 Stage s=new Stage();
  
                s.setTitle("Tasks");
                 FileInputStream input=new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\Layihe\\TodoList7675\\image\\setting.png");
          Image image=new Image(input);
         
        Image[] elements = new Image[1];
        elements[0]=image;
          s.getIcons().setAll(elements);
    FXMLLoader loader=new FXMLLoader(getClass().getResource("/az/developia/todolist/view/kategoriyasettings.fxml"));
     Parent root=loader.load();
        Scene scene=new Scene(root);
       s.setScene(scene);
       KategoriyasettingsController kategoriyasettingsController=loader.getController();
       kategoriyasettingsController.setUsername(username);
       s.showAndWait();
       findKategoriya();
            show("SELECT * FROM  tasks where username='" + getUsername() + "' ");
        }catch(Exception ex){
            ex.printStackTrace();
    }
    }
    @FXML
    void saveButtton(ActionEvent event) throws SQLException {
        boolean allowsave =true;
        boolean save =true;
        String xeta="";
        Model m=new Model();
        if (tapsiriqTextField.getText().trim().length()<3) {
            allowsave=false;
          xeta+="Tapsirigi ";
                            
        }
       
        if (!allowsave){
        xeta+="tam yazin\n";
        }
        if (tarixDatePicker.getValue()==null) {
            allowsave=false;
            save=false;
          xeta+=" Ne vaxt qeyd etdiyinizi secin\n";
                            
        }
         if (gunDatePicker1.getValue()==null) {
            allowsave=false;
            save=false;
          xeta+="ne vaxt bitceyini secin\n";
                            
        }
        if (kategoriyaCombobox.getSelectionModel().getSelectedItem()==null) {
           allowsave=false;
          xeta+="Kategoriyani secin";
                            
    }
     
        if (save) {
          long uzunluq=ChronoUnit.DAYS.between(tarixDatePicker.getValue(),gunDatePicker1.getValue() );
         
        }
               if (uzunluq<0) {
             allowsave=false;
          xeta+="Tarixleri DogruSecin\n bitireceyiniz vaxt tapsirigi qoydugunuz\nvaxtdan evvel ola bilmez";
        }
         if (allowsave) {
            m.setTapsiriq(tapsiriqTextField.getText());
            m.setGun(Date.valueOf(gunDatePicker1.getValue()));
           m.setUsername(getUsername());
           m.setTarix(Date.valueOf(tarixDatePicker.getValue()));
          
            m.setKateqoriya((String) kategoriyaCombobox.getSelectionModel().getSelectedItem());
            m.setStatus("Hell olunmayib");
             TodoListDao dao=new TodoListDao();
             dao.addtask(m);
               Notifications.create().title("Melumat").position(Pos.BOTTOM_RIGHT).text("Tapsiriq qeydiyyat olundu").showInformation();
         alerts.setText("Tapsiriq qeydiyyat olundu");
         show("SELECT * FROM  tasks where username='" + getUsername() + "' ");
        }else{
             Notifications.create().title("Melumat").position(Pos.BOTTOM_RIGHT).text("Melumatlari tam yazin\n"+xeta).showInformation();
         alerts.setText("Melumatlari tam yazin");
         }
         
    }

    @FXML
    void deleteButton(ActionEvent event) throws SQLException {
        if(UtilClass.confirmDialog("Əminsiniz?")){
          Connection c = dataManager.getConnection();
        Statement s = c.createStatement();
        s.execute("delete FROM  tasks where id>0 and username='" + getUsername() + "' ;");
        
        show("SELECT * FROM  tasks where username='" + getUsername() + "' ");
         Notifications.create().position(Pos.BOTTOM_RIGHT).title("Məlumat").text("Butun tapsiriqlar silindi").showConfirm();
     alerts.setText("Butun tapsiriqlar silindi");
    }

    }

    @FXML
    void hellolanlarRadiobutton(ActionEvent event) throws SQLException {
         String hellolunub="Hell olunub";
    
        show("SELECT * FROM  tasks where username='" + getUsername() + "'and status='"+hellolunub+"' ");
    }

    @FXML
    void hamisiRadiobutton(ActionEvent event) throws SQLException {
        show("SELECT * FROM  tasks where username='" + getUsername() + "' ");
    }

    @FXML
    void hellolmayanlarRadiobutton(ActionEvent event) throws SQLException {
String hellolunmuyub="Hell olunmayib";
        show("SELECT * FROM  tasks where username='" + getUsername() + "'and status='"+hellolunmuyub+"' ");
    }

    @FXML
    void search(ActionEvent event) throws SQLException {
  show("select * from tasks where username='" + getUsername()+ "' and concat(id,username,taskname,gun,date,kateqoriya,status) like '%" + searchTExtField.getText() + "%';");

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
        hamisiRadiobutton.setToggleGroup(toggle);
        hellolanlarRadiobutton.setToggleGroup(toggle);
        hellolmayanlarRadiobutton.setToggleGroup(toggle);
         FileInputStream input2 = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\Layihe\\TodoList7675\\image\\search s.png");
          Image image2 = new Image(input2);
        searchimage.setImage(image2);
        FileInputStream input = new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\Layihe\\TodoList7675\\image\\setting.png");
          Image image = new Image(input);
        setingimage.setImage(image);
       
        }catch(Exception ex){
            
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
                if (e.getCharacter().matches("[0-9]")) {
                    if (text.getText().contains(".") && e.getCharacter().matches("[.]")&&e.getCharacter().matches("a-zA-Z")) {
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

  private void findKategoriya() {
           kategoriyaCombobox.getItems().clear();
           kategoriyaCombobox1.getItems().clear();
         Connection c = dataManager.getConnection();
        ArrayList<String> alist = new ArrayList<String>();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select kateqoriyaname from kateqoriyatable where username='" + username + "';");

            while (rs.next()) {
                alist.add(rs.getString("kateqoriyaname"));
            }
            kategoriyaCombobox.getItems().addAll(alist);
             kategoriyaCombobox1.getItems().addAll(alist);

        } catch (Exception ex) {
            ex.printStackTrace();
        } }
       ObservableList<Model> oblist = FXCollections.observableArrayList();

     private void show(String execute) throws SQLException {
        
        tapsiriqTableView.getItems().clear();
        Connection c = dataManager.getConnection();
        Statement s=c.createStatement();
        ResultSet result = s.executeQuery(execute);
        System.out.println(getUsername());

        while (result.next()) {
           Model mt=new Model();
            mt.setId(result.getInt("id"));
           mt.setUsername(result.getString("username"));
           mt.setTapsiriq(result.getString("taskname"));
           mt.setGun(result.getDate("gun"));
           mt.setTarix(result.getDate("date"));
           String da=String.valueOf(result.getDate("gun"));
            System.out.println(da);
           LocalDate tarix=LocalDate.parse(da);
             LocalDate gun=LocalDate.now();
             Long l=ChronoUnit.DAYS.between( gun,tarix);
             if (l<0) {
               mt.setNecegunqalib("Tapsirigin vaxti kecib"); 
            }else{
                mt.setNecegunqalib(String.valueOf(l)); 
           
             }
           
           mt.setKateqoriya(result.getString("kateqoriya"));
           mt.setStatus(result.getString("status"));
            System.out.println("s");
            oblist.add(mt);
        }
        result.close();
        s.close();
        idTC.setCellValueFactory(new  PropertyValueFactory<>("id"));
        tapsiriqTC.setCellValueFactory(new PropertyValueFactory<>("tapsiriq"));
        gunTC.setCellValueFactory(new PropertyValueFactory<>("gun"));
        tarixTC.setCellValueFactory(new PropertyValueFactory<>("tarix"));
        necegunqalibTC.setCellValueFactory(new PropertyValueFactory<>("necegunqalib"));
        kateqoriyaTC.setCellValueFactory(new PropertyValueFactory<>("kateqoriya"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        tapsiriqTableView.setItems(oblist);
        setirsayi.setText((String.valueOf(tapsiriqTableView.getItems().size())));
}}