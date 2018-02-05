<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<c:out value="<%" escapeXml="false"/>--%>
<c:set var="x" value="180" scope="page"/>
<head>
    <title>Forwarding test</title>
  </head>
  <body>
  <form action="nameservlet" style="display: block">
    Введите имя:
    <input name="name" type="text"><br/>
    Введите фамилиию:
    <input name="lastName" type="text"><br/>
    <input type="submit" value="Отправить"/>
  </form>

  <c:if test="${x gt 100}">
    <form action="CreateOrderForwardServlet">Создать заказ через <h2>forward</h2>
      Введите id пользователя:
      <input name="userId" type="text" value="${x}"/><br/>
      Введите id товара: <c:out value=" ${x}"/><br/>

      <input name="bookId" type="text"/><br/>
      <input type="submit" value="Создать заказ c Forward"/>
    </form>
  </c:if>
  <br/>
  <form action="redirect">Создать заказ через <h2>redirect</h2>
    Введите id пользователя:
    <input name="userId" type="text"/><br/>
    Введите id товара:
    <input name="booktId" type="text"/><br/>

    <input type="submit" value="Создать заказ c Redirect"/>
  </form>
  </body>
</html>
