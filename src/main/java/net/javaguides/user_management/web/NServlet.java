package net.javaguides.user_management.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "NServlet", value = "/NServlet")
public class NServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
