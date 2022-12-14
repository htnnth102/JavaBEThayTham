<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUSPC
  Date: 7/27/2022
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page import="net.javaguides.user_management.dao.UserDao" %>
<%@ page import="net.javaguides.user_management.model.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.9.1/bootstrap-icons.svg"/>
    <title>$Title$</title>
</head>
<%
    String countryForSearch = request.getParameter("country");
%>


<body>
    <header>
        <nav class="navbar nav-bar-expand-md navbar-dark" style="background-color: tomato">
            <div><a href="http://google.com" class="navbar-brand">USER MANAGEMENT APP</a></div>
            <ul>
                <li><a href="<%=request.getContextPath()%>/User-list.jsp" class="nav-link">Users</a></li>
            </ul>
        </nav>
    </header>

    <table class="table">
        <tr class="table-header">
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
<%--        DUOI DAY LA DOAN MA CU 40-81--%>
<%--        <%--%>
<%--            UserDao ud = new UserDao();--%>
<%--            List<Users> lstUser = new ArrayList<>();--%>
<%--            if (countryForSearch == null) {--%>
<%--               lstUser = ud.SelectAllUsers();--%>

<%--            } else {--%>
<%--                lstUser = ud.SelectAllUsersByCountry(countryForSearch);--%>
<%--            }--%>
<%--            for (Users u : lstUser) {--%>
<%--        %>--%>
<%--        <tr>--%>
<%--            <td><%=u.getId()%></td>--%>
<%--            <td><%=u.getName()%></td>--%>
<%--            <td><%=u.getEmail()%></td>--%>
<%--            <td><%=u.getCountry()%></td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>
<%--    </table>--%>
<%--    <form action="User-form.jsp">--%>
<%--        <%--%>
<%--            List<Users> uList = new ArrayList<>();--%>
<%--            uList = ud.SelectAllUsers();--%>
<%--            Set<String> country = new TreeSet<>();--%>
<%--            for (Users u: uList) {--%>
<%--                country.add(u.getCountry());--%>
<%--            }--%>
<%--        %>--%>
<%--        <select name="country" id="country">--%>
<%--            <option value="" selected>Chon quoc gia</option>--%>
<%--            <%--%>
<%--                for (String c : country) {--%>
<%--            %>--%>
<%--            <option value="<%=c%>"><%=c%></option>--%>
<%--            <%--%>
<%--                }--%>
<%--            %>--%>
<%--        </select>--%>
<%--        <button type="submit">SEARCH</button>--%>
<%--    </form>--%>

            <c:forEach var="user" items="${listofUsers}">
               <tr>
                   <td>
                       <c:out value="${user.id}"/>
                   </td>
                   <td>
                       <c:out value="${user.name}"/>
                   </td>
                   <td>
                       <c:out value="${user.email}"/>
                   </td>
                   <td>
                       <c:out value="${user.country}"/>
                   </td>
                   <td>
                       <a href="edit?id=${user.id}"><i class="bi bi-pencil"></i></a>
                   </td>
                   <td>
                       <a><i class="bi bi-file-x"></i></a>
                   </td>
               </tr>
            </c:forEach>

    </table>

</body>
</html>

