
package az.developia.product.DAO;

import az.developia.product.db.DataManager;
import az.developia.product.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class StudentDAO {
   private DataManager dataManager=DataManager.getDataManager();
   
   public void addStudent(Student student){
       try {
           //burda telebelerinin melumatlarini mysqla yaziriq
          Connection c=dataManager.getConnection();
     PreparedStatement ps1=c.prepareStatement("insert into students (username, name,surname, date, adress, telefon,valideynadi,sector) values (?,?,?,?,?,?,?,?);");
       ps1.setString(1, student.getUsername());
            ps1.setString(2, student.getName());
            ps1.setString(3,student.getSurname());
            ps1.setDate(4, student.getBirthday());
             ps1.setString(5, student.getAdres());
              ps1.setString(6, student.getTelefon());
               ps1.setString(7, student.getVname());
                ps1.setString(8, student.getSector2());
              ps1.executeUpdate();      
              ps1.close();
       } catch (Exception e) {
       }
   
   }

    public void deleteSector(String selectedSector,String username) {
        //mysqle sectorlarin saxlanildigi tablede secdigimiz sectoru silir 
          try {
            Connection c=dataManager.getConnection();
            Statement s=c.createStatement();
            s.execute("delete from sectors where sector='"+selectedSector+"' and username='"+username+"'  ;");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       }

    public void addSector(String sector,String username) {
          try {
              //mysqle sectorlarin saxlanildigi table a sector elave edirik
            Connection c=dataManager.getConnection();
            Statement s=c.createStatement();
            s.execute("insert into sectors (sector,username) values ('"+sector+"','"+username+"');");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public ArrayList<String> findAllSectorsByUsername(String username) {
        // telebeleri username gore filt eleyir
        ArrayList<String> list=new ArrayList<String>();
        try {
            Connection c=dataManager.getConnection();
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select * from sectors where username='"+username+"';");
            while(rs.next()){ 
                list.add(rs.getString("sector"));
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
       }
}

