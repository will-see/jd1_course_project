<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div>
    Товары
    <div class="bookTable">
        <c:forEach var="book" items="${books}">
            <div id="${book.bookId}">${book.name}</div>
        </c:forEach>
    </div>
</div>




