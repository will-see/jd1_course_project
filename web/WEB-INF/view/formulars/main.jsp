<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<TABLE>
    <tr>
        <th>Formular Id</th>
        <th>User id</th>
    </tr>

    <c:forEach var="formular" items="${formular}">
        <tr>
            <td>${formular.formularId}</td>
            <td>${formular.userId}</td>
        </tr>
    </c:forEach>
</TABLE>
