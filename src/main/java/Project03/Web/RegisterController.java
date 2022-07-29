package Project03.Web;

import Project03.DAO.UserDao;
import Project03.Model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

//Truong hop nay chi xu ly dang ky
@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao ud;
    public RegisterController() {
        super();
    }
    public void init(ServletConfig config) {
        ud = new UserDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //to do auto-generated method stub
        // neu ai do go Register se ep ve trang register
        processRegister(request, response);
        response.getWriter().append("Register...");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRegister(request, response); // xu ly neu nguoi dung nhap form dang ky
        response.getWriter().append("Register...");
    }

    private void processRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("username");
        String pass01 = request.getParameter("password");
        String pass02 = request.getParameter("retypedPassword");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        Users u = new Users(firstName, lastName, userName, pass01);
        int n = new UserDao().registerUser(u);
        response.getWriter().append(u.getFirst_name());
    }
}
