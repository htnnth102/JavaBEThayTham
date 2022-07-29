package net.javaguides.user_management.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import net.javaguides.user_management.dao.UserDao;
import net.javaguides.user_management.model.Users;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NServlet", value = "/NServlet")
public class NServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/userservlet":
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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @javax.servlet.annotation.WebServlet(name = "UserServlet", value = "/")
    public static class UserServlet extends javax.servlet.http.HttpServlet {
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
        protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
    //        response.getWriter().append("Server at: ").append(request.getContextPath());
            String action = request.getServletPath();
            // kiem tra URL chua yeu cau gi tu phia nguoi dung
            try {
                switch (action) {
    //                case "/UserServlet":
    //                    response.getWriter().append("You are at Servlet");
    //                    break;
                    case "/product":
                        response.getWriter().append("Ban dang muon hien thi danh sach san pham");
                        break;
                    case "/product/123":
                        response.getWriter().append("Ban dang muon hien thi chi tiet san pham co ma ID 123");
                        break;
                    case "/view":
                        listAllUsers(request, response);
                        break;
                    case "/new":
                        response.getWriter().append("You are at a new page");
                        break;
                    case "/insert":
                        insertUser(request, response);
                        break;
                    case "/edit":
                        int id = Integer.parseInt(request.getParameter("id"));
                        Users u = new UserDao().SelectUsersById(id);
                        request.setAttribute("user", u);
                        javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("Userlist_update_JSTL.jsp");
                        rd.forward(request, response);
                        break;
                    case "/update":
                        int uid = Integer.parseInt(request.getParameter("id"));
                        String name = request.getParameter("name");
                        String email = request.getParameter("email");
                        String country = request.getParameter("country");
                        Users users = new Users(uid, name, email, country);
                        new UserDao().UpdateUser(users);
                        response.sendRedirect(request.getContextPath()+"/list");
                        break;
                    case "/list":
                        listAllUsers(request, response);
                        break;
                }
            }
            catch (Exception e) {

            }
        }

        @Override
        protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
            doGet(request,response);
        }

        public void listAllUsers(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            List<Users> lstUsers = new UserDao().SelectAllUsers();
            request.setAttribute("listofUsers", lstUsers);
            javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("User-form.jsp");
            dispatcher.forward(request, response);
        }

        public void insertUser(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");

            Users u = new Users(name, email, country);
            userDao.InsertUser(u);
            response.sendRedirect("list");
        }

        public void updateUser(HttpServletRequest request, HttpServletResponse response) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");

            Users u = new Users(name, email, country);
        }

    }
}
