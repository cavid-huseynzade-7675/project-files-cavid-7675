package az.developia.compshopcavidhuseynzade.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import az.developia.compshopcavidhuseynzade.model.UserModel;

@Component
public class UserDao {
    
    @Autowired
    private DataSource dataSource;

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public boolean createUser(UserModel user){
        boolean userExists=false;
        try {
            
Connection conn= dataSource.getConnection();
PreparedStatement ps=conn.
prepareStatement("select username from users where username=?");
ps.setString(1, user.getUsername());
ResultSet rs=ps.executeQuery();
if (rs.next()) {
    userExists=true;
    rs.close();
    ps.close();
} else {
    
    ps=conn.prepareStatement("insert into users (username,password,enabled,email,phone,nameandsurname) values(?,?,?,?,?,?);");
    ps.setString(1, user.getUsername());
    ps.setString(2, "{bcrypt}"+passwordEncoder.encode(user.getPassword()));
    ps.setInt(3, (byte)1);
    ps.setString(4, user.getEmail());
    ps.setString(5, user.getPhone());
    ps.setString(6, user.getNameandsurname());
    ps.executeUpdate();
    ps.close();

    ps=conn.prepareStatement("insert into authorities (username,authority) values(?,?);");
    ps.setString(1, user.getUsername());
    ps.setString(2, "ROLE_ADMIN");

    ps.executeUpdate();
    ps.close();

}
rs.close();
conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userExists;
    }
}

 