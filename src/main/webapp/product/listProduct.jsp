<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/8/2021
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach san pham</title>
    <style>
        table {
            text-align: center;
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even){background-color: #f2f2f2}
        th {
            background-color: #4CAF50;
            color: white;
        }
        button{
            border-radius: 8px;
            background: aqua;
        }
        body{
            text-align: center;
        }
    </style>
</head>
<body>

<h2>
    <a href="/product?action=create">Thêm sản phẩm mới</a>
</h2>

<form action="/product?action=search" method="post">
    <input type="text" placeholder="Tìm kiếm" name="name">
    <button>Nhập</button>
</form>

<table>
    <tr>
        <th>ID </th>
        <th>Tên Sp</th>
        <th>Giá bán</th>
        <th>Số lượng</th>
        <th>Màu sắc</th>
        <th>Mô tả</th>
        <th>Danh mục</th>
        <th colspan="2">Action</th>

    </tr>
    <c:forEach items='${requestScope["productList"]}' var="p">
        <tr>
            <td>${p.getId()}</td>
            <td><a href="/product?action=view&id=${p.getId()}">${p.getName()}</a></td>
            <td>${p.getPrice()}</td>
            <td>${p.getQuantity()}</td>
            <td>${p.getColor()}</td>
            <td>${p.getDescription()}</td>
            <td>${p.getCategory().getName()}</td>
            <td><a href="/product?action=edit&id=${p.getId()}">Chỉnh sửa</a></td>
            <td><a href="/product?action=delete&id=${p.getId()}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
