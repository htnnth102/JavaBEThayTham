package Project03.DAO;

import Project03.Model.Todo;
import Project03.ultils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoDao implements ToDoDaoInf{

    @Override
    public void insertToDo(Todo td) {
        String INSERT_SQL = "Insert into todos values=(?, ?, ?, ?, ?)";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(INSERT_SQL);
            pr.setString(1, td.getTitle());
            pr.setString(2, td.getDescription());
            pr.setDate(3, (Date) td.getTarget_date());
            pr.setInt(4, td.getUsername());
            pr.setBoolean(5, td.isIs_done());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Todo selectToDo(int id) {
        String SELECT_SQL_ID = "select * from todos where id = ?";
        Todo td = null;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(SELECT_SQL_ID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                int username = rs.getInt("usename");
                Date target_date  =  rs.getDate("target_date");
                Boolean is_done =rs.getBoolean("is_done");
                td = new Todo(title, description, target_date,username,  is_done);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return td;
    }

    @Override
    public List<Todo> selectToDoList() {
        String SELECT_SQL_ID = "select * from todos";
        List<Todo> tdList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(SELECT_SQL_ID);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int username = rs.getInt("usename");
                Date target_date  =  rs.getDate("target_date");
                Boolean is_done =rs.getBoolean("is_done");
                Todo td = new Todo(title, description, target_date, username, is_done);
                tdList.add(td);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tdList;
    }

    @Override
    public boolean deleteToDo(int id) {
        boolean check = false;
        String DELETE_TODO = "delete from todos where id = ? ";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(DELETE_TODO);
            pr.setInt(1, id);
            check = pr.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public boolean editToDo(Todo td) {
        boolean check = false;
        String UPDATE_TODO = "update todos set title =?, description = ?, target_date =? where id=?  ";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(UPDATE_TODO);
            pr.setString(1, td.getTitle());
            pr.setString(2, td.getDescription());
            pr.setDate(3, (Date) td.getTarget_date());
            pr.setInt(4, td.getId());
            check = pr.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }

}
