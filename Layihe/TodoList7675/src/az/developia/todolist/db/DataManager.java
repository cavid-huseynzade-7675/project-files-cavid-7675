/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.developia.todolist.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Cavid
 */
public class DataManager {
      private static final DataManager dataManager =new DataManager();
  private Connection connection;

    public static DataManager getDataManager() {
        return dataManager;
    }
  
  private DataManager(){
connect();
}

  
  
  private  void connect(){
      try {
        this.connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist-7675", "root", "1234");
          System.out.println("succes connection"); 
          
      
      } catch (Exception e) {
        
          
      }
  }
  
   public Connection getConnection() {
        return this.connection;
    }
}
