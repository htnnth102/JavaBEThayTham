<%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUSPC
  Date: 7/27/2022
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUS PC
  Date: 7/27/2022
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sava Data</title>
</head>
<body>
    <%
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String _class = request.getParameter("class");
        String sex = request.getParameter("sex");
        String[] sj = request.getParameterValues("subject");
        String str = Arrays.toString(sj);
        String str2 = str.substring(0, str.lastIndexOf(","));
    %>
    <table>
        <tr>
            <td>Ma hoc vien</td>
            <td><input value="<%out.println(id);%>"></td>
        </tr>
        <tr>
            <td>Ho ten</td>
            <td><input value="<%out.println(name);%>"></td>
        </tr>
        <tr>
            <td>Lop</td>
            <td><input value="<%out.println(_class);%>"></td>
        </tr>
        <tr>
            <td>Gioi tinh</td>
            <td><input value="<%out.println(sex);%>"></td>
        </tr>
        <tr>
            <td>Mon hoc</td>
            <td><input value="<%out.println(str2);%>"></td>
        </tr>
        <button type="submit">Luu thong tin</button>



    </table>
</body>
</html>
