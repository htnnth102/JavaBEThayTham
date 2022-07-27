<%@ page import="net.javaguides.user_management.dao.UserDao" %>
<%@ page import="net.javaguides.user_management.model.Users" %><%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUSPC
  Date: 7/27/2022
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
        <%
            String id = request.getParameter("searchID");
            int _id = Integer.parseInt(id);
            UserDao ud = new UserDao();
            Users u = ud.SelectUsersById(_id);
        %>
        <div class="container mt-5">
            <h3>User ID: <%=u.getId()%></h3>
            <h3>User name: <%=u.getName()%></h3>
            <h3>Email: <%=u.getEmail()%></h3>
            <h3>Country: <%=u.getCountry()%></h3>
        </div>

</body>
</html>
