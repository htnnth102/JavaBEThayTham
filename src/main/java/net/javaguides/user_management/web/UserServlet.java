package net.javaguides.user_management.web;

import jakarta.servlet.annotation.WebServlet;
import net.javaguides.user_management.dao.UserDao;
import net.javaguides.user_management.model.Users;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserDao userDao;

    private UserServlet() {
        super();
    }

    public void init() {
        userDao = new UserDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().append("Server at: ").append(request.getContextPath());
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/UserServlet":
                    response.getWriter().append("You are at Servlet");
                    break;
                case "/new":
                    response.getWriter().append("You are at a new page");
                    break;
                default:
                    response.getWriter().append("You are at home page");
                    break;
            }
        }
        catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void listAllUsers(HttpServletRequest request, HttpServletResponse response) {
        List<Users> lstUsers = new UserDao().SelectAllUsers();

    }
}
