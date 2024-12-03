package EdujiraiFellow.steps;

import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.ProjectTestPage;
import EdujiraiFellow.pages.TaskPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.ru.Затем;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSeleniumATHomeworkSteps {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();
    private final TaskPage taskPage = new TaskPage();

    @Когда("^авторизуемся в системе, вводя логин '(.*)' и пароль '(.*)', нажимаем кнопку входа")
    public void login(String login, String password) {
        loginPage.loginIntoEdujira(login, password);
    }

    @Тогда("^появляются опции пользователя и список проектов")
    public void checkLogin() {
        dashboardPage.checkLogin();
    }

    @Затем("^выбираем из списка проект TEST")
    public void getIntoTest() {
        dashboardPage.getIntoTest();
    }

    @Тогда("^появляется боковая панель со списком задач")
    public void checkInTest() {
        projectTestPage.checkInTest();
    }

    @Затем("^в поле поиска вводим '(.*)' и переходим в задачу")
    public void quickSearch(String request) {
        dashboardPage.quickSearch(request);
    }

    @И("^проверяем, что установлен Статус: '(.*)' и Исправить в версиях: '(.*)'")
    public void checkStatus(String status, String version) {
        String actualStatus = taskPage.parseStatus();
        String actualVersion = taskPage.parseVersion();
        assertEquals(status, actualStatus);
        assertEquals(version, actualVersion);
    }
}
