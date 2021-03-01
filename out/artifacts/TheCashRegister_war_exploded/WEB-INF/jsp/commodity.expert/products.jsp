<%--
  Created by IntelliJ IDEA.
  User: Pavilion
  Date: 24.02.2021
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="main-container">

    <tr>
        <td>
            <c:choose>
                <c:when test="${fn:length(productsBeanList) == 0}"> </c:when>

                <c:otherwise>
                    <table id="employee_table">
                        <thead>
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>Category</td>
                            <td>Price</td>
                            <td>Count</td>
                        </tr>
                        </thead>

                        <c:forEach var="bean" items="${productsBeanList}">

                            <tr>
                                <td>${bean.id}</td>
                                <td>${bean.name}</td>
                                <td>${bean.category}</td>
                                <form action="controller" method="post">
                                    <input type="hidden" name="command" value="add product">
                                    <td><input value="${bean.price}"></td>
                                    <td><input value="${bean.quantity}"></td>
                                    <td><input type="submit" value="Update"></td>
                                </form>

                            </tr>

                        </c:forEach>
                    </table>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>

</table>
</body>
</html>
