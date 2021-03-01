<%--
  Created by IntelliJ IDEA.
  User: Pavilion
  Date: 25.02.2021
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<form name="showEmployeesForm" action="controller" method="post">
    <input type="hidden" name="command" value="delete products"> Delete product by name:<br>
    <input name="name"/><br>Count:
    <input type="number" name="count"/>
    <input id="delete" type="submit" value="Delete"/>
</form>
<body>

</body>
</html>
