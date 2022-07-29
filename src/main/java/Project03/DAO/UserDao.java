package Project03.DAO;

import Project03.Model.Users;
import Project03.ultils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
     public int registerUser(Users u) {
          int rs = 0;
          String INSERT_SQL = "Insert into users values=(?, ?, ?, ?)";
          try {
               Connection con = DBConnection.getConnection();
               PreparedStatement pr = con.prepareStatement(INSERT_SQL);
               pr.setString(1, u.getFirst_name());
               pr.setString(2, u.getLast_name());
               pr.setString(3, u.getUsername());
               pr.setString(4, u.getPassword());
               rs = pr.executeUpdate();
          } catch (SQLException e) {
               throw new RuntimeException(e);
          }
          return rs;
     }

}
