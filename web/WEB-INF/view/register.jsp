<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <form action="frontController?command=login" method="post">
        <fmt:setLocale value="${sessionScope.locale}"/>
        <fmt:setBundle basename="messages" var="i18n"/>
        <br>
        <b>Name</b><br>
        <input type="name" name="name" maxlength="20"/>
        <br>
        <b>Login</b><br>
        <input type="login" name="login" maxlength="30"/>
        <br>
        <b>Password</b><br>
        <input type="password" name="password" maxlength="20"/>
        <br>
        <b>Age</b><br>
        <input type="age" name="age" maxlength="20"/>
        <br>
        <b>Sex</b><br>
        <input type="sex" name="sex" maxlength="20"/><br/>
        <br>
        <input type="submit" value="<fmt:message bundle="${i18n}" key="login.register"/>">
    </form>
</div>
