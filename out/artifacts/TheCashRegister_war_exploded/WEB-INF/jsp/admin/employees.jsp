<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jspf/taglib/taglib.jspf" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="main-container">

    <tr>
        <td>
            <c:choose>
                <c:when test="${fn:length(employeesBeanList) == 0}"> </c:when>

                <c:otherwise>
                    <table id="employee_table">
                        <thead>
                        <tr>
                            <td>№</td>
                            <td>Login</td>
                            <td>Password</td>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Role</td>
                            <td>Locale</td>
                        </tr>
                        </thead>

                        <c:forEach var="bean" items="${employeesBeanList}">

                            <tr>
                                <td>${bean.id}</td>
                                <td>${bean.login}</td>
                                <td>${bean.password}</td>
                                <td>${bean.name}</td>
                                <td>${bean.surname}</td>
                                <td>${bean.role}</td>
                                <td>${bean.locale}</td>
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
