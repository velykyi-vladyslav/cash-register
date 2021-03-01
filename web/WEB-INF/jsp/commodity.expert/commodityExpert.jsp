<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cash Register</title>
    <style>
        <%@include file="/style/commodityExpertPage.css" %>
    </style>
</head>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<script>

</script>

<table id="functional">
    <tr>
        <td>
            <button onclick=show("productsTable")>Show/Hide products</button>
        </td>

        <td>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="show products">
                <input type="submit" value="Reload product list" onclick='showDefault("productsTable")'/>
            </form>
        </td>
        <td>
            <button onclick=show("additionForm")>Add product</button>
        </td>
        <td>
            <button onclick=show("deleteForm")>Delete product</button>
        </td>
        <td>
            <button onclick=show("creationCategory")>Create product`s category</button>
        </td>
    </tr>
</table>
<br><br>
<div id="productsTable">
    <%@include file="products.jsp"%>
</div>
<div id="additionForm">
    <%@include file="addition.jsp"%>
</div>
<div id="deleteForm">
    <%@include file="delete.jsp"%>
</div>
<div id="creationCategory">
    <%@include file="create.jsp"%>
</div>

<script>
    function show(formName) {
        const x = document.getElementById(formName);
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
</script>

<script>
    function show(formName) {
        const x = document.getElementById(formName);
        if (x.style.display === "block") {
            x.style.display = "none";
        } else {
            x.style.display = "block";
        }
    }
</script>

<script>
    function showDefault(formName) {
        const x = document.getElementById(formName);
        if (x.style.display === "block") {
            x.style.display = "none";
        } else {
            x.style.display = "block";
        }
    }
</script>
</body>
</html>
