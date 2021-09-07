package az.developia.shopmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
 @Autowired
 private DataSource dataSource;
 
 public List<String> getUserRoles(String username){

    List<String> roles=new ArrayList<String>();
        try {
            Connection c=dataSource.getConnection();
PreparedStatement st=c.prepareStatement("select authority from authorities where username='"+username+"'");
ResultSet rs=st.executeQuery();

while (rs.next()) {
    roles.add(rs.getString(1));
}

rs.close();
st.close();
c.close();

        } catch (Exception e) {
           e.printStackTrace();
        }

        return roles;
 }

}
