package az.developia.student.controller;

import az.developia.student.db.DataManager;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

public class MuqavileetController implements Initializable {

    int studentid;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
    DataManager dataManager = DataManager.getDataManager();
    @FXML
    private DatePicker muqavileend;

    @FXML
    private DatePicker muqavilestart;

    @FXML
    private TextField muqavileprice;

    @FXML
    private TextField muqavilename;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void muqavileet(ActionEvent event) throws SQLException {
        Connection c = dataManager.getConnection();
  PreparedStatement ps=c.prepareStatement("insert into muqavile  (studentid,opendate,price,lenght,muqavileadi) values (?,?,?,?,?);");
  ps.setInt(1, getStudentid());
  ps.setDate(2, Date.valueOf(muqavilestart.getValue()));
  ps.setDouble(3,Double.valueOf(muqavileprice.getText()) );
  ps.setDate(4, Date.valueOf(muqavileend.getValue()));
  ps.setString(5, muqavilename.getText());
  ps.executeUpdate();
  ps.close();
   Notifications.create().position(Pos.CENTER).title("Məlumat").text("Muqavile "+getStudentid()+" IDsine qeydiyyat olundu").showConfirm();
    }

}
