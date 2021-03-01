<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Product addition
<form action="controller" method="post">
    <input type="hidden" name="command" value="add product">
    Name: <input name="name" required/><br>
    Price: <input name="price" required/><br>
    Count: <input name="quantity" type="number" required/><br>
    Category: <select name="category" required>
    <c:forEach items="${categoriesBeanList}" var="category">
        <option selected="category">${category.name}</option>
    </c:forEach>

</select>
<%--     value="${category.id}" onclick=""--%>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
