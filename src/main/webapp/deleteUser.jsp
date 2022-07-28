<%@ page import="net.javaguides.user_management.model.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.javaguides.user_management.dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.TreeSet" %><%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUSPC
  Date: 7/28/2022
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Delete</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%
    String countryForSearch = request.getParameter("country");
%>

<header>
    <nav class="navbar nav-bar-expand-md navbar-dark" style="background-color: tomato">
        <div><a href="http://google.com" class="navbar-brand">USER MANAGEMENT APP</a></div>
        <ul>
            <li><a href="<%=request.getContextPath()%>/User-list.jsp" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<form action="deleteUser.jsp" method="posts">
<table class="table">

    <tr class="table-header">
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Action</th>
    </tr>
    <%
        UserDao ud = new UserDao();
        List<Users> lstUser = new ArrayList<>();
        if (countryForSearch == null) {
            lstUser = ud.SelectAllUsers();

        } else {
            lstUser = ud.SelectAllUsersByCountry(countryForSearch);
        }
        for (Users u : lstUser) {
    %>
    <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getName()%></td>
        <td><%=u.getEmail()%></td>
        <td><%=u.getCountry()%></td>
<%--        Duoi day la code de xoa 1 row user--%>
<%--        <td><button class="btn btn-outline-danger"><a href="deleteUser.jsp?id=<%=u.getId()%>">Delete</a></button>--%>
<%--        </td>--%>

<%--        Day la code de xoa nhieu users--%>
        <td>
            <input type="checkbox" name="deleteUser" value="<%=u.getId()%>"/>
        </td>
    </tr>
    <%
        }
    %>
</table>
    <button class="btn btn-outline-danger" type="submit">DELETE</button>
</form>
<form action="User-form.jsp">
    <%
        List<Users> uList = new ArrayList<>();
        uList = ud.SelectAllUsers();
        Set<String> country = new TreeSet<>();
        for (Users u: uList) {
            country.add(u.getCountry());
        }
    %>
    <select name="country" id="country">
        <option value="" selected>Chon quoc gia</option>
        <%
            for (String c : country) {
        %>
        <option value="<%=c%>"><%=c%></option>
        <%
            }
        %>
    </select>
    <button type="submit">SEARCH</button>
</form>

</body>
</html>

<%
//    String idToDelete = request.getParameter("idToDelete");
//    boolean check = ud.DeleteUser(Integer.parseInt(idToDelete));
//    if (check) {
//        out.println("Delete Done");
//    } else {
//        out.println("Can not delete");
//    }
    if (request.getParameter("id") != null) {

        int id = Integer.parseInt(request.getParameter("id"));
        ud.DeleteUser(id);
    }
%>

<%
    String[] check = request.getParameterValues("deleteUser");
    if (check != null) {
        for (int i = 0; i < check.length; i++) {
            ud.DeleteUser(Integer.parseInt(check[i]));
        }
    }

%>
