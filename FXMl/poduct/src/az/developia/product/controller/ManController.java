package az.developia.product.controller;

import az.developia.product.db.DatManager;
import az.developia.product.model.ModeTable;
import az.developia.product.model.Studen;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class ManController implements Initializable {
String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws SQLException {
        this.username = username;
        show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
          }
DatManager dataManager=DatManager.getDataManager();
     @FXML
    private TextField nameTX;
  @FXML
    private TextField searchTX;
    @FXML
    private TextField qiymaetTX;

    @FXML
    private TableColumn<String, ModeTable> nameTC;

    @FXML
    private TableColumn<String, ModeTable> qiymetTC;

    @FXML
    private TableView<ModeTable> productTable;

    @FXML
    private TableColumn<String, ModeTable> idTC;

    @FXML
    void deleteSagTik(ActionEvent event) throws SQLException {
        
             Connection c=dataManager.getConnection();
    
      ObservableList<ModeTable> selectedStudents=productTable.getSelectionModel().getSelectedItems();
        System.out.println(selectedStudents);
      Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select * from product where username='"+username+"';");
            while(rs.next()){
                Studen st=new Studen();
                System.out.println(rs.getInt("id"));
                st.setId(rs.getInt("id"));
      }
              for (int i = 0; i < selectedStudents.size(); i++) {
                 
                 deleteById(selectedStudents.get(i).getId());
            
    }
              show();
       
 
    }
     public void deleteById(String id) {
         try {
           
            // mysqle bazada id ye gore telebenin melematini silir
            Connection c=dataManager.getConnection();
            Statement s=c.createStatement();
            s.execute("delete from product where id="+id+"");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void qeydiyyat(ActionEvent event) throws SQLException {
    Connection c=dataManager.getConnection();
     PreparedStatement ps1=c.prepareStatement("insert into product ( username,name,salary ) values (?,?,?);");
     ps1.setString(1, username);
       ps1.setString(2, nameTX.getText());
            ps1.setString(3, qiymaetTX.getText());
          
          
              ps1.executeUpdate();      
              ps1.close();
      
        show();
    }
 @FXML
    void searchbutton(KeyEvent event) throws SQLException {
      
            System.out.println(searchTX.getText());
      showsearch();

    }

    @FXML
    void delete(ActionEvent event) throws SQLException  {
      
 Connection c = dataManager.getConnection();
        Statement s = c.createStatement();
        s.execute("delete FROM  product where id>0 and username='" + getUsername() + "' ;");
       productTable.setItems(oblist);
        show();
       
    }
ObservableList <ModeTable>oblist=FXCollections.observableArrayList();
    private void show() throws SQLException  {
        System.out.println(getUsername());
            productTable.getItems().clear();
        Connection c = dataManager.getConnection();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM  product where username='" + getUsername() + "' ");
     

        while (rs.next()) {
            oblist.add(new ModeTable(rs.getString("id"), rs.getString("name"),rs.getString("salary"),rs.getString("username")));

        }
        
        rs.close();
      

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
      qiymetTC.setCellValueFactory(new PropertyValueFactory<>("qiymet")); 
       productTable.setItems(oblist);
        
      
        }
   private void showsearch() throws SQLException {
      //burda database sorgu gonderirik ve cavablari ResultSete veririk 
        //while vasitesi ile  Observable liste modeltable vasitesile deyer veririk
        //sonra deyerleri Tableviewe qoyuruq
     String str = searchTX.getText();
       
        productTable.getItems().clear();
        Connection c = dataManager.getConnection();
        ResultSet rs = c.createStatement().executeQuery("select * from product where username='"+username+"' and concat(name,salary) like '%"+str+"%';");
     

         while (rs.next()) {
            oblist.add(new ModeTable(rs.getString("id"), rs.getString("name"),rs.getString("salary"),rs.getString("username")));

        }
        
        rs.close();
      

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
      qiymetTC.setCellValueFactory(new PropertyValueFactory<>("qiymet")); 
       productTable.setItems(oblist);
    }
            
   
}
