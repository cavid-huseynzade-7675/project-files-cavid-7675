
package az.developia.product.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatManager {
    //burda mysqle connect eleyirik ki her defe tezden connect etmeyek lazim
    //olanda metod cagirsinlar
  private static final DatManager dataManager =new DatManager();
  private Connection connection;

    public static DatManager getDataManager() {
        return dataManager;
    }
  
  private DatManager(){
connect();
}

  
  
  private  void connect(){
      try {
        this.connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/a", "root", "1234");
          System.out.println("succes connection"); 
          
      
      } catch (Exception e) {
        
          
      }
  }
  
   public Connection getConnection() {
        return this.connection;
    }
}
