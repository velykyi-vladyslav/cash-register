<%--
  Created by IntelliJ IDEA.
  User: Pavilion
  Date: 21.02.2021
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/style/cashierPage.css" %>
    </style>
</head>
<body>
<table id="functional">
    <tr>
        <td>
            <button onclick=show("createReceipt")>Make receipt</button>
        </td>

    </tr>
</table>

<div id="createReceipt">
    <%@include file="createReceipt.jsp"%>
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
</body>
</html>
