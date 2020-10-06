
package az.developia.student.DAO;

import az.developia.student.db.DataManager;
import az.developia.student.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class StudentDAO {
   private DataManager dataManager=DataManager.getDataManager();
   
   public void addStudent(Student student){
       try {
          Connection c=dataManager.getConnection();
     PreparedStatement ps1=c.prepareStatement("insert into students (username, name,surname, date, adress, telefon,valideynadi) values (?,?,?,?,?,?,?);");
       ps1.setString(1, student.getUsername());
            ps1.setString(2, student.getName());
            ps1.setString(3,student.getSurname());
            ps1.setDate(4, student.getBirthday());
             ps1.setString(5, student.getAdres());
              ps1.setString(6, student.getTelefon());
               ps1.setString(7, student.getVname());
              ps1.executeUpdate();      
              ps1.close();
       } catch (Exception e) {
       }
   
   }
}

