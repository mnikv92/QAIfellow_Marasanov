package EdujiraiFellow;

import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.ProjectTestPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProjectTestTest extends WebHooks {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();

    private final String login = Config.get("login");
    private final String password = Config.get("password");

    @Test
    @DisplayName("Тестирование перехода в проект 'TEST'")
    public void getToTest() {
        loginPage.loginIntoEdujira(login, password);

        dashboardPage.checkLogin();
        dashboardPage.getIntoTest();
        projectTestPage.checkInTest();
    }
}
