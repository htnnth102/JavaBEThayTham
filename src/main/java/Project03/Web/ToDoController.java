package Project03.Web;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.*;

import java.io.IOException;

@WebServlet(name = "ToDoController", value = "/todo")
public class ToDoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ToDoController() {

    }

    public void init(javax.servlet.ServletConfig config) {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Mot ben set mot ben get
        HttpSession session = request.getSession();
        response.getWriter().append(session.getId().toString());
//        if (session == null) {
//            RequestDispatcher rd = request.getRequestDispatcher("Project03/login/login.jsp");
//            rd.forward(request, response);
//        } else {
//            response.sendRedirect("Project03/todo/todo.jsp");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
