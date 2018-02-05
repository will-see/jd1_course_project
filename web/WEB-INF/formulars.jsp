<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<TABLE>
    <tr>
        <th>№</th>
        <th>User id</th>
        <th>Book Id</th>
    </tr>
    <c:forEach var="order" items="${orders}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${formular.formularId}</td>
            <td>${formular.userId}</td>
        </tr>
    </c:forEach>
</TABLE>
</body>
</html>
