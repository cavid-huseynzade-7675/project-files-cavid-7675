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

import az.developia.shopmanagement.model.UserModel;

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
 public void createUser(UserModel user){

  
        try {
            Connection c=dataSource.getConnection();
PreparedStatement st=c.prepareStatement("insert into users (username,password,enabled) values(?,?,?);");
PreparedStatement st1=c.prepareStatement("insert into authorities (username,authority) values(?,?);");
st.setString(1, user.getUsername());
st.setString(2, "{noop}"+user.getPassword());
st.setInt(3, 1);
st.executeUpdate();
st1.setString(1, user.getUsername());
st1.setString(2, "ROLE_ADMIN");
st.close();
st1.executeUpdate();
c.close();

        } catch (Exception e) {
           e.printStackTrace();
        }

 }
}
