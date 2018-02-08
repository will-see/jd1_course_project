<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div>
    <div class="container-fluid">
        <div class="col-md-3">Книги</div>
        <table class="table">
            <tr>
                <th class="col-md-1">Supplier</th>
                <div class="col-md-2">
                    <th class="col-md-1">Model</th>
                    <th class="col-md-1">Quantity</th>
                    <%--<th class="col-md-1">Price</th>--%>
                    <%--<th class="col-md-1"></th>--%>
                </div>
            </tr>
            <script>
                function callAlert(bookId) {
                    alert(bookId);
                }
            </script>
            <c:forEach var="book" items="${books}" varStatus="status">
                <tr class="info">
                    <td class="col-md-1">${book.name}</td>
                    <div class="col-md-2">
                        <td class="col-md-1">${book.ganr}</td>
                        <td class="col-md-1">${book.bookCount}</td>
                        <%--<td class="col-md-1"><input id="${product.id}" class="btn-primary addProductBtn" type="button" title="Добавить в корзину" value="+"/></td>--%>
                        <%--<td class="col-md-1"><input id="${product.id}" class="btn-primary reduceProductBtn" type="button" title="Удалить 1 из корзину" value="-"/></td>--%>
                    </div>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>


