package EdujiraiFellow;

import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.ProjectTestPage;
import org.junit.jupiter.api.Test;

public class ProjectTestTest {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();

    private final String login = "AT16";
    private final String password = "Qwerty123";

    @Test
    public void getToTest() {
        loginPage.loginIntoEdujira(login, password);
        dashboardPage.checkLogin();
        dashboardPage.getIntoTest();
        projectTestPage.checkInTest();
    }
}
