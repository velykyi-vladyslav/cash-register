<%--
  Created by IntelliJ IDEA.
  User: Pavilion
  Date: 20.02.2021
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cashier</title>
</head>
<body>
<form action="controller/" method="post">
    <input type="hidden" name="command" value="create employee">
    Name: <input name="name"/>
    <br><br>
    Last name: <input name="surname">
    <br><br>
    Set login: <input name="login">
    <br><br>
    Create password: <input name="password">
    <br><br>
    Select role: <input type="radio" name="role" value="cashier" checked/>Cashier
    <input type="radio" name="role" value="senior cashier"/>Senior cashier
    <input type="radio" name="role" value="commodity expert"/>Commodity expert
    <br><br>
    Locale <select name="locale">
    <option>English</option>
    <option>Ukrainian</option>
</select>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>


