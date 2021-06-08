<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/8/2021
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm mới</title>
</head>
<body>

<form  method="post">
<%--    <c:if test='${requestScope["message"] != null}'>--%>
<%--        <h2 class="message">${requestScope["message"]}</h2>--%>
<%--    </c:if>--%>
    <table>
        <tr>
            <td>Tên sản phẩm:</td>
            <td><input type="text" name="name" ></td>
        </tr>
        <tr>
            <td>Giá bán:</td>
            <td><input type="text" name="price" ></td>
        </tr>
        <tr>
            <td>Số lượng:</td>
            <td><input type="text" name="quantity" ></td>
        </tr>

        <tr>
            <td>Màu sắc:</td>
            <td><input type="text" name="color" ></td>
        </tr>

        <tr>
            <td>Mô tả:</td>
            <td><input type="text" name="description" ></td>
        </tr>
        <tr>

            <td> Danh mục</td>
            <td>
                <select name="category_id" >
                    <c:forEach var="c" items="${categoryList}">
                        <option value="${c.getId()}">${c.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Thêm mới"></td>
        </tr>
    </table>
</form>

</body>
</html>
