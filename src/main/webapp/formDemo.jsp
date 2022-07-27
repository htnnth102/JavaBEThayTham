<%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUSPC
  Date: 7/27/2022
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Demo</title>
</head>
<body>
    <div class="container">
        <h1>Thêm mới học viên</h1>
        <form action="formSaveData.jsp">
            <table>
                <tr>
                    <td>Mã học viên</td>
                    <td><input name="id" type="text"></td>
                </tr>
                <tr>
                    <td>Họ tên</td>
                    <td><input name="name" type="text"></td>
                </tr>
                <tr>
                    <td>Lớp</td>
                    <td>
                        <select name="_class" id="class">
                            <option value="T2101E">T2101E</option>
                            <option value="T2108A">T2108A</option>
                            <option value="T2111M">T2111M</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Giới tính</td>
                    <td>
                        Male: <input type="radio" name="sex" value="male">
                        Female: <input type="radio" name="sex" value="female">
                    </td>
                </tr>
                <tr>
                    <td>Môn học</td>
                    <td>
                        Java: <input type="checkbox" name="subject" value="java">
                        HTML: <input type="checkbox" name="subject" value="HTML" checked>
                        PHP: <input type="checkbox" name="subject" value="PHP">
                        MySQL : <input type="checkbox" name="subject" value="MySQL">
                    </td>
                </tr>
            </table>
            <button type="submit">Kiểm tra thông tin</button>
        </form>

     </div>
</body>
</html>
