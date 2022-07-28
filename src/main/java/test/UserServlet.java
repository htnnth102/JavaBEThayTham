package test;

import net.javaguides.user_management.dao.UserDao;
import net.javaguides.user_management.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserDao userDao;

//    private UserServlet() {
//
//    }


    public UserServlet() {
    }

        public void init() {
        userDao = new UserDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.getWriter().append("Server at: ").append(request.getContextPath());
        String action = request.getServletPath();
        try {
            switch (action) {
//                case "/UserServlet":
//                    response.getWriter().append("You are at Servlet");
//                    break;
                case "/view":
                    listAllUsers(request, response);
                    break;
                case "/new":
                    response.getWriter().append("You are at a new page");
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                default:
                    response.getWriter().append("You are at home page");
                    break;
            }
        }
        catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }

    public void listAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> lstUsers = new UserDao().SelectAllUsers();
        request.setAttribute("lstUsers", lstUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("User-form.jsp");
        dispatcher.forward(request, response);
    }

    public void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        Users u = new Users(name, email, country);
        response.sendRedirect("list");

    }
}
