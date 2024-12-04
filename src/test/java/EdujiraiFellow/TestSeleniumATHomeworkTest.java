package EdujiraiFellow;

import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.TaskPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSeleniumATHomeworkTest extends WebHooks {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final TaskPage taskPage = new TaskPage();

    private final String login = "AT16";
    private final String password = "Qwerty123";
    private final String request = "TestSeleniumATHomework";
    private final String status = "СДЕЛАТЬ";
    private final String version = "Version 2.0";

    @Test
    public void taskStatusCheck() {
        loginPage.loginIntoEdujira(login, password);
        dashboardPage.checkLogin();
        dashboardPage.getIntoTest();
        dashboardPage.quickSearch(request);
        assertEquals(status, taskPage.parseStatus());
        assertEquals(version, taskPage.parseVersion());
    }
}
