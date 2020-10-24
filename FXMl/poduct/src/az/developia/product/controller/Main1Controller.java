package az.developia.product.controller;

import az.developia.product.db.DataManager;
import az.developia.product.model.ModelTable;
import az.developia.product.model.Student;
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

public class Main1Controller implements Initializable {
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
DataManager dataManager=DataManager.getDataManager();
     @FXML
    private TextField nameTX;

    @FXML
    private TextField qiymaetTX;

    @FXML
    private TableColumn<String, ModelTable> nameTC;

    @FXML
    private TableColumn<String, ModelTable> qiymetTC;

    @FXML
    private TableView<ModelTable> productTable;

    @FXML
    private TableColumn<String, ModelTable> idTC;

    @FXML
    void deleteSagTik(ActionEvent event) throws SQLException {
  Connection c=dataManager.getConnection();
    
      ObservableList<ModelTable> selectedStudents=productTable.getSelectionModel().getSelectedItems();
        System.out.println(selectedStudents);
      Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select * from students where username='"+username+"';");
            while(rs.next()){
                Student st=new Student();
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
            s.execute("delete from students where id="+id+"");
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
    void delete(ActionEvent event) throws SQLException {
 Connection c = dataManager.getConnection();
        Statement s = c.createStatement();
        s.execute("delete FROM  product where id>0 and username='" + getUsername() + "' ;");
       productTable.setItems(oblist);
        show();
    }
ObservableList <ModelTable>oblist=FXCollections.observableArrayList();
    private void show() throws SQLException {
         productTable.getItems().clear();
        Connection c = dataManager.getConnection();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM  product where username='" + getUsername() + "' ");
     

        while (rs.next()) {
            oblist.add( new ModelTable(rs.getString("id"), rs.getString("name"),rs.getString("salary")));

        }
        
        rs.close();
      

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        //qiymetTC.setCellFactory(new PropertyValueFactory<>("qiymet"));
      
        }
   
            
   
}
