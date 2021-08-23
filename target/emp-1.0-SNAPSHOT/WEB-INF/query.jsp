
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>empNo</td>
        <td>eName</td>
        <td>job</td>
        <td>mgr</td>
        <td>hireDate</td>
        <td>sal</td>
        <td>comm</td>
        <td>delete</td>
    </tr>
    <c:forEach var="emp" items="${emp}">
        <tr>
            <td>${emp.empNo}</td>
            <td>${emp.eName}</td>
            <td>${emp.job}</td>
            <td>${emp.mgr}</td>
            <td>${emp.hireDate}</td>
            <td>${emp.sal}</td>
            <td>${emp.comm}</td>
            <td><a href="delete?empNo=${emp.empNo}">delete</a></td>
            <td><a href="findByEmpNo?empNo=${emp.empNo}">update</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="add">添加新用户</a>
</body>
</html>
