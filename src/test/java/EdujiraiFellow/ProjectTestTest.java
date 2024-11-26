package EdujiraiFellow;

import EdujiraiFellow.pages.DashboardPage;
import EdujiraiFellow.pages.LoginPage;
import EdujiraiFellow.pages.ProjectTestPage;
import org.junit.jupiter.api.Test;

public class ProjectTestTest extends WebHooks {
    private final LoginPage loginPage = new LoginPage();
    private final ProjectTestPage projectTestPage =
            new ProjectTestPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void getToTest() {
        loginPage.loginIntoEdujira(loginPage.login, loginPage.password);
        dashboardPage.checkLogin();
        dashboardPage.getIntoTest();
        projectTestPage.checkInTest();
    }



}
