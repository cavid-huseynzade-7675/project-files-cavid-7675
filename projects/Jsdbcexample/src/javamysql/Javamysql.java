import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Javamysql {

    
   public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprel11-database-7675", "root", "1234");
            Statement s=c.createStatement();
           
            Date dt=Date.valueOf("2005-06-15");
           //
           // s.execute("create table telebe (id int not null auto_increment,name varchar(45), surname varchar(45), birthday date, sector varchar(10), phone varchar(45), address varchar(45), primary key (id))");
           // bu kodu buraya commit eledim cunki herdefe table drop elemek lazimdi
           //
           s.execute("insert into telebe (name, surname, birthday, sector, phone, address ) values ('adil','soyad',null,'az',null,null);");
            s.execute("insert into telebe  (name, surname, birthday, sector, phone, address) values ('adil','soyad',null,'az',null,null);");
            s.execute("insert into telebe  (name, surname, birthday, sector, phone, address) values ('adil','Psoyad',null,'az',null,null);");
            PreparedStatement ps=c.prepareStatement("insert into telebe  (name, surname, birthday, sector, phone, address) values (?,?,?,?,?,?);");
            ps.setString(1, "ads");
            ps.setString(2, "soyad");
            ps.setDate(3,dt);
            ps.setString(4, "az");
             ps.setString(5, "050-054-12-12");
              ps.setString(6, "LOndon");
              ps.executeUpdate();
               PreparedStatement ps1=c.prepareStatement("insert into telebe  (name, surname, birthday, sector, phone, address) values (?,?,?,?,?,?);");
            ps1.setString(1, "ads");
            ps1.setString(2, "soyad");
            ps1.setDate(3,dt);
            ps1.setString(4, "az");
             ps1.setString(5, "050-054-12-12");
              ps1.setString(6, "LOndon");
              ps1.executeUpdate();
              
                PreparedStatement ps2=c.prepareStatement("insert into telebe  (name, surname, birthday, sector, phone, address) values (?,?,?,?,?,?);");
            ps2.setString(1, "ads");
            ps2.setString(2, "soyad");
            ps2.setDate(3,dt);
            ps2.setString(4, "az");
             ps2.setString(5, "050-054-12-12");
              ps2.setString(6, "LOndon");
              ps2.executeUpdate();
              
              s.execute("UPDATE telebe set name='updade',surname='soydate' Where id=3");
              s.execute("Delete FROM telebe Where id=3");
              ps2.close();
              ps1.close();
            ps.close();
          s.close();
            
            
            c.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    
}
}