package Project03.Web;

import Project03.DAO.LoginDAO;
import Project03.Model.Login;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import jdk.jpackage.internal.Log;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionId = 1L;
    private LoginDAO lg;

    public LoginController() {

    }
    // role == user ->
    public void init(javax.servlet.ServletConfig config) {
        lg = new LoginDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void processLogin(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        Login login = new Login(username, pass);
        LoginDAO loginDAO = new LoginDAO();
        if (loginDAO.checkLogin(login)) {
            request.getSession().invalidate();//huy toan bo cac session hien tai
            HttpSession session = request.getSession();
            session.setAttribute("user_name", login.getUsername());
            session.setMaxInactiveInterval(200);
            RequestDispatcher rd = request.getRequestDispatcher("Project03/todo/todo.jsp");
//            forward la url giu nguyen, chi forword noi dung sang
//            Send Direct la chuyen huong url
//            role == user -> sendDirect to homepage
            rd.forward(request, response);
        } else {
            response.sendRedirect("Project03/login/login.jsp");
        }
    }


}
