
package az.developia.todolist.DAO;

import az.developia.todolist.db.DataManager;
import az.developia.todolist.model.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TodoListDao {
    DataManager dataManager=DataManager.getDataManager();
   public void addtask(Model tasks){
        try {
            Connection c=dataManager.getConnection();
           PreparedStatement s=c.prepareStatement("insert into tasks (username,taskname,gun,date,kateqoriya,status) values (?,?,?,?,?,?)");
            s.setString(1,tasks.getUsername());
            s.setString(2, tasks.getTapsiriq());
            s.setDate(3, tasks.getGun());
            s.setDate(4, tasks.getTarix());
            s.setString(5, tasks.getKateqoriya());
            s.setString(6, tasks.getStatus());
            s.executeUpdate();
               s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
}
