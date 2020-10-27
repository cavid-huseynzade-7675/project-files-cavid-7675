
package az.developia.student.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataManager {
    //burda mysqle connect eleyirik ki her defe tezden connect etmeyek lazim
    //olanda metod cagirsinlar
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
        this.connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregister-aprel11-7675", "root", "1234");
          System.out.println("succes connection"); 
          
      
      } catch (Exception e) {
        
          
      }
  }
  
   public Connection getConnection() {
        return this.connection;
    }
}
