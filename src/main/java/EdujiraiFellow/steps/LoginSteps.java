package EdujiraiFellow.steps;

import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.DashboardPage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Когда("^в поля логина и пароля введены логин '(.*)' и пароль '(.*)' и нажата кнопка входа")
    public void login(String login, String password) {
        loginPage.loginIntoEdujira(login, password);
    }

    @Тогда("^опции пользователя становятся видны")
    public void verifyLogin() {
        dashboardPage.checkLogin();
    }
}
