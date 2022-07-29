<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUSPC
  Date: 7/28/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--????Can bo sung phan tim kiem truoc khi update de hien thi du lieu cu cua user qua--%>
<%--   action xac dinh doi tuong duoc gui data sang de xu ly--%>
    <form name="form_update" action="update" method="post">
         <input type="text" name="id" id="i2d" value="${user.id}" readonly placeholder=""><br/>
         <input type="text" name="name" id="nam2e" value="${user.name}" placeholder="Name"><br/>
         <input type="text" name="email" id="ema2il" value="${user.email}" placeholder="Email"><br/>
         <input type="text" name="country" id="cou2ntry"  value="${user.country}" placeholder="Country"><br/>
        <button type="submit">UPDATE</button>
    </form>

<%--<sql:setDataSource var="dbDemo" driver="com.mysql.jdbc.Driver"--%>
<%--                   url = "jdbc:mysql://localhost/demo" user="root" password="motconvit"/>--%>
<%--<c:set var="vName" value="${param.name}"></c:set>--%>
<%--<c:set var="vEmail" value="${param.email}"></c:set>--%>
<%--<c:set var="vCountry" value="${param.country}"></c:set>--%>
<%--<c:set var="vId" value="${param.id}"></c:set>--%>

<%--<sql:update dataSource="${dbDemo}" var="count">--%>
<%--    UPDATE user SET name=?, email=?, country=? where id=?--%>
<%--    <sql:param value="${vName}" />--%>
<%--    <sql:param value="${vEmail}" />--%>
<%--    <sql:param value="${vCountry}}" />--%>
<%--</sql:update>--%>

<%--<c:choose>--%>
<%--    <c:when test = "${count > 0}">--%>
<%--        OK--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        Not OK--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>

</body>
</html>
