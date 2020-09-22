
package jsdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Jsdbcexample {

    
   public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel11-database-7675", "root", "1234");
            Statement s = c.createStatement();

           
            s.execute("create table sectors (id int not null auto_increment,product_count int,address varchar(30),price int, primary key (id))");
            s.execute("insert into sectors (price,address ,product_count ) values (1500,'London',12);");
            s.execute("insert into sectors (price,address ,product_count) values (1500,'Paris',45);");
            s.execute("insert into sectors (price,address ,product_count) values (1250,'baku',15);");
            s.execute("insert into sectors (price,address ,product_count) values (1250,'NEW YORK',47);");
            s.execute("insert into sectors (price,address ,product_count) values (578,'IStanbul',51);");
            s.close();
          
            
            
            c.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    
}
}