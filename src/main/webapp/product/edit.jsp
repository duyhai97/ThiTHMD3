<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/8/2021
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


h1>Sửa sanr phaamr</h1>
<%--<h3><a href="/student">Quay lại</a></h3>--%>

<%--<c:if test='${requestScope["message"] != null}'>--%>
<%--    <span class="message">${requestScope["message"]}</span>--%>
<%--</c:if>--%>

<form  method="post">
    <table>
        <tr>
            <td>Tên sản phẩm:</td>
            <td><input type="text" name="name"  value="${requestScope["product"].getName()}"></td>
        </tr>
        <tr>
            <td>Giá bán:</td>
            <td><input type="text" name="price" id="" value="${requestScope["product"].getPrice()}"></td>
        </tr>
        <tr>
            <td>Số lượng: </td>
            <td><input type="text" name="quantity" id="address" value="${requestScope["product"].getQuantity()}"></td>
        </tr>
        <tr>
            <td>màu sắc: </td>
            <td><input type="text" name="color" value="${requestScope["product"].getColor()}"></td>
        </tr>
        <tr>
            <td>mô tả: </td>
            <td><input type="text" name="description"  value="${requestScope["product"].getDescription()}"></td>
        </tr>
        <tr>
            <td>Danh mục:</td>
            <td>
                <select name="category_id" >
                    <c:forEach items="${categoryList}" var="c">
                        <option value="${c.getId()}">${c.getName()}</option>
                    </c:forEach>

                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Nhấn đê :v"></td>
        </tr>
    </table>
</form>

</body>
</html>
