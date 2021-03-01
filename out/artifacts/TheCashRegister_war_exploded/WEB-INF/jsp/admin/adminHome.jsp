<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jspf/taglib/taglib.jspf" %>
<html>
<head>
    <title>Cashier</title>
</head>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<style>
    <%@include file="/style/adminPage.css" %>
</style>


<form action="controller" method="post">
    <div id="nameDiv" class="input">
        <input type="hidden" name="command" value="create employee">
        Name: <input name="name"/>
        Last name: <input name="surname">
        <br><br>
        Set login: <input name="login">
        <br><br>
        Create password: <input name="password"><x></x>
        <br><br>
    </div>
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


<br><br>


<script>
    src = "https://code.jquery.com/jquery-3.5.1.min.js"
    integrity = "sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
    crossorigin = "anonymous"</script>

<script type="text/javascript">

</script>



<form name="showEmployeesForm" action="controller" method="post">
    <input type="hidden" name="command" value="get employees">
    <input id="show" type="submit" value="Show all employees"/>
</form>

<form name="showEmployeesForm" action="controller" method="post">
    <input type="hidden" name="command" value="logout">
    <input id="logout" type="submit" value="Logout"/>
</form>

<br><br>

<form name="showEmployeesForm" action="controller" method="post">
    <input type="hidden" name="command" value="delete employees"> Delete employee by №:
    <input type="number" name="id"/>
    <input id="delete" type="submit" value="Delete"/>
</form>

<div id="tableEmployees">
    <%@include file="employees.jsp"%>>
</div>

</body>
</html>


