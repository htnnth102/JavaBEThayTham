<%@ page import="net.javaguides.user_management.dao.UserDao" %>
<%@ page import="net.javaguides.user_management.model.Users" %><%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUSPC
  Date: 7/27/2022
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User insert form</title>
</head>
<body>
    <form action="User-insert-form.jsp">
        <div class="mb-3">
            <label for="fullname" class="form-label">Name</label>
            <input type="text" class="form-control" id="fullname"  name="fullname" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" class="form-control" id="email"  name="email" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="country" class="form-label">Country</label>
            <input type="text" class="form-control" id="country"  name="country" aria-describedby="emailHelp">
        </div>
        <button type="submit">SEND</button>
    </form>

<%--    get data of user --%>

</body>
</html>
<%
    String name = request.getParameter("fullname");
    String email = request.getParameter("email");
    String country = request.getParameter("country");
    if (name != null ) {
        UserDao ud = new UserDao();
        Users u = new Users(name, email, country);
        ud.InsertUser(u);
    }

%>