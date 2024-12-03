package EdujiraiFellow.steps;

import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.ProjectTestPage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.ru.Затем;

public class GetToTestSteps {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();

    @Когда("^введены логин '(.*)' и пароль '(.*)' и нажата кнопка входа")
    public void login(String login, String password) {
        loginPage.loginIntoEdujira(login, password);
    }

    @Тогда("^становятся видны опции пользователя")
    public void verifyLogin() {
        dashboardPage.checkLogin();
    }

    @Затем("^переходим в проект TEST")
    public void getToTest() {
        dashboardPage.getIntoTest();
    }

    @Тогда("^боковая панель становится видна")
    public void checkInTest() {
        projectTestPage.checkInTest();
    }
}
