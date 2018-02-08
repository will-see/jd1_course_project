<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container text-center">
    <div class="error">${errorMsg}</div>

    <form action="frontController?command=login" method="post">
        <b>Login</b><br>
        <input type="text" name="login" maxlength="30"/>
        <br>
        <b>Password</b><br>
        <input type="password" name="password" maxlength="20"/><br/>
        <br>
        <input type="submit" value="Войти">
    </form>

    <form action="frontController?command=register" method="post">
        <input type="submit" value="Зарегистрироваться">
    </form>
</div>
