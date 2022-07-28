<%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUSPC
  Date: 7/28/2022
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Userlist JSTL</title>
</head>
<body>
    <header>
        <nav class="navbar nav-bar-expand-md navbar-dark" style="background-color: tomato">
            <div><a href="http://google.com" class="navbar-brand">USER MANAGEMENT APP</a></div>
            <ul>
                <li><a href="<%=request.getContextPath()%>/User-list.jsp" class="nav-link">Users</a></li>
            </ul>
        </nav>
    </header>
    <sql:setDataSource var="dbDemo" driver="com.mysql.jdbc.Driver"
    url = "jdbc:mysql://localhost/demo" user="root" password="motconvit"/>
    <sql:query var="rs" dataSource="${dbDemo}">select * from users</sql:query>

    <form action="" class="container justify-content-center">
        <select name="country">
            <c:forEach var="opts" items="${rs.rows}">
                <option value="${opts.country}">${opts.country}</option>
            </c:forEach>
        </select>
        <button type="submit" class="btn btn-outline-primary">SEARCH</button>
    </form>
    <c:set var="country" value="${param.country}"></c:set>
    <c:choose>
        <c:when test="${country!=''}">
            <sql:query var="rs" dataSource="${dbDemo}">select * from users where country = ?
                <sql:param value="${country}"></sql:param>
            </sql:query>
        </c:when>
        <c:otherwise>
            <sql:query var="rs" dataSource="${dbDemo}">select * from users</sql:query>
        </c:otherwise>
    </c:choose>
    <table class="table container">
        <tr class="table-header">
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>
                Action
            </th>
        </tr>
        <c:forEach var="table" items="${rs.rows}">
            <tr>
                <td><c:out value="${table.id}"/> </td>
                <td><c:out value="${table.name}"/> </td>
                <td><c:out value="${table.email}"/> </td>
                <td><c:out value="${table.country}"/> </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
