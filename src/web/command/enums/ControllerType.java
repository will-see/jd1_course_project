package web.command.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import web.command.Controller;
import web.command.impl.*;

@Getter
@AllArgsConstructor
public enum ControllerType {
    LOGIN("login.jsp", "Login","login.title", new LoginController()),
    LOGOUT("login.jsp", "Logout", "logout.title",new LogoutController()),
//    FORMULAR("formular/main.jsp", "Formular","formular.title", new FormularController()),
    FORMULAR("formular/main.jsp", "Formular","formular.title", new FormularDtoController()),
    BOOKS("books/main.jsp", "Books", "books.title",new BookController()),
    REGISTER("register.jsp", "Register", "register.title", new RegisterController());
//    USERS("users/main.jsp", "Users", "users.title", new UsersController());

    private String pagePath;
    private String pageName;
    private String i18nKey;
    private Controller controller;

    public static ControllerType getByPageName(String page) {
        for (ControllerType type : ControllerType.values()) {
            if (type.pageName.equalsIgnoreCase(page)) {
                return type;
            }
        }
// Если ничего не найдено, то на главную страницу с продуктами
        return BOOKS;
    }
}
