<%--
  Created by IntelliJ IDEA.
  User: Pavilion
  Date: 25.02.2021
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="command" value="create category">Write name of category
    <input name="name"/>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
