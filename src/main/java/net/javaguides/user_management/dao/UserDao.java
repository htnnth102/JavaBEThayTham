package net.javaguides.user_management.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.user_management.model.Users;
public class UserDao {
    // select no condition
    // select with condition

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

    public UserDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    static UserDao ud = new UserDao("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "motconvit");

    private static final String INSERT_USER_SQL = "Insert into users(name, email, country) values (?,?,?)";
    private static final String UPDATE_USER_SQL = "Update users set name = ?, email =?, country = ? where id = ?";
    private static final String SELECT_USER_SQL = "select * from users";
    private static final String DELETE_USER_SQL = "delete from users where id = ?";
    private static final String SELECT_USER_ID_SQL = "select * from users where id = ?";
    public UserDao(){};
    public Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(ud.jdbcURL, ud.jdbcUsername, ud.jdbcPassword);
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public List<Users> SelectAllUsers() {
        List<Users> users = new ArrayList<>();

        try {
            Connection con = getConnection();
            PreparedStatement pr = con.prepareStatement(SELECT_USER_SQL);
            System.out.println(pr);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new Users(id, name, email, country));
            }
        }
        catch (SQLException e) {
            System.out.println("Exception happened");
        }

        return users;
    }

    public Users SelectUsersById(int _id) {
        Users u = null;
        try {
            Connection con = getConnection();
            PreparedStatement pr = con.prepareStatement(SELECT_USER_ID_SQL);
            pr.setInt(1, _id);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                u = new Users(_id, name, email, country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    public void InsertUser(Users u ) {
        try {
            Connection con = getConnection();
            PreparedStatement pr = con.prepareStatement(INSERT_USER_SQL);
            pr.setString(1, u.getName());
            pr.setString(2, u.getEmail());
            pr.setString(3, u.getCountry());pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Users> SelectAllUsersByCountry(String _country) {
        List<Users> users = new ArrayList<>();

        try {
            Connection con = getConnection();
            String sql = "Select * from users where country = ?";
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, _country);
            System.out.println(pr);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = _country;
                users.add(new Users(id, name, email, country));
            }
        }
        catch (SQLException e) {
            System.out.println("Exception happened");
        }

        return users;
    }

    public boolean DeleteUser(int id) {
        boolean rowDeleted = false;
        try {
            Connection con = getConnection();
            PreparedStatement pr = con.prepareStatement(DELETE_USER_SQL);
            pr.setInt(1, id);
            rowDeleted = pr.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    public void UpdateUser(Users u ) {
        try {
            Connection con = getConnection();
            PreparedStatement pr = con.prepareStatement(UPDATE_USER_SQL);
            pr.setString(1, u.getName());
            pr.setString(2, u.getEmail());
            pr.setString(3, u.getCountry());
            pr.setInt(4, u.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






}