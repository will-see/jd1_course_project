<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<tr>
    <th>Formular Id</th>
    <th>User id</th>
</tr>
<TABLE>
<%--<c:forEach var="formular" items="${formular}">--%>
<%--<tr>--%>
<%--<td>${formular.formularId}</td>--%>
<%--<td>${formular.userId}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
    <div class="bookTable">
        <c:forEach var="formular" items="${books}">
            <div id="${formular.bookId}">${formular.name}</div>
        </c:forEach>
    </div>
</TABLE>

