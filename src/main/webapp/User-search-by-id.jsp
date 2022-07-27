<%@ page import="net.javaguides.user_management.dao.UserDao" %>
<%@ page import="net.javaguides.user_management.model.Users" %><%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUSPC
  Date: 7/27/2022
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Search User</title>
</head>
<body>
    <form action="Search-rs.jsp" class="container">
        <label for="searchID">Type ID to search</label>
        <input type="number" name="searchID" id="searchID">
        <button type="submit">SEARCH</button>
    </form>
</body>
</html>
