<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/8/2021
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <h3>Bạn chắc chắn muốn xóa</h3>
    <fieldset>
        <table>
            <tr>
                <td>Tên sp:</td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Giá bán</td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>

            <tr>
                <td>số lượng</td>
                <td>${requestScope["product"].getQuantity()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Xóa"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
