<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <form action="frontController?command=login" method="post">
        <br>
        <b>Name</b><br>
        <input type="password" name="password" maxlength="20"/>
        <br>
        <b>Login</b><br>
        <input type="text" name="UserName" maxlength="30"/>
        <br>
        <b>Password</b><br>
        <input type="password" name="password" maxlength="20"/>
        <br>
        <b>Age</b><br>
        <input type="password" name="password" maxlength="20"/>
        <br>
        <b>Sex</b><br>
        <input type="password" name="password" maxlength="20"/><br/>
        <br>
        <input type="submit" value="Зарегистрироваться">
    </form>
</div>
