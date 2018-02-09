<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<TABLE>
    <tr>
        <th>Order Id</th>
        <th>User id</th>
        <th>Sum</th>
    </tr>

    <c:forEach var="formular" items="${formular}" >
        <tr>
            <td>${formular.formularId}</td>
            <td>${formular.userId}</td>
            <td>${formular.bookId}</td>
        </tr>
    </c:forEach>
    <%--<c:forEach var="book" items="${books}" varStatus="status">--%>
        <%--<tr class="info">--%>
            <%--<td class="col-md-1">${book.name}</td>--%>
            <%--<div class="col-md-2">--%>
                <%--<td class="col-md-1">${book.ganr}</td>--%>
                <%--<td class="col-md-1">${book.bookCount}</td>--%>
                    <%--&lt;%&ndash;<td class="col-md-1"><input id="${product.id}" class="btn-primary addProductBtn" type="button" title="Добавить в корзину" value="+"/></td>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<td class="col-md-1"><input id="${product.id}" class="btn-primary reduceProductBtn" type="button" title="Удалить 1 из корзину" value="-"/></td>&ndash;%&gt;--%>
            <%--</div>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
</TABLE>
