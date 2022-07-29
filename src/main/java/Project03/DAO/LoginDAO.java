package Project03.DAO;

import Project03.Model.Login;
import Project03.ultils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public boolean checkLogin(Login u) {
        boolean check = false;
//
        String SELECT_SQL = "Select id, username from users where username =? and password = ?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(SELECT_SQL);
            pr.setString(1, u.getUsername());
            pr.setString(2, u.getPassword());
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }
}
