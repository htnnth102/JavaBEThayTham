package net.javaguides.user_management.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserController", value = "/")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/user/":
                    response.getWriter().append("Hien thi danh sach nguoi dung");
                    break;
                case "/user/new":
                    response.getWriter().append("Them nguoi dung moi");
                    break;
                case "/user/123":
                    response.getWriter().append("Chi tiet san pham 123");
                    break;
                default:
                    response.getWriter().append("Chay toi trang dang nhap");
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
