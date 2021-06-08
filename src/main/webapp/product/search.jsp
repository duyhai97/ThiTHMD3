<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/8/2021
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<fielset>
    <legend>Thông tin sản phẩm</legend>
    <table>
        <tr>
            <td>Tên Sản phẩm:</td>
            <td>${requestScope["product"].getName()}</td>
        </tr>
        <tr>
            <td>Giá bán:</td>
            <td>${requestScope["product"].getPrice()}</td>
        </tr>
        <tr>
            <td>Số lượng:</td>
            <td>${requestScope["product"].getQuantity()}</td>
        </tr>
        <tr>
            <td>màu sắc:</td>
            <td>${requestScope["product"].getColor()}</td>
        </tr>
        <tr>
            <td>Mô tả:</td>
            <td>${requestScope["product"].getDescription()}</td>
        </tr>
        <tr>
            <td>Danh mục:</td>
            <td>${requestScope["product"].getCategory().getName()}</td>
        </tr>

    </table>
</fielset>

</body>
</html>
